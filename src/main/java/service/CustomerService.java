package service;

import enums.StatusAction;
import model.Custumer;
import service.exception.CustomerNotFoundException;
import service.exception.FailureDeleteCustomerException;

import java.util.List;

public interface CustomerService {
    List<Custumer> allcustomer();
    Custumer findById(Integer id) throws CustomerNotFoundException;
    StatusAction deleteById(Integer id) throws FailureDeleteCustomerException;
}
