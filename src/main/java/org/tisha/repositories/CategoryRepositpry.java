package org.tisha.repositories;

import org.springframework.data.repository.CrudRepository;
import org.tisha.domain.Category;

/**
 * Created by t on 02.12.2017.
 */
public interface CategoryRepositpry extends CrudRepository<Category, Long> {
}
