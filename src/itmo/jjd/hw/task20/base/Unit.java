package itmo.jjd.hw.task20.base;

import java.io.Serializable;

abstract public class Unit implements Serializable {
    //protected - доступ в дочернем классе или внутри пакета
    protected  int healthScore;
    private final int maxHealthScore;

    public Unit(int healthScore){
        if (healthScore < 1) throw new IllegalArgumentException("Здоровье не может быть меньше 1");
        this.healthScore = healthScore;
        this.maxHealthScore = healthScore;
    }

    public boolean isAlive(){
        return healthScore > 0;
    }

    public void plusHealth(int healthScore){
        if (isAlive()) return;
        this.healthScore = Math.min(this.healthScore + healthScore,maxHealthScore);
    }
    public void minusHealth(int healthScore){
        if (isAlive()) this.healthScore -= healthScore;
    }

    public int getHealthScore() {
        return healthScore;
    }

    public void rest(){
        plusHealth(1);
        System.out.println("Unit восстанавливает силы");
    }
}