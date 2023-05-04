package guru.springframework.spring6restmvc.bootstrap;

import guru.springframework.spring6restmvc.entities.Beer;
import guru.springframework.spring6restmvc.entities.Customer;
import guru.springframework.spring6restmvc.model.BeerStyle;
import guru.springframework.spring6restmvc.repositories.BeerRepository;
import guru.springframework.spring6restmvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        loadBeerData();
        loadCustomerData();
    }

    private void loadBeerData(){
        if(beerRepository.count() == 0){
            Beer beer1 = new Beer();
            beer1.setBeerName("Tiger");
            beer1.setBeerStyle(BeerStyle.PILSNER);
            beer1.setUpc("5657656");
            beer1.setQuantityOnHand(231);
            beer1.setPrice(BigDecimal.valueOf(23.1));
            beer1.setCreatedDate(LocalDateTime.now());
            beer1.setUpdateDate(LocalDateTime.now());

            Beer beer2 = new Beer();
            beer2.setBeerName("Ha Noi");
            beer2.setBeerStyle(BeerStyle.IPA);
            beer2.setUpc("6575675");
            beer2.setQuantityOnHand(900);
            beer2.setPrice(BigDecimal.valueOf(10.2));
            beer2.setCreatedDate(LocalDateTime.now());
            beer2.setUpdateDate(LocalDateTime.now());

            beerRepository.save(beer1);
            beerRepository.save(beer2);
        }
    }

    private void loadCustomerData(){
        if(customerRepository.count() == 0){
            Customer customer1 = new Customer();
            customer1.setCustomerName("Johny Dev");
            customer1.setCreatedDate(LocalDateTime.now());
            customer1.setLastModifiedDate(LocalDateTime.now());

            Customer customer2 = new Customer();
            customer2.setCustomerName("Nemo Bruce");
            customer2.setCreatedDate(LocalDateTime.now());
            customer2.setLastModifiedDate(LocalDateTime.now());

            customerRepository.saveAll(Arrays.asList(customer1, customer2));
        }
    }
}
