package org.tisha.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.tisha.domain.UnitOfMeasure;

/**
 * Created by t on 02.12.2017.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);

}
