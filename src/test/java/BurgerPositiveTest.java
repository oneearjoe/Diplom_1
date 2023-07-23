import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerPositiveTest {

    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;
    @Mock
    Bun bun;

    Burger burger = new Burger();

    @Test
    public void checkIngredientCountAfterAddIngredient(){
        burger.addIngredient(ingredient);
        assertEquals("Количество ингредиентов после добавления не совпадает", 1, burger.ingredients.size());
    }

    @Test
    public void checkIngredientCountAfterRemoveIngredient(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Количество ингредиентов после удаления не совпадает",0, burger.ingredients.size());
    }

    @Test
    public void checkIngredientAfterMoving(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        assertEquals("Ингредиенты не поменялись местами", ingredient2,burger.ingredients.get(0));
    }

    @Test
    public void checkGetPrice(){
        burger.setBuns(bun);
        float bunPrice = 5;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        burger.addIngredient(ingredient);
        float ingredientPrice = 2;
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        assertEquals("Некорректная цена", bunPrice * 2 + ingredientPrice, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceiptReturnsCorrectReceipt(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Black bun");
        Mockito.when(bun.getPrice()).thenReturn(42f);
        Mockito.when(ingredient.getName()).thenReturn("filling cutlet");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(1984f);

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        expectedReceipt.append(String.format("= filling %s =%n", ingredient.getName()));
        expectedReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedReceipt.append(String.format("%nPrice: %f%n", bun.getPrice() * 2 + ingredient.getPrice()));

        assertEquals("Некорректный чек", expectedReceipt.toString(), burger.getReceipt());
    }
}
