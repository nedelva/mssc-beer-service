package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by jt on 2019-05-17.
 */
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";
    public static final UUID BEER_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID BEER_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID BEER_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //FIX: NOT using data.sql file now
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                            .beerName("Mango Bobs")
                            .beerStyle("IPA")
                            .upc(BEER_1_UPC)
                            .price(new BigDecimal("12.95"))
                            .quantityToBrew(200)
                            .minOnHand(12)
                    .build());
            beerRepository.save(Beer.builder()
                            .beerName("Galaxy Cat")
                            .beerStyle("PALE_ALE")
                            .upc(BEER_2_UPC)
                            .price(new BigDecimal("12.95"))
                            .quantityToBrew(200)
                            .minOnHand(12)
                    .build());
            beerRepository.save(Beer.builder()
                            .beerName("Pinball Porter")
                            .beerStyle("PORTER")
                            .upc(BEER_3_UPC)
                            .price(new BigDecimal("12.95"))
                            .quantityToBrew(200)
                            .minOnHand(12)
                    .build());
        }
    }
}
