package itmo.jjd.hw.task20.units;

import itmo.jjd.hw.task20.base.AppSettings;
import itmo.jjd.hw.task20.base.BattleUnit;
import itmo.jjd.hw.task20.base.Unit;

public class King extends Unit {

    // класс King наследуется от класса Unit (или расширяет класс Unit)
// класс King - дочерний класс
// класс Unit - родительский класс (или суперкласс)
// множественное наследование классов запрещено

    private int gold = AppSettings.GOLD;

    private BattleUnit[] army;
    // конструкторы не наследуются
    public King(int healthScore){
        super(healthScore); // вызов констркуктора родителя
    }

    public int getGold(){
        return gold;
    }
    // создание армии
    public void generateArme(){
        if (gold < AppSettings.ARMY_PRICE){
            System.out.println("Стоимость армии " + AppSettings.ARMY_PRICE + ". У короля есть только" + gold);
            return;
        }
        gold -= AppSettings.ARMY_PRICE;
        army = BattleUnit.getBattleUnits(AppSettings.UNITS_COUNT);
    }
    public void updateArmy(){
        for (int i = 0; i < army.length; i++) {
            if (gold < AppSettings.UNIT_PRICE){
                System.out.println("Стоимость юнита " + AppSettings.UNIT_PRICE + ". У Короля есть только " + gold);
                return;
            }
            if (!army[i].isAlive()){
                gold -= AppSettings.UNIT_PRICE;
                army[i] = BattleUnit.getBattleUnit();
            }
        }
    }

    public void startBatle(King enemy){
        //TODO:: написать реализацию метода
        // юниты армии нападающего короля (this) должны атаковать юнитов армии противника (enemy)
        // последовательность атаки юнитов, отдыха юнитов, бонусы королю и т.д. на Ваше усмотрение!
        int thisKingDeathUnitsCounter = 0, enemyDeathUnitsCounter = 0;
        int thisKingArmyNumberOfUnits = this.army.length;
        int enemyKingArmyNumberOfUnits = enemy.army.length;

        System.out.println("Начало сражения армий!");

        for (BattleUnit thisKingUnit : this.army){
            for (BattleUnit enemyUnit : enemy.army){
                while (thisKingUnit.isAlive() && enemyUnit.isAlive()){
                    thisKingUnit.attack(enemyUnit);
                    if (!enemyUnit.isAlive()){
                        System.out.println("Погиб юнит обороняющейся армии");
                        enemyDeathUnitsCounter++;
                        break;
                    }
                    enemyUnit.attack(thisKingUnit);
                    if (!thisKingUnit.isAlive()){
                        System.out.println("Погиб юнит нападающей армии");
                        thisKingDeathUnitsCounter++;
                        break;
                    }
                    enemyUnit.attack(thisKingUnit);
                    if (!thisKingUnit.isAlive()){
                        System.out.println("Погиб юнит нападающей армии");
                        thisKingDeathUnitsCounter++;
                        break;
                    }
                    thisKingUnit.attack(enemyUnit);
                    if (!enemyUnit.isAlive()){
                        System.out.println("Погиб юнит обороняющейся армии");
                        enemyDeathUnitsCounter++;
                        break;
                    }
                }
                if (!thisKingUnit.isAlive()) break;// Если умер юнит нападающей армии, в бой должен вступить следующий
            }
            if (thisKingArmyNumberOfUnits == thisKingDeathUnitsCounter){
                System.out.println("Победила обороняющееся армия");
                break;
            }
            if (enemyKingArmyNumberOfUnits == enemyDeathUnitsCounter){
                System.out.println("Победила нападающая армия");
                break;
            }
        }
        System.out.println("Нападающая армия = " + thisKingArmyNumberOfUnits + " погибло юнитов = " + thisKingDeathUnitsCounter);
        System.out.println("Обороняющая армия = " + enemyKingArmyNumberOfUnits + "погибло юнитов = " + enemyDeathUnitsCounter);
    }

    @Override
    public void rest() {
        if (gold < AppSettings.REST_PRICE) return;
        gold -= AppSettings.REST_PRICE;
        super.rest();
        System.out.println("Король восстанавливает силы");
    }
    public final void rest(Unit unit){
        if (gold < AppSettings.REST_PRICE * 2) return;
        gold -= AppSettings.REST_PRICE * 2;
        plusHealth(2);
        unit.plusHealth(1);
        System.out.println("Король и Юниты востанавливают силы");
    }

    @Override
    public boolean equals(Object obj) {
        King anotherKing;
        if (obj instanceof King) anotherKing = (King) obj;
        else return false;
        return this.gold == anotherKing.army.length && this.healthScore == anotherKing.getHealthScore();
    }
}