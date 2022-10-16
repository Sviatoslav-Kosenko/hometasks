package itmo.jjd.hw.task6.catmouse;

public class Cat {
    private String name;
    private double speed;
    private double weight;
    private Mouse [] mice = new Mouse[100];
    private int count = 0;

    public Cat(String name, double speed, double weight){
        setName(name);
        setSpeed(speed);
        setWeight(weight);
    }

    private void setName(String name){
        if (name == null){
            throw new IllegalArgumentException("name н.б. null");
        }
        if (name.equals("")){
            throw new IllegalArgumentException("name н.б. пустым");
        }
        this.name = name;
    }
    private void setSpeed(double speed){
        if (speed <= 0){
            throw new IllegalArgumentException("speed д.б. больше 0");
        }
        this.speed = speed;
    }

    private void setWeight(double weight){
        if (weight <= 0){
            throw new IllegalArgumentException("weight д.б. больше 0");
        }
        this.weight = weight;
    }

    public void catchMouse(Mouse mouse){
        if (count >= mice.length){
            System.out.println("Кот поймал слишком много мышей");
            return;
        }
        if (speed > mouse.getSpeed()){
            System.out.println("Мышь поймана");
            mice[count] = mouse;
            count++;
        } else {
            System.out.println("Мышь убежала");
        }
    }
    public void attackCat(Cat cat){
        if (weight > cat.weight){
            System.out.println("Кот победил в драке");
            int miceEscaped = 0;
            int miceCaught = 0;
            for (int i = 0; i < cat.count; i++) {
                if (cat.mice[i] == null){
                    break;
                }
                if (speed > cat.mice[i].getSpeed() && count < mice.length){
                    miceCaught++;
                    mice[count] = cat.mice[i];
                    count++;
                } else {
                    miceEscaped++;
                }
            }
            System.out.println("Мышей отобрано: " + miceCaught);
            System.out.println("Мышей сбежало: " + miceEscaped);
        } else {
            System.out.println("Кот проиграл в драке");
        }
    }
}
