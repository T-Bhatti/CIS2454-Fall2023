package project3;


/**
 *
 * @author tahre
 */
public class Ingredient {

    private String name;
    private String measure;
    private double quantity;

    public Ingredient(String name, String measure, double quantity) {
        this.name = name;
        this.measure = measure;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getMeasure() {
        return measure;
    }

    public double getQuantity() {
        return quantity;
    }

   public double getNewQuantity(double multiplier) {
       return quantity*multiplier;
   }

    @Override
    public String toString() {
        return name+" "+ quantity+" "+measure;
    }
   
}
