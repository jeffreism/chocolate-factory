package moreira.jeffrei.chocolatefactory.web.controller;

import moreira.jeffrei.chocolatefactory.web.model.CustomerDto;
import moreira.jeffrei.chocolatefactory.web.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    ResponseEntity<CustomerDto> getById(@PathVariable UUID id) {
        return new ResponseEntity<>(customerService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity handlePost(@RequestBody CustomerDto dto) {

        var savedDto = customerService.saveNewCustomer(dto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer" + savedDto.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity handlePut(@PathVariable UUID id, @RequestBody CustomerDto dto) {
        customerService.updateCustomer(id, dto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable UUID id) {
        customerService.deleteCustomer(id);
    }
}
