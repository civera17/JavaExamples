import java.time.DateTimeException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public enum Days {
    SUNDAY(0,0),MONDAY(0.5,0.9),TUESDAY(0.6,0.7),WEDNESDAY(0.4,0.8),THURSDAY(0.5,0.6)
    ,FRIDAY(0.3,0.5),SATURDAY(0.0,0.2);

    private final double occupancy;

    Days(double start, double end){
        if (end == 0){
            this.occupancy = 0;
        } else {
            this.occupancy = ThreadLocalRandom.current().nextDouble(start, end);
        }
    }

    public int getOccupancy(int numberOfEmp) {
        return (int) (numberOfEmp * this.occupancy);
    }

    private static final Days[] ENUMS = Days.values();



    public static Days of(int dayOfWeek) {
        if (dayOfWeek < 1 || dayOfWeek > 7) {
            throw new DateTimeException("Invalid value for DayOfWeek: " + dayOfWeek);
        }
        return ENUMS[dayOfWeek - 1];
    }

    public static boolean contains(String day){
        for (Days d: Days.ENUMS){
            if (d.name().equals(day.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static int dayValue(String day) {
        if (!contains(day)) {
            throw new IllegalArgumentException("No such day");
        }
        return Days.valueOf(day.toUpperCase()).ordinal() + 1;
    }
}
