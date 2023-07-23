import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunPositiveTest {

    private final String name;
    private final float price;

    public BunPositiveTest(String name, float price)
    {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "name: {0} | price: {1}")
            public static Object[][] params(){
        return new Object[][]{
                {"Bun with sesame seeds", 5.0f},
                {"Булочка с кунжутом", 1},
                {"", 0},
                {"Булка с очень большим названием должна быть тут, но я не придумал очень длинной название для этой булки, хотя возможно пока писал уже придумал 123456>", -1},
        };
    }

    @Test
    public void checkGetBunNameReturnCorrectName(){
        Bun bun = new Bun(name, price);
        assertEquals("Имя булки не совпадает",name, bun.getName());
    }

    @Test
    public void checkGetBunPriceReturnCorrectPrice(){
        Bun bun = new Bun(name, price);
        assertEquals("Цена булки не совпадает",price, bun.getPrice(),0.000f);
    }
}
