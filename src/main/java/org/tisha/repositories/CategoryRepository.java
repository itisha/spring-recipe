package org.tisha.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.tisha.domain.Category;

/**
 * Created by t on 02.12.2017.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
