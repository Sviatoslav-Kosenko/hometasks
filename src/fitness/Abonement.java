package fitness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

public class Abonement {
    private final LocalDate registrDate = LocalDate.now();
    private final LocalTime morning = LocalTime.of(8,0);
    private LocalDate dateRegEnd;
    private LocalTime evening;
    private Area[] areaTypeOneDay = new Area[] {Area.SWIMMING, Area.GYM};
    private Area[] areaTypeEveryDay = new Area[] {Area.GYM, Area.GROUPS};
    private Area [] areaTypeFull = new Area[] {Area.GYM, Area.SWIMMING, Area.GROUPS};
    private OwnerInform owner;

    private AbonTypes abonType;


    public Abonement(OwnerInform owner, AbonTypes abonType, LocalDate dateRegEnd) {
        setClient(owner);
        setAbonType(abonType);
        setDateRegEnd(dateRegEnd);
    }
    public void setClient(OwnerInform owner){
    this.owner = owner;
    }

    public void setAbonType(AbonTypes abonType) {
        this.abonType = abonType;
        if (abonType.equals(AbonTypes.ONEDAY) || abonType.equals(AbonTypes.FULL)){
            this.setEvening(LocalTime.of(22,0));
        }
        else {
            this.setEvening(LocalTime.of(16,0));
        }
        if (abonType.equals(AbonTypes.ONEDAY)){
            this.setAreaTypeOneDay(areaTypeOneDay);
        } else if (abonType.equals(AbonTypes.EVERYDAY)) {
            this.setAreaTypeEveryDay(areaTypeEveryDay);
        }
        else {
            this.setAreaTypeFull(areaTypeFull);
        }
    }

    public void setDateRegEnd(LocalDate dateRegEnd) {
        this.dateRegEnd = dateRegEnd;
    }

    public void setEvening(LocalTime evening) {
        this.evening = evening;
    }

    public void setAreaTypeOneDay(Area[] areaTypeOneDay) {
        this.areaTypeOneDay = areaTypeOneDay;
    }

    public void setAreaTypeEveryDay(Area[] areaTypeEveryDay) {
        this.areaTypeEveryDay = areaTypeEveryDay;
    }

    public void setAreaTypeFull(Area[] areaTypeFull) {
        this.areaTypeFull = areaTypeFull;
    }

    public LocalDate getRegistrDate() {
        return registrDate;
    }

    public LocalTime getMorning() {
        return morning;
    }

    public LocalDate getDateRegEnd() {
        return dateRegEnd;
    }

    public LocalTime getEvening() {
        return evening;
    }
    public Area[] getArea(){
        if (abonType.equals(AbonTypes.ONEDAY)) {
            return areaTypeOneDay;
        } else if (abonType.equals(AbonTypes.EVERYDAY)) {
            return areaTypeEveryDay;
        }
        else {
            return areaTypeFull;
        }
    }

    public Area[] getAreaTypeOneDay() {
        return areaTypeOneDay;
    }

    public Area[] getAreaTypeEveryDay() {
        return areaTypeEveryDay;
    }

    public Area[] getAreaTypeFull() {
        return areaTypeFull;
    }

    public OwnerInform getOwner() {
        return owner;
    }

    public AbonTypes getAbonType() {
        return abonType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonement abonement = (Abonement) o;
        return Objects.equals(registrDate, abonement.registrDate) && Objects.equals(morning, abonement.morning) && Objects.equals(dateRegEnd, abonement.dateRegEnd) && Objects.equals(evening, abonement.evening) && Objects.equals(owner, abonement.owner) && abonType == abonement.abonType;

    }

    @Override
    public int hashCode() {
        return Objects.hash(registrDate,morning,dateRegEnd,evening,owner,abonType);
    }

    @Override
    public String toString() {
        return "Abonement{" +
                "registrDate=" + registrDate +
                ", morning=" + morning +
                ", dateRegEnd=" + dateRegEnd +
                ", evening=" + evening +
                ", areaTypeOneDay=" + Arrays.toString(areaTypeOneDay) +
                ", areaTypeEveryDay=" + Arrays.toString(areaTypeEveryDay) +
                ", areaTypeFull=" + Arrays.toString(areaTypeFull) +
                ", owner=" + owner +
                ", abonType=" + abonType +
                '}';
    }
}




