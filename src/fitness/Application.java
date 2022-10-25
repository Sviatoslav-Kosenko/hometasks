package fitness;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        Fitness fitness = new Fitness(Area.SWIMMING, Area.GYM,Area.GROUP);
        fitness.setCurrentDate(LocalDate.of(2022, 10, 23));
        SingleAbonement[] singleAbonements = new SingleAbonement[10];
        for (int i = 0; i < singleAbonements.length; i++) {
            singleAbonements[i] = new SingleAbonement(LocalDate.of(2022,10,24),
                    LocalDate.of(2022, 10, 29),
                    new OwnerInform("Святослав","Косенко",(int)(1980 +Math.random() * 25)));
        }
        DayAbonement[] dayAbonements = new DayAbonement[10];
        for (int i = 0; i < dayAbonements.length; i++) {
            dayAbonements[i] = new DayAbonement(LocalDate.of(2022,10,24),
                    LocalDate.of(2022, 10, 29),
                    new OwnerInform("Григорий","Пушкин",(int)(1965 +Math.random() * 25)));
        }
        FullAbonement[] fullAbonements = new FullAbonement[10];
        for (int i = 0; i < fullAbonements.length; i++) {
            fullAbonements[i] = new FullAbonement (LocalDate.of(2022,10,24),
                    LocalDate.of(2022, 10, 29),
                    new OwnerInform("Арсений","Волк",(int)(1975 +Math.random() * 30)));
        }
        for (int i = 0; i < 100; i++) {
            if (Math.random() < 0.3){
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.SWIMMING,singleAbonements[(int) (Math.random() * 10)]);
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.GYM, singleAbonements[(int)(Math.random() * 10)]);
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.GROUP,singleAbonements[(int)(Math.random() * 10)]);
            }
            if (Math.random() < 0.6){
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.SWIMMING,singleAbonements[(int) (Math.random() * 10)]);
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.GYM, singleAbonements[(int)(Math.random() * 10)]);
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.GROUP,singleAbonements[(int)(Math.random() * 10)]);
            }
            if (Math.random() < 0.9){
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.SWIMMING,singleAbonements[(int) (Math.random() * 10)]);
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.GYM, singleAbonements[(int)(Math.random() * 10)]);
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.GROUP,singleAbonements[(int)(Math.random() * 10)]);
            }
        }
        System.out.println("В swimming area" + Area.SWIMMING.getCount() + " посетителей");
        System.out.println("В gym area" + Area.GYM.getCount() + " посетителей");
        System.out.println("В group area" + Area.GROUP.getCount() + " посетителей");
        fitness.getAboutAbonementsInfo();
        fitness.closeFitness();
        fitness.getAboutAbonementsInfo();
    }
}