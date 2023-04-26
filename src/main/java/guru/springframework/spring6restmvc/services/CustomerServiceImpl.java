package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Nemo")
                .version(112)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Tomyta")
                .version(345)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("David")
                .version(897)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }

    @Override
    public List<Customer> listCustomers(){
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID id){
        return customerMap.get(id);
    }

    @Override
    public Customer creatNewCustomer(Customer customer) {
        Customer savedCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName(customer.getCustomerName())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
        customerMap.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public void updateCustomerById(UUID id, Customer customer) {
        Customer existingCustomer = customerMap.get(id);
        existingCustomer.setCustomerName(customer.getCustomerName());

        customerMap.put(existingCustomer.getId(), existingCustomer);
    }
}
