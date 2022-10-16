package itmo.jjd.hw.task6.catmouse;

public class Mouse {
    private double speed;

    public Mouse(double speed){
        setSpeed(speed);
    }
    private void setSpeed(double speed){
        if (speed <= 0){
            throw new IllegalArgumentException("speed н.б. пустым");
        }
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }
}
