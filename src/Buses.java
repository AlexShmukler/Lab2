import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum Marks {Mercedes, Volvo, LAZ, Toyota, Skamia};

public class Buses implements Comparable<Buses>{
    private Marks mark;
    private int capacity;
    private String number;
    public Buses(Marks mark, int capacity, String number) {
        this.check(capacity,number);
        this.mark = mark;
        this.capacity = capacity;
        this.number = number;
    }
    private void check(int capacity, String number)
    {
        assert (capacity > 200 || capacity < 16): "Wrong capacity";
        Pattern p = Pattern.compile("\\w\\w\\d\\d\\d\\d\\w\\w");
        Matcher m=p.matcher(number);
        if(number.length()!=8) throw new AssertionError("Wrong number");
            else assert m.matches():"asdf";

    }
    public int peopleInTheBus(int people){
        assert people < 1: "Wrong amount of people";
        int result = people / this.capacity;
        if(result * this.capacity < people)
            result++;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
       if(this == obj)
           return true;
       if( obj==null || this.getClass() != obj.getClass() )
           return false;
       Buses temp = (Buses)obj;
       return ( (this.capacity == temp.capacity) || (this.mark == temp.mark) || (this.number == temp.number) );
    }

    @Override
    public int hashCode() {
        int result = mark.hashCode();
        result = 31 * result + capacity;
        result = 31 * result + number.hashCode();
        return result;
    }

    @Override
    public int compareTo(Buses o) {
        return number.compareTo(o.number);
    }


    public Marks getMark() {
        return mark;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getNumber() {
        return number;
    }

    public void setMark(Marks mark) {
        this.mark = mark;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static void main(String[] args) {
        Buses bus = new Buses(Marks.LAZ,20,"FS2321FS");
        bus.peopleInTheBus(30);
        Buses bus1 = new Buses(Marks.LAZ,210,"FW3242gs");
        System.out.println(bus.mark.hashCode());
    }
}
