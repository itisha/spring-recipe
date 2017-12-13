package org.tisha.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.tisha.domain.Recipe;
import org.tisha.services.RecipeServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    @Mock
    RecipeServiceImpl recipeService;

    @Mock
    Model model;

    IndexController indexController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        indexController = new IndexController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception {
        //without actual sprig context
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void getIndexPage() {
        //given
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe1);
        recipes.add(recipe2);

        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> setArgumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        String indexPage = indexController.getIndexPage(model);

        //then
        assertEquals("index", indexPage);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), setArgumentCaptor.capture());
        Set<Recipe> capturedSet = setArgumentCaptor.getValue();
        assertEquals(2, capturedSet.size());
    }
}