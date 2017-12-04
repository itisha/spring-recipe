package org.tisha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tisha.services.RecipeService;

/**
 * Created by t on 20.11.2017.
 */
@Controller
public class IndexController {


    private final RecipeService recipeService;

    //todo NO AUTOWIRED!!!
    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
