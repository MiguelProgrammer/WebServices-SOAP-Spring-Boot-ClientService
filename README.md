# WebServices SOAP com <img src="https://devkico.itexto.com.br/wp-content/uploads/2014/08/spring-boot-project-logo-300x270.png" width="40"> Spring Boot
<img src="https://i.imgur.com/5onucdo.png" width="800"><br>

* VERSÃO CLIENTE SERVICE: Este projeto destina-se apenas a estudos de schemas xml, JaxB, xsd spring boot, para construção de serviços rest com webservices soap, apesar de, em termos tecnicos, xml seja or uma maioria defasado, ainda há organizações que lidam melhor com esta estrutura, melhor pelo fato de a refatoração de uma aplicação existênte para as tecnologias atuais seria de grande custo financeiro.

* Wsld gerado. Em tempos atuais, o arquivo wsdl, muitas das vezes é utilizado como nosso atual swagger para quem está familiarizado com o mundo spring, documento que é possível visualzar os serviços disponíveis, porta, os serviços disponíveis, os tipos de respostas e tipagens correta para construção das chamadas. <br>
  <img src="https://i.imgur.com/rCT2wn0.png" width="800">

<hr>
* <b>types</b>: Contem detalhes das requisições e respostas<br>
* <b>message</b>: Contem as troca de requisições e respostas<br>
* <b>portType</b>: Através de interface é possível chegar aos sevriços e implementações concretas<br>
* <b>bind</b>: Define a implementação, usamos o soap/http, o style="document" indica que estamos realizando requisições http completas, ou rpc, chamar serviço remoto, seria necessário definir parametros de entrada, autenticação. etc.<br>
* <b>service</b>: Endereço dsn onde os serviços soap estão disponíveis<br>
<hr>

* WSDL e SoapUI | requisições, utilizei a plataforma SoapUi para requisições e respostas <br>
  <img src="https://i.imgur.com/JoXqf1U.png" width="800"><br><br>

* Listando os Customers<br>
  <img src="https://i.imgur.com/GeuBozY.png" width="800"><br><br>

* Listando Customer por ID<br>
  <img src="https://i.imgur.com/pDAeFN9.png" width="800"><br><br>

* Deletando Customer por ID<br>
  <img src="https://i.imgur.com/3m3Ewug.png" width="800"><br><br>

* SecurityConfiguration, essa é a segurança aplicada aos serviços. Abaixo é listado uma request realizada sem autenticação realizada<br>
~~~
REQUEST:
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:mig="http://miguelprogrammer.com.br">
<soapenv:Header/>
<soapenv:Body>
  <mig:DeleteCustomerRequest>
     <mig:id>1</mig:id>
  </mig:DeleteCustomerRequest>
</soapenv:Body>
</soapenv:Envelope>


RESPONSE:
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
<SOAP-ENV:Header/>
<SOAP-ENV:Body>
  <SOAP-ENV:Fault>
     <faultcode>SOAP-ENV:Client</faultcode>
     <faultstring xml:lang="en">com.sun.xml.wss.XWSSecurityException: Message does not conform to configured policy [ AuthenticationTokenPolicy(S) ]:  No Security Header found; nested exception is com.sun.xml.wss.XWSSecurityException: com.sun.xml.wss.XWSSecurityException: Message does not conform to configured policy [ AuthenticationTokenPolicy(S) ]:  No Security Header found</faultstring>
  </SOAP-ENV:Fault>
</SOAP-ENV:Body>
~~~

* SecurityConfiguration, requeest com autenticação <br>
~~~
REQUEST: 
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:mig="http://miguelprogrammer.com.br">
   <soapenv:Header>
       <wsse:Security
        xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" 
        mustUnderstand="1">
            <wsse:UsernameToken>
                <wsse:Username>miguelProgrammer</wsse:Username>
                <wsse:Password>123456777</wsse:Password>
            </wsse:UsernameToken>
        </wsse:Security>
   </soapenv:Header>
   <soapenv:Body>
      <mig:GetCustomerDetailRequest>
         <mig:id>2</mig:id>
      </mig:GetCustomerDetailRequest>
   </soapenv:Body>
</soapenv:Envelope>

RESPONSE:
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:GetCustomerDetailResponse xmlns:ns2="http://miguelprogrammer.com.br">
         <ns2:CustomerDetail>
            <ns2:id>2</ns2:id>
            <ns2:name>Sula</ns2:name>
            <ns2:phone>11 9 5432-2345</ns2:phone>
            <ns2:email>sula@gmail.com</ns2:email>
         </ns2:CustomerDetail>
      </ns2:GetCustomerDetailResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
~~~~
