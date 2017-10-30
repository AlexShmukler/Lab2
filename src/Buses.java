import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Buses {
    private List<Bus> garage;
    private int capacity;
    private String location;
    private int employers;

    public Buses(){
        this.capacity = 10;
        this.location = "Main Str. 32";
        this.employers = 20;
        this.garage = new ArrayList<Bus>();
    }
    public Buses(int capacity, String location, int employers){
        if ((!(capacity > 1 | capacity < 20))) throw new IllegalArgumentException("Wrong input(1 < capacity < 20)");
        if ((!(employers > 1 | employers < 50))) throw new IllegalArgumentException("Wrong input(1 < employers < 50)");
        this.capacity = capacity;
        this.location = location;
        this.employers = employers;
        this.garage = new ArrayList<Bus>();
    }

    public Buses(int capacity, String location, List<Bus>garage, int employers){
        this.location = location;
        this.capacity = capacity;
        this.garage = garage;
        this.employers = employers;
    }

    public void deleteBus(String number){
        for(Bus i: this.garage){
            if(i.getNumber().equals(number)) {
                this.garage.remove(i);
                return;
            }
            throw new RuntimeException("Product with this number not found, try another bus number");
        }
    }

    public List<Bus> busesOutputIncreasingCapacity(){
        List<Bus> garage = new ArrayList<Bus>();
        List<Bus> tempGarage = this.garage;
        String temp;
        List<String> temp1;
        for (Bus bus : tempGarage)
            temp1.add(bus.getNumber());
        Collections.sort(temp1);

        int minCapacity = this.garage.get(0).getCapacity();
        for(int i=0;i<garage.size();i++) {
            for (Bus bus : tempGarage) {
                if (bus.getCapacity() <= minCapacity) {
                    minCapacity = bus.getCapacity();
                }
            }
            garage.add()
                    garage.
        }

        return Collections.sort(garage);
    }
    public void addBus(Bus bus){
        this.garage.add(bus);
    }

    public boolean isEnoughtBuses(int people){
        int allPeople=0;
        for(Bus i:this.garage){
            allPeople+=i.getCapacity();
        }
        return allPeople>=people;
    }

    @Override
    public int hashCode() {
        int result = capacity * 31;
        result+=location.hashCode();
        result+=garage.hashCode();
        result+=employers * 31;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(this.getClass()!=obj.getClass())
            return false;
        Buses temp = (Buses)obj;
        return ( (this.capacity==temp.capacity) && (this.location==temp.location) && (this.garage==temp.garage) && (this.employers==temp.employers));
    }

    public List<Bus> getGarage() {
        return garage;
    }

    public void setGarage(List<Bus> garage) {
        this.garage = garage;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEmployers() { return employers; }

    public void setEmployers(int employers) { this.employers = employers; }

    public int getAmountOfBuses(){
        return this.garage.size();
    }


}
