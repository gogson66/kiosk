package kiosk.data;

import kiosk.Ingredient;
import org.springframework.data.repository.ListCrudRepository;;

public interface IngredientRepository extends ListCrudRepository<Ingredient, String>{
    
    /*Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);*/
}
