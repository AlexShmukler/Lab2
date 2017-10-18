import java.util.ArrayList;
import java.util.List;


public class Garage {
    private List<Buses> garage;
    private int capacity;
    private String location;
    private int employers;

    public Garage(){
        this.capacity = 10;
        this.location = "Main Str. 32";
        this.employers = 20;
        this.garage = new ArrayList<Buses>();
    }
    public Garage(int capacity, String location,int employers){
        assert (capacity > 1 | capacity < 20): "Wrong input(capacity)";
        assert (employers > 1 | employers < 50): "Wrong input(employers)";
        this.capacity = capacity;
        this.location = location;
        this.employers = employers;
        this.garage = new ArrayList<Buses>();
    }

    public Garage(int capacity, String location, List<Buses>garage,int employers){
        this.location = location;
        this.capacity = capacity;
        this.garage = garage;
        this.employers = employers;
    }

    public void deleteBus(String number){
        for(Buses i: this.garage){
            if(i.getNumber().equals(number)) {
                this.garage.remove(i);
                return;
            }
            throw new AssertionError("Product with this number not found");
        }
    }

    public void addBus(Buses bus){
        this.garage.add(bus);
    }

    public boolean isEnoughtBuses(int people){
        int allPeople=0;
        for(Buses i:this.garage){
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
        Garage temp = (Garage)obj;
        return ( (this.capacity==temp.capacity) && (this.location==temp.location) && (this.garage==temp.garage) && (this.employers==temp.employers));
    }

    public List<Buses> getGarage() {
        return garage;
    }

    public void setGarage(List<Buses> garage) {
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
