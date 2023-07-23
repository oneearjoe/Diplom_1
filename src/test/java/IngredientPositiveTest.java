import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientPositiveTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientPositiveTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "type: {0} | name: {1} | price:{2}")
    public static Object[][] params(){
        return new Object[][]{
                {SAUCE, "соус", 100},
                {FILLING, "котлета", 1.5f},
                {FILLING, "капуста", 0.005f},
                {FILLING, "", 0}
        };
    }

    @Test
    public void CheckGetTypeReturnCorrectType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип ингредиента не совпадает", type, ingredient.getType());
    }

    @Test
    public void checkGetNameReturnCorrectName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Имя ингредиента не совпадает", name, ingredient.getName());
    }

    @Test
    public void checkGetPriceReturnCorrectPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Цена ингредиента не совпадает", price, ingredient.getPrice(), 0.000f);
    }
}

