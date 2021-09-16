package ru.mond51.workplace.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mond51.workplace.model.Eds;

import java.util.List;

public interface EdsRepository extends CrudRepository<Eds, Long> {

    List<Eds> findAllByOrderByActiveDescExpirationDateAsc();

}
