package fitness;

import java.util.Objects;

public enum Area {
    SWIMMING,GROUP,GYM;

    private Abonement[] abonements = new Abonement[10];
    private int count = 0;

    public Abonement[] getAbonements(){
        return abonements;
    }
    public boolean isFull(){
        return count == abonements.length;
    }
    public void pushAbonement(Abonement abonement){
        abonement = Objects.requireNonNull(abonement, "abonement н.б null");
        for (int i = 0; i < this.abonements.length; i++) {
            if (this.abonements[i] == null){
                this.abonements[i] = abonement;
                count++;
                return;
            }
        }
    }
    public boolean findAbonement(Abonement abonement){
        abonement = Objects.requireNonNull(abonement, "abonement н.б. null");
        for (Abonement abonement1 : abonements) {
            if(abonement1 != null) {
                if (abonement1.getOwnerInform().equals(abonement.getOwnerInform()) &&
                abonement1.getOwnerInform().hashCode() == abonement.getOwnerInform().hashCode()){
                    System.out.println("Вы уже зарегистрировались в этой зоне  " + this);
                    return true;
                }
            }

        }
        return false;
    }
    public void clear(){
        for (int i = 0; i < this.abonements.length; i++) {
            if (this.abonements[i] != null){
                this.abonements[i] = null;
            }
        }
        this.count = 0;
    }
    public int getCount(){
        return count;
    }
}
