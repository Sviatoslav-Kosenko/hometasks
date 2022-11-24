package itmo.jjd.hw.task20.units;

import itmo.jjd.hw.task20.base.BattleUnit;

public final class Infantry extends BattleUnit {
    private int additionalAttack;

    public Infantry(int healthScope, int attackScore, int additionalAttack){
        super(healthScope, attackScore);
        if (additionalAttack < 1) throw new IllegalArgumentException("additionalAttack д.б. больше 1");
        this.additionalAttack = additionalAttack;
    }
    public void upAdditionalAttack(){
        additionalAttack += (int) (Math.random() * 3);
    }

    @Override
    public void attack(BattleUnit enemy) {
        System.out.println("Пехотинец атакует");
        enemy.minusHealth(this.attackScore + this.additionalAttack);
    }
}