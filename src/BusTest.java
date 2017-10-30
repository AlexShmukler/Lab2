
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BusTest {
    Bus bus1,bus2,bus3;

    @BeforeTest
    public void setup(){
        bus1 = new Bus(Bus.Marks.Mercedes,43,"FE3242GR");
        bus2 = new Bus(Bus.Marks.Toyota,31,"FE3242GR");
        bus3 = new Bus(Bus.Marks.Volvo,78,"FE3242GR");
    }

    @DataProvider
    public Object[][] peopleInTheBusProvider() {
        return new Object[][]{ {150, bus2, 5}, {100, bus2, 4} };
    }

    @Test(dataProvider = "peopleInTheBusProvider")
    public void peopleInTheBusTest(int people, Bus bus2, int buses){

        assertEquals(bus2.busesNeeded(people), buses);
    }

    @DataProvider
    public Object[][] getMarkProvider(){
        return new Object[][]{ {bus1, Bus.Marks.Mercedes}, {bus2, Bus.Marks.Toyota}, {bus3, Bus.Marks.Volvo} };
    }

    @Test(dataProvider = "getMarkProvider")
    public void getMarkTest(Bus bus, Bus.Marks marks){
        assertEquals(bus.getMark(),marks);
    }

    @DataProvider
    public Object[][] isEnoughtSpaceProvider(){
        return new Object[][]{ {bus1,43,true}, {bus2,321,false}, {bus3,57,true} };
    }

    @Test(dataProvider = "isEnoughtSpaceProvider")
    public void isEnoughtSpaceTest(Bus bus, int people, boolean result){
        assertEquals(bus.isEnoughtSpace(people),result);
    }
}