package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repository.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImpTest {

    RecipeServiceImp recipeService;

    @Mock
    RecipeRepository recipeRepository;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImp(recipeRepository);
    }

    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(),1);
        verify(recipeRepository, times(1)).findAll();
    }
}