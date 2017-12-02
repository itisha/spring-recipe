package org.tisha.repositories;

import org.springframework.data.repository.CrudRepository;
import org.tisha.domain.Recipe;

/**
 * Created by t on 02.12.2017.
 */
public interface RecipeRepostory extends CrudRepository<Recipe, Long> {
}
