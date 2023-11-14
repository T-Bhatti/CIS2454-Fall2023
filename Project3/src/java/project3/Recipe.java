package project3;



import java.util.ArrayList;

/**
 *
 * @author tahre
 */
public class Recipe {

    private ArrayList<Ingredient> ingredients;
    private String direction;

    public Recipe(ArrayList<Ingredient> ingredients, String direction) {
        this.ingredients = ingredients;
        this.direction = direction;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getDirection() {
        return direction;
    }

    

    

}
