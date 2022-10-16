package itmo.jjd.hw.task6.catmouse;

public class Application {
    public static void main(String[] args){
        Cat cat1 = new Cat("Барсик",9.2,3);
        Cat cat2 = new Cat("Снежок",9.5,2.5);
        Mouse mouse1 = new Mouse(8);
        Mouse mouse2 = new Mouse(9);
        Mouse mouse3 = new Mouse(9.5);
        Mouse mouse4 = new Mouse(10);
        Mouse mouse5 = new Mouse(10.5);
        Mouse mouse6 = new Mouse(11);
        Mouse mouse7 = new Mouse(8.9);
        Mouse mouse8 = new Mouse(9.4);

        cat1.catchMouse(mouse1);
        cat1.catchMouse(mouse2);
        cat1.catchMouse(mouse3);
        cat1.catchMouse(mouse4);
        cat2.catchMouse(mouse5);
        cat2.catchMouse(mouse6);
        cat2.catchMouse(mouse7);
        cat2.catchMouse(mouse8);

        cat1.attackCat(cat2);
    }
}
