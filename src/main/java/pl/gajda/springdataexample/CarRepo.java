package pl.gajda.springdataexample;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends CrudRepository<Car, Long> { // dwa parametry <klasa-encji, ID>

    List<Car> findAllByColor(Color color);

}
