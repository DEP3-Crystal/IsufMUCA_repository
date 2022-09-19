import com.vendingMachine.VendingMachine2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class VendingMachine2Test {

    @BeforeAll
    public static void notifyStartingTests() {
        System.out.println("All tests are starting now !");
    }

    @AfterAll
    public static void notifyAllTestsDone() {
        System.out.println("All tests are done, please check your results");
    }

    @BeforeEach
    public void beforeTest() {
        System.out.println("Test is starting !");
    }

    @AfterEach
    public void afterTest() {
        System.out.println("Test done !");
    }

    @Test
    public void checkChangeForOneDollarBills() throws Exception {
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 4}, VendingMachine2.getChange(500, 100));
    }

    @Test
    public void checkChangeForFiftyCents() throws Exception {
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 1, 0}, VendingMachine2.getChange(100, 50));
    }

    @Test
    public void checkChangeForTwentyFiveCents() throws Exception {
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 1, 0, 0}, VendingMachine2.getChange(50, 25));
    }

    @Test
    public void checkChangeForTenCents() throws Exception {
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 0, 0, 0}, VendingMachine2.getChange(50, 40));
    }

    @Test
    public void checkChangeForFiveCents() throws Exception {
        Assertions.assertArrayEquals(new int[]{0, 1, 0, 0, 0, 0}, VendingMachine2.getChange(50, 45));
    }

    @Test
    public void checkChangeForOneCents() throws Exception {
        Assertions.assertArrayEquals(new int[]{1, 0, 0, 0, 0, 0}, VendingMachine2.getChange(50, 49));
    }

    @Test
    public void checkChangeWithNegativeInsertedMoneyValue() {
        assertThrows(Exception.class, () -> {
            Object obj = VendingMachine2.getChange(-50, 49);
        });
    }

    @Test
    public void checkChangeWithNegativeInsertedPriceValue() {
        assertThrows(Exception.class, () -> {
            Object obj = VendingMachine2.getChange(-100, -49);
        });
    }

    @Test
    public void checkChangeWithNegativeInsertedInput() {
        assertThrows(Exception.class, () -> {
            Object obj = VendingMachine2.getChange(-500, -49);
        });
    }

    //@BeforeAll
    //@AfterAll
    //@BeforeEach
    //@AfterEach
    //@DisplayName
    //@Tag()
    //@Disabled
    //@ParameterizedTest
    //@ValueSource()
    //@RepeatedTest


}

