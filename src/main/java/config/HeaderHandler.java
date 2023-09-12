package config;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

import static constants.ConstantsConfig.*;

public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {


    @Override
    public Set<QName> getHeaders() {return null;}

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean aBoolean = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if(aBoolean.booleanValue()){
            try {

                SOAPEnvelope soapEnvelope = context.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader soapHeader = soapEnvelope.getHeader();
                SOAPElement security = soapHeader.addChildElement(SECURITY, PREFIX, URI);

                SOAPElement usernameToken = security.addChildElement(USERNAME_TOKEN,PREFIX);

                SOAPElement username = usernameToken.addChildElement(USERNAME,PREFIX);
                username.addTextNode(USERNAME_VALUE);

                SOAPElement pass = usernameToken.addChildElement(PASS,PREFIX);
                pass.addTextNode(PASS_VALUE);

            } catch (SOAPException e) {
                throw new RuntimeException(e);
            }
        }
        return aBoolean;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {}
}

