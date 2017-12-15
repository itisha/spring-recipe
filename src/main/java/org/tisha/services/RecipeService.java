package org.tisha.services;

import org.tisha.commands.RecipeCommand;
import org.tisha.domain.Recipe;

import java.util.Set;

/**
 * Created by t on 04.12.2017.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

    RecipeCommand findCommandById(Long l);

    void deleteById(Long id);
}
