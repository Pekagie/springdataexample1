package pl.gajda.springdataexample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component

public class Start {


    private CarRepo carRepo;


    @Autowired
    public Start(CarRepo carRepo) {
        this.carRepo = carRepo;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {
        Car car = new Car("Honda", "Jazz", Color.RED);
        carRepo.save(car);

        Iterable<Car> all = carRepo.findAllByColor(Color.RED);
        all.forEach(System.out::println);
    }
}