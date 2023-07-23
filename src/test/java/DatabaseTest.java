import org.junit.Test;
import praktikum.Database;

import static org.junit.Assert.assertEquals;
public class DatabaseTest {
    @Test
    public void checkBunListSize() {
        Database database = new Database();
        assertEquals("Количество булок не совпадает",3, database.availableBuns().size());
    }
    @Test
    public void checkIngredientListSize() {
        Database database = new Database();
        assertEquals("Количество ингредиентов не совпадает", 6, database.availableIngredients().size());
    }
}
