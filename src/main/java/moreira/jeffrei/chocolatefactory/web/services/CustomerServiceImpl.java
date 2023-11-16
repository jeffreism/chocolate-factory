package moreira.jeffrei.chocolatefactory.web.services;

import lombok.extern.slf4j.Slf4j;
import moreira.jeffrei.chocolatefactory.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getById(UUID id) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Fulano de tal")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto dto) {
        log.debug("Creating (POST) new customer...");
        return CustomerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateCustomer(UUID id, CustomerDto dto) {
        // todo implement method
        log.debug("Updating (PUT) existing customer...");
    }

    @Override
    public void deleteCustomer(UUID id) {
        // todo implement method
        log.debug("Deleting (DELETE) customer...");
    }
}
