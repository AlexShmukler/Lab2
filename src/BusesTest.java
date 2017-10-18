
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BusesTest {
    Buses bus1,bus2,bus3;

    @BeforeTest
    public void asdf(){
        bus1 = new Buses(Buses.Marks.Mercedes,43,"FE3242GR");
        bus2 = new Buses(Buses.Marks.Toyota,31,"FE3242GR");
        bus3 = new Buses(Buses.Marks.Volvo,78,"FE3242GR");
    }
    @DataProvider
    public Object[][] peopleInTheBusProvider() {
        return new Object[][]{ {150, bus2, 5}, {100, bus2, 4} };
    }

    @Test(dataProvider = "peopleInTheBusProvider")
    public void peopleInTheBusTest(int people, Buses bus2, int buses){

        assertEquals(bus2.peopleInTheBus(people), buses);
    }

    @DataProvider
    public Object[][] getMarkProvider(){
        return new Object[][]{ {bus1,Buses.Marks.Mercedes}, {bus2,Buses.Marks.Toyota}, {bus3,Buses.Marks.Volvo} };
    }

    @Test(dataProvider = "getMarkProvider")
    public void getMarkTest(Buses bus, Buses.Marks marks){
        assertEquals(bus.getMark(),marks);
    }

    @DataProvider
    public Object[][] isEnoughtSpaceProvider(){
        return new Object[][]{ {bus1,43,true}, {bus2,321,false}, {bus3,57,true} };
    }

    @Test(dataProvider = "isEnoughtSpaceProvider")
    public void isEnoughtSpaceTest(Buses bus, int people, boolean result){
        assertEquals(bus.isEnoughtSpace(people),result);
    }
}