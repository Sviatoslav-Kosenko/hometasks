package fitness;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        OwnerInform owner = new OwnerInform("Svyat", "Kosenko", LocalDate.of(1988,2,3),Area.SWIMMING);
        OwnerInform owner1 = new OwnerInform("Tom", "Crouise", LocalDate.of(2000,4,12),Area.GYM);
        OwnerInform owner2 = new OwnerInform("Elizabeth", "Taylor", LocalDate.of(2001,6,22),Area.GROUPS);
        OwnerInform owner3 = new OwnerInform("Robert", "D.Jr.", LocalDate.of(1995,8,10),Area.SWIMMING);
        OwnerInform owner4 = new OwnerInform("Tom", "Hardy", LocalDate.of(2004,5,4),Area.GROUPS);
        OwnerInform owner5 = new OwnerInform("Patric", "K", LocalDate.of(1981,2,3),Area.GYM);

        Abonement[] gym = new Abonement[Fitness.arraySize];
        Abonement[] swimming = new Abonement[Fitness.arraySize];
        Abonement[] groups = new Abonement[Fitness.arraySize];

        Fitness fitness = new Fitness(gym,swimming,groups);
        fitness.addAbon(new Abonement(owner,AbonTypes.ONEDAY,LocalDate.of(2022,11,13)),
                new Abonement(owner1,AbonTypes.ONEDAY,LocalDate.of(2022,11,13)),
                new Abonement(owner2,AbonTypes.ONEDAY,LocalDate.of(2022,11,13)));
        Fitness fitness1 = new Fitness(gym,swimming,groups);
        fitness.addAbon(new Abonement(owner,AbonTypes.EVERYDAY,LocalDate.of(2022,11,13)),
                new Abonement(owner3,AbonTypes.EVERYDAY,LocalDate.of(2022,11,13)),
                new Abonement(owner4,AbonTypes.EVERYDAY,LocalDate.of(2022,11,13)));
        Fitness fitness2 = new Fitness(gym,swimming,groups);
        fitness.addAbon(new Abonement(owner,AbonTypes.FULL,LocalDate.of(2022,11,13)),
                new Abonement(owner5,AbonTypes.FULL,LocalDate.of(2022,11,13)));
        fitness.messageForOwner(owner, Area.SWIMMING);
        fitness.fitnessClose();
}
}