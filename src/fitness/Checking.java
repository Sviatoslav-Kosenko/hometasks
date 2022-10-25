package fitness;

public class Checking {
    static final void getInformAboutAbonement(Abonement abonement) {
        System.out.println(abonement);
    }
    static final void getInformAboutAbonements(){
        for (Area area : Area.values() ){
            System.out.println(area);
            for (Abonement abonement : area.getAbonements()){
                if (abonement != null){
                    System.out.println(abonement);
                }
            }
        }
    }
}