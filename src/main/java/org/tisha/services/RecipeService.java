package org.tisha.services;

import java.util.Set;
import org.tisha.domain.Recipe;

/**
 * Created by t on 04.12.2017.
 */
public interface RecipeService {
    Set<Recipe> getRecipes();
}
