package fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConstantValues {
     static final String TYPE_OF_ABONEMENT_SINGLE = "single";
    static final String TYPE_OF_ABONEMENT_DAY = "day";
    static final String TYPE_OF_ABONEMENT_FULL = "full";

    static final String AREA_FOR_GYM = "GYM";
    static final String AREA_FOR_GROUP = "GROUP";
    static final String AREA_FOR_SWIMMING = "SWIMMING";

    static final LocalTime CURRENT_TIME = LocalTime.of(15, 30);
    static final LocalTime NIGHT_TIME = LocalTime.of(22, 10);

    static final LocalTime START_ABONEMENT_SINGLE = LocalTime.of(8, 0);
    static final LocalTime FINISH_ABONEMENT_SINGLE = LocalTime.of(22, 0);

    static final LocalTime START_ABONEMENT_DAY = LocalTime.of(8, 0);
    static final LocalTime FINISH_ABONEMENT_DAY = LocalTime.of(16, 0);

    static final LocalTime START_ABONEMENT_FULL = LocalTime.of(8, 0);
    static final LocalTime FINISH_ABONEMENT_FULL = LocalTime.of(22, 0);

    public static LocalTime getCurrentTime(){
        return LocalTime.of((int)(5 + Math.random() * 8),(int)(Math.random() * 60));
    }
    public static LocalDate getCurrentDate(){
        return LocalDate.of(2020, (int)(Math.random() * 13),(int)(Math.random() * 28));
    }
}