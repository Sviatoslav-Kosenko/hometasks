package fitness;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Arrays;

public class Fitness {
    public static final int arraySize = 20;
    private Abonement[] abonGym;
    private Abonement[] abonSwimming;
    private Abonement[] abonGroups;

    public Fitness(Abonement[] abonGym, Abonement[] abonSwimming, Abonement[] abonGroups) {
        setArrGym(abonGym,abonSwimming,abonGroups);
    }

    public void setArrGym(Abonement[] abonGym, Abonement[] abonSwimming, Abonement[] abonGroups){
        if (abonGym.length != arraySize || abonSwimming.length != arraySize || abonGroups.length != arraySize){
            throw new IllegalArgumentException("Все массивы должны иметь стандартный размер " + arraySize + ".");
        }
        else {
            this.abonGym = abonGym;
            this.abonSwimming = abonSwimming;
            this.abonGroups = abonGroups;
        }
    }

    public void setAbonGym(Abonement[] abonGym) {
        this.abonGym = abonGym;
    }

    public void setAbonSwimming(Abonement[] abonSwimming) {
        this.abonSwimming = abonSwimming;
    }

    public void setAbonGroups(Abonement[] abonGroups) {
        this.abonGroups = abonGroups;
    }
    public void fitnessClose(){
        Arrays.fill(this.abonGym,null);
        Arrays.fill(this.abonSwimming,null);
        Arrays.fill(this.abonGroups,null);
    }
    public void addAbon(Abonement abonement){
        if (abonement.getDateRegEnd().isBefore(LocalDate.now())){
            System.out.println("Абонемент просрочен. ");
            System.out.println("-----------------------------------------------------------------------------------------");
            return;
        }
        boolean b = false;
        for (Area a : abonement.getArea()){
            if (abonement.getOwner().getWantArea().equals(a)){
                b = true;
                break;
            }
        }
        if (!b){
            System.out.println("Желаемая зона ("
                    + abonement.getOwner().getWantArea().name()
                    + ") отсутствует в абонементе держателя "
                    + abonement.getOwner().getName() + " "
                    + abonement.getOwner().getSurname() + ".");
            System.out.println("-----------------------------------------------------------------------------------------");
            return;
        }
        for (int i = 0; i < arraySize; i++) {
            if (abonGym[i] == null) {
                abonGym[i] = abonement;
                break;
            }
            else {
                if (i == arraySize - 1){
                    messageForOwner(abonement.getOwner(),Area.GYM);
                    return;
                }
                if (abonGym[i].getArea().equals(abonement.getArea())){
                    System.out.println("Нельзя добавлять абонементы с одинаковыми держателями. ");
                    return;
                }
            }
        }
        if (abonement.getAbonType().equals(AbonTypes.ONEDAY)){
            for (int i = 0; i < arraySize; i++) {
                if (abonSwimming[i] == null) {
                    abonSwimming[i] = abonement;
                    addAbon(abonement);
                    return;
                }
                else {
                    if (abonSwimming[i].getOwner().equals(abonement.getOwner())){
                        System.out.println("Нельзя добавлять абонементы с одинаковыми держателями.");
                        return;
                    }
                }
            }
            messageForOwner(abonement.getOwner(),Area.SWIMMING);
        }
        else if (abonement.getAbonType().equals(AbonTypes.FULL)) {
            for (int i = 0; i < arraySize; i++) {
                if (abonSwimming[i] == null){
                    abonSwimming[i] = abonement;
                    break;
                }
                else {
                    if (i == arraySize - 1){
                        messageForOwner(abonement.getOwner(), Area.GYM);
                        return;
                    }
                    if (abonSwimming[i].getOwner().equals(abonement.getOwner())){
                        System.out.println("Нельзя добавлять абонементы с одинаковыми держателями. ");
                        return;
                    }
                }
            }
            for (int i = 0; i < arraySize; i++) {
                if (abonGroups[i] == null) {
                    abonGroups[i] = abonement;
                    addAbon(abonement);
                    return;
                }
                else {
                    if (abonGroups[i].getOwner().equals(abonement.getOwner())){
                        System.out.println("Нельзя добавлять абонементы с одинаковыми держателями.");
                        return;
                    }
                }
            }
            messageForOwner(abonement.getOwner(), Area.GROUPS);
        } else if (abonement.getAbonType().equals(AbonTypes.EVERYDAY)) {
            for (int i = 0; i < arraySize; i++) {
                if (abonGroups[i] == null){
                    abonGroups[i] = abonement;
                    addAbon(abonement);
                    return;
                }
                else {
                    if (abonGroups[i].getOwner().equals(abonement.getOwner())){
                        System.out.println("Нельзя добавлять абонементы с одинаковыми держателями.");
                        return;
                    }
                }
            }
            messageForOwner(abonement.getOwner(), Area.GROUPS);
        }
    }
    public void addAbon(Abonement... abonements){
        for (Abonement abonement : abonements){
            addAbon(abonement);
        }
    }
    public void messageForOwner(OwnerInform owner, Area area) {
        System.out.println("Сообщение для держателя " + owner.getName() + " " + owner.getSurname()
                + ": в одной из зон вашего абонемента нет свободных мест (" + area.name() + ").");
        System.out.println("-----------------------------------------------------------------------------------------");
    }
    public void aboutArea () {
        System.out.println("В зоне GYM: ");
        for (Abonement a : abonGym){
            if (a != null) System.out.println(a.getOwner().toString());
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("В зоне SWIMMING: ");
        for (Abonement a : abonSwimming){
            if (a != null) System.out.println(a.getOwner().toString());
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("В зоне GROUPS: ");
        for (Abonement a : abonGroups){
            if (a != null) System.out.println(a.getOwner().toString());
        }
    }
    public void addAbonInfo (Abonement abonement){
        System.out.println("Добавлен абонемент.");
        System.out.println("Держатель: " + abonement.getOwner().getName() + " " + abonement.getOwner().getSurname() + ".");
        switch (abonement.getAbonType()) {
            case ONEDAY:
                System.out.println("Зоны: " + Area.GYM.name() + ", " + Area.SWIMMING.name() + ".");
                break;
            case FULL:
                System.out.println("Зоны: " + Area.GYM.name() + ", " + Area.SWIMMING.name() + ", " + Area.GROUPS.name() + ".");
                break;
            case EVERYDAY:
                System.out.println("Зоны: " + Area.GYM.name() + ", " + Area.GROUPS.name() + ".");
                break;
        }
        System.out.println("Дата и время посещения: " + LocalDateTime.now());
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    }