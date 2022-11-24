package itmo.jjd.hw.task20.units;

import itmo.jjd.hw.task20.base.BattleUnit;

public final class Knight extends BattleUnit {

    private int additionalHealth;

    public Knight(int healthScope, int attackScore, int additionalHealth){
        super(healthScope, attackScore);
        if (additionalHealth < 1) throw new IllegalArgumentException("additionalHealth д.б. больше 1");
        this.additionalHealth = additionalHealth;
    }

    @Override
    public void attack(BattleUnit enemy) {
        System.out.println("Рыцарь атакует");
        enemy.minusHealth(this.attackScore);
        this.plusHealth(5);
        System.out.println("Рыцарь восстанавливает часть здоровья после атаки. Теперь у него " + this.getHealthScore() + " здоровья");
    }
}