import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BusBuilder {
    private Marks mark;
    private int capacity;
    private String number;
    private static String pattern = "[A-Z]{2}\\d{4}[A-Z]{2}";

    public static void setPattern(String pattern) {
        BusBuilder.pattern = pattern;
    }

    public void setNumber(String number) {

        this.number = number;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setMark(Marks mark) {
        this.mark = mark;
    }

    public Bus build(Marks mark, int capacity, String number){
        if (capacity > 200 | capacity < 16) throw new IllegalArgumentException("Wrong capacity");
        Pattern p = Pattern.compile(this.pattern);
        Matcher m = p.matcher(number);
        if (!m.matches()) throw new IllegalArgumentException("Wrong number");
        this.mark = mark;
        this.capacity = capacity;
        this.number = number;
        return new Bus(this.mark,this.capacity,this.number);
    }
}
