package fitness;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Objects;

public class Fitness {
    private LocalTime currentTime;
    private LocalDate currentDate;
    private Area swiming;
    private Area gym;
    private Area group;

    public Fitness(Area swiming, Area gym, Area group) {
        this.swiming = Objects.requireNonNull(swiming, "swiming н.б. null");
        this.gym = Objects.requireNonNull(gym,"gym н.б. null");
        this.group = Objects.requireNonNull(group,"group н.б. null");
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = Objects.requireNonNull(currentDate,"currentDate н.б. null");
    }
    public void setCurrentTime(LocalTime currentTime){
        this.currentTime = Objects.requireNonNull(currentTime,"currentTime н.б. null");
    }
    public void nextAbonement(Area area, Abonement abonement){
        if (abonement == null){
            throw new IllegalArgumentException("abonement н.б. null");
        }
        if (area == null){
            throw new IllegalArgumentException("area н.б. null");
        }
        if (currentTime.isAfter(ConstantValues.NIGHT_TIME)){
            System.out.println("Закрыто");
            return;
        }
        if (area.isFull()){
            System.out.println("Извините " + area + " заполнена.");
            return;
        }
        if (swiming.findAbonement(abonement) || gym.findAbonement(abonement) ||
                    group.findAbonement(abonement) ) return;
        if (abonement.checkAbonement(area,currentTime,currentDate)){
            abonement.setVisitArea(area.name());
            area.pushAbonement(abonement);
            Checking.getInformAboutAbonement(abonement);
        }
    }
    public void getAboutAbonementsInfo(){
        Checking.getInformAboutAbonements();
    }
    public void closeFitness(){
        gym.clear();
        swiming.clear();
        group.clear();
    }
}