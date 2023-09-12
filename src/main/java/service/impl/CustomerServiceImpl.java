package service.impl;

import config.GetConfig;
import enums.StatusAction;
import miguelprogrammer.*;
import model.Custumer;
import service.CustomerService;
import service.exception.CustomerNotFoundException;
import service.exception.FailureDeleteCustomerException;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private GetConfig getConfig = new GetConfig();

    @Override
    public List<Custumer> allcustomer() {
        getConfig.getConfig();
        List<CustomerDetail> customerDetails = new ArrayList<>();
        List<Custumer> custumers = new ArrayList<>();
        GetAllCustomerDetailRequest request = new GetAllCustomerDetailRequest();
        GetAllCustomerDetailResponse response = getConfig.getConfig().getAllCustomerDetail(request);
        response.getCustomerDetail().forEach(cs -> {
            custumers.add(new Custumer(cs.getId(), cs.getName(), cs.getPhone(), cs.getEmail()));
        });
        return custumers;
    }

    @Override
    public Custumer findById(Integer id) throws CustomerNotFoundException {
        GetCustomerDetailRequest request = new GetCustomerDetailRequest();
        request.setId(id);
        return new Custumer().toCustomer(getConfig.getConfig().getCustomerDetail(request).getCustomerDetail());
    }

    @Override
    public StatusAction deleteById(Integer id) throws FailureDeleteCustomerException {
        DeleteCustomerRequest request = new DeleteCustomerRequest();
        request.setId(id);
        return getConfig.getConfig().deleteCustomer(request).getStatus().equals(Status.SUCCESS)
                ?StatusAction.SUCCESS : StatusAction.FAILURE;
    }


}
