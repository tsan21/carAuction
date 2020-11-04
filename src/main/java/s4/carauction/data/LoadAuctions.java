package s4.carauction.data;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import s4.carauction.entities.Auction;
import s4.carauction.entities.Image;
import s4.carauction.repos.AuctionRepo;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class LoadAuctions {
    private static final Logger log = LoggerFactory.getLogger(LoadAuctions.class);
    private final List<Image> carImages = new ArrayList<>();

    @Bean
    CommandLineRunner initAuctions(AuctionRepo auctionRepo) {
        return args -> {
            carImages.add(new Image("https://www.topgear.com/sites/default/files/images/cars-road-test/2016/12/e1ba2cc73ababb8dcd812ea33400c79d/row_4863.jpg"));

            log.info("Preloading auction..." + auctionRepo.save(new Auction(
                    "Lebron James", "this is my auction", new Date(), new Date(), carImages
            )));
            log.info("Preloading auction..." + auctionRepo.save(new Auction(
                    "Donald Trump", "this is my auction", new Date(), new Date(), carImages
            )));
            log.info("Preloading auction..." + auctionRepo.save(new Auction(
                    "Lewis Hamilton", "this is my auction", new Date(), new Date(), carImages
            )));
            log.info("Preloading auction..." + auctionRepo.save(new Auction(
                    "Max Verstappen", "this is my auction", new Date(), new Date(), carImages
            )));
            log.info("Preloading auction..." + auctionRepo.save(new Auction(
                    "21 Savage", "this is my auction", new Date(), new Date(), carImages
            )));
            log.info("Preloading auction..." + auctionRepo.save(new Auction(
                    "Enzo Ferrari", "this is my auction", new Date(), new Date(), carImages
            )));
        };
    }

}
