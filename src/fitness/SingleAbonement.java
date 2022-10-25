package fitness;


import java.time.LocalDate;
import java.time.LocalTime;

public class SingleAbonement extends Abonement{
    public SingleAbonement(LocalDate registrDate, LocalDate endDate, OwnerInform ownerInform) {
        super(registrDate, endDate, ownerInform);
    }

    @Override
    public boolean checkAbonement(Area area, LocalTime currentTime, LocalDate currentDate) {
        if (!(area.equals(fitness.Area.valueOf(ConstantValues.AREA_FOR_SWIMMING)) ||
                area.equals(fitness.Area.valueOf(ConstantValues.AREA_FOR_GYM)))){
            System.out.println("Ваш абонемент не действует в этой зоне");
            return false;
        }
        if (!(currentDate.equals(this.registrDate))){
            System.out.println("Ваш абонемент не действует в даты");
            return false;
        }
        if (!(currentTime.isAfter(ConstantValues.START_ABONEMENT_SINGLE) &&
                currentTime.isBefore(ConstantValues.FINISH_ABONEMENT_SINGLE))){
            System.out.println("Ваш абонемент не действеут в это время");
            return false;
        }
        return true;
    }
}