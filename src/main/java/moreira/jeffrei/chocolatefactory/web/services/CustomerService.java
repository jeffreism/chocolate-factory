package moreira.jeffrei.chocolatefactory.web.services;

import moreira.jeffrei.chocolatefactory.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getById(UUID id);

    CustomerDto saveNewCustomer(CustomerDto dto);

    void updateCustomer(UUID id, CustomerDto dto);

    void deleteCustomer(UUID id);
}
