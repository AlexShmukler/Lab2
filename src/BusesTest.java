import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BusesTest {
    @BeforeMethod
    public void setUp() {
        Buses bus = new Buses();
      //  Buses bus2 = new Buses(Marks.LAZ,31,"FE3245AC");
        Buses incorrectBus = new Buses(Marks.Skamia,14,"32dasd");
    }
    @DataProvider
    public Object[][] aa() {
        Buses bus2 = new Buses(Marks.LAZ,31,"FE3245AC");
        return new Object[][]{ {bus2,5} };
    }

    @Test(dataProvider = "aa")
    public void peopleInTheBusTest(Buses bus2,int buses){
        System.out.println(buses);
        assertEquals(bus2.peopleInTheBus(150),buses);
    }


}