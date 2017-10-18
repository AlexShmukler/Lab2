import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GarageTest {
    Buses bus1,bus2,bus3;
    Garage garage1,garage2;

    @BeforeTest
    public void setup(){
        garage1 = new Garage(15,"New Avenue 29",12);
        garage2 = new Garage();
        bus1 = new Buses(Buses.Marks.Mercedes,43,"FE3242GR");
        bus2 = new Buses(Buses.Marks.Toyota,31,"FE3242GR");
        bus3 = new Buses(Buses.Marks.Volvo,78,"FE3242GR");
        garage1.addBus(bus1);
        garage1.addBus(bus2);
        garage2.addBus(bus2);
        garage2.addBus(bus3);
    }
    @DataProvider
    public Object[][] providerIsEnoughtBuses(){
        return new Object[][]{ {garage1,71,true}, {garage1,89,false}, {garage2,102,true} };
    }

    @Test(dataProvider = "providerIsEnoughtBuses")
    public void testIsEnoughtBuses(Garage garage, int people, boolean result){
        assertEquals(garage.isEnoughtBuses(people),result);
    }

    @DataProvider
    public Object[][] providerGetLocation(){
            return new Object[][]{ {garage1,"New Avenue 29"}, {garage2,"Main Str. 32"} };
    }
    @Test(dataProvider = "providerGetLocation")
    public void testGetLocation(Garage garage, String location) {
        assertEquals(garage.getLocation(),location);
    }

}