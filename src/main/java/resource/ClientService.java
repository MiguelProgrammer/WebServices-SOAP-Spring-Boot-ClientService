package resource;

import service.impl.CustomerServiceImpl;

public class ClientService {
    public static void main(String[] args) {

        CustomerServiceImpl customerService = new CustomerServiceImpl();

        /**
         * GET ALL CUSTOMERS
         */
        System.out.println("\nLIST ALL CUSTOMERS");
        customerService.allcustomer().stream().forEach(cs -> {
            System.out.println(cs.toString());
        });

        /**
         * FIND CUSTOMER BY ID
         */
        System.out.println("\nFIND CUSTOMER BY ID: " + customerService.findById(2).toString());

        /**
         * DELETE CUSTOMER BY ID
         */
        System.out.println("\nDELETE CUSTOMER: " + customerService.deleteById(3).toString());


        /**
         * GET ALL CUSTOMERS
         */
        System.out.println("\nLIST ALL CUSTOMERS");
        customerService.allcustomer().stream().forEach(cs -> {
            System.out.println(cs.toString());
        });
    }
}
