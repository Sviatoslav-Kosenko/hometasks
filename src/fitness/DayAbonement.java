package fitness;

import java.time.LocalTime;
import java.time.LocalDate;

public class DayAbonement extends Abonement{
    public DayAbonement(LocalDate registrDate, LocalDate endDate, OwnerInform ownerInform) {
        super(registrDate, endDate, ownerInform);
    }

    @Override
    public boolean checkAbonement(Area area, LocalTime currentTime, LocalDate currentDate) {
        if (!(area.equals(fitness.Area.valueOf(ConstantValues.AREA_FOR_GROUP)) ||
                area.equals(fitness.Area.valueOf(ConstantValues.AREA_FOR_GYM)))){
            System.out.println("Ваш абонемент не действует в этой зоне");
            return false;
        }
        if (!(currentDate.isAfter(this.registrDate) && currentDate.isBefore(this.endDate))){
            System.out.println("Ваш абонемент не действует в даты");
            return false;
        }
        if (!(currentTime.isAfter(ConstantValues.START_ABONEMENT_DAY) &&
                currentTime.isBefore(ConstantValues.FINISH_ABONEMENT_DAY))){
            System.out.println("Ваш абонемент не действеут в это время");
            return false;
        }
        return true;
    }
}