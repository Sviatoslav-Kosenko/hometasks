package itmo.jjd.hw.task20;

import itmo.jjd.hw.task20.units.Infantry;
import itmo.jjd.hw.task20.units.King;

public class Application {

    public void finalArgs(final  int a, final Infantry infantry){
        System.out.println(a);
        int b = a * a;

        System.out.println(infantry.getHealthScore());
        infantry.plusHealth(10);
    }

    public static void main(String[] args) {
        King king01 = new King(1000);
        King king02 = new King(2000);

        king01.generateArme();
        king02.generateArme();
//Создаем 2 королевства.
        Kingdom kingdom01 = new Kingdom("Королевство 1");
        kingdom01.setKing(king01);
        Kingdom kingdom02 = new Kingdom("Королевство 2");
        kingdom02.setKing(king02);

        //Создаем еще 2 королевства и загружаем в них королевства из файла

        Kingdom kingdom03 = new Kingdom("Королевство 3");
        Kingdom kingdom04 = new Kingdom("Королевство 4");

        kingdom01.saveKingdomToFile();
        kingdom03.loadKingdomFromFile();

        kingdom02.saveKingdomToFile();
        kingdom04.loadKingdomFromFile();

        System.out.println(kingdom03.getKingdomName());
        System.out.println(kingdom04.getKingdomName());

        System.out.println(kingdom03.getKing().equals(kingdom01.getKing()));
        System.out.println(kingdom04.getKing().equals(kingdom02.getKing()));
        System.out.println(kingdom02.getKing().equals(kingdom01.getKing()));
        System.out.println(kingdom04.getKing().equals(kingdom03.getKing()));
    }
}
