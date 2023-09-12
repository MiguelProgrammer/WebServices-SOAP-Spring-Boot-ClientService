package config;

import miguelprogrammer.CustomerPort;
import miguelprogrammer.CustomerPortService;
public class GetConfig {

    private CustomerPort customerPort;
    public CustomerPort getConfig(){
        CustomerPortService portService = new CustomerPortService();
        HeaderHandlerResolver headerHandlerResolver = new HeaderHandlerResolver();
        portService.setHandlerResolver(headerHandlerResolver);
        CustomerPort customerPort = portService.getCustomerPortSoap11();
        return customerPort;
    }

}
