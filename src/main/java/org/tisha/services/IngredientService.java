package org.tisha.services;

import org.springframework.transaction.annotation.Transactional;
import org.tisha.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    @Transactional
    IngredientCommand saveIngredientCommand(IngredientCommand command);
}
