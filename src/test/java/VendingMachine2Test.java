import org.junit.jupiter.api.*;

public class VendingMachine2Test {

    @Test
    public void checkChange() {
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 1, 4}, VendingMachine2.getChange(500, 50));
    }
    @Test
    public void checkChange2(){
        Assertions.assertArrayEquals(new int[]{4,1,0,0,0,0},VendingMachine2.getChange(100,91));
    }
    @Test
    public void checkChange3(){
        Assertions.assertArrayEquals(new int[]{0,0,0,1,0,0},VendingMachine2.getChange(100,75));
    }

    @BeforeEach
    public void beforeTest(){
        System.out.println("Test is starting !");
    }

    @AfterEach
    public void afterTest(){
        System.out.println("Test done !");
    }

    @BeforeAll
    public static void notifyStartingTests(){
        System.out.println("All tests are starting now !");
    }

    @AfterAll
    public static void notifyTerminatedTest(){
        System.out.println("All tests are done, please check your results");
    }

    //@BeforeAll
    //@AfterAll
    //@BeforeEach
    //@AfterEach

}

