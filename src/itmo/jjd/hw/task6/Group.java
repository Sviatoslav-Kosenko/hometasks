package itmo.jjd.hw.task6;

import itmo.jjd.hw.task6.Mountain;
import itmo.jjd.hw.task6.Climber;

import java.util.Arrays;

public class Group {
        private boolean isNabor;
        private Climber [] climbers;
        private Mountain mountain;
        private int sizeGroup;

        public Group(boolean isNabor, Mountain mountain, int sizeGroup) {
            setNabor(isNabor);
            setMountain(mountain);
            setSizeGroup(sizeGroup);
            setClimber(sizeGroup);
        }

    private void setClimber(int sizeGroup) {
            if (sizeGroup < 1){
                throw new IllegalArgumentException("Размер групы н.б меньше 0 Альпинистов");
            }
            this.climbers = new Climber[sizeGroup];
    }

    public void setSizeGroup(int sizeGroup) {
            if (sizeGroup < 1) {
                throw new IllegalArgumentException("Размер групы н.б меньше 0 Альпинистов");
            }
            this.sizeGroup = sizeGroup;
    }

    public void setMountain(Mountain mountain) {
            if (mountain == null) {
              throw new IllegalArgumentException("mountain н.б. пустым");
            }
            this.mountain = mountain;
    }

    public void setNabor(boolean nabor) {
             isNabor = nabor ;
    }

    public boolean isNabor() {
        return isNabor;
    }
    public Climber[] getClimbers(){
            return climbers;
    }
    public Mountain getMountain(){
            return mountain;
    }
    public int getSizeGroup() {
            return sizeGroup;
    }
     public void addClimber(Climber climber) {
         if (climber == null) {
             throw new IllegalArgumentException("Ошибка при добавлении пустого альпиниста");
         }
         if (isNabor) {
             for (int i = 0; i < climbers.length; i++) {
                 if (climbers[i] == null) {
                     climbers[i] = climber;
                     if (i == climbers.length - 1) setNabor(true);
                     return;
                 }
                 System.out.println("Набор в группу окончен");
                 System.out.println("# # # # # # # #");
             }
         } else {
                 setNabor(false);
                 System.out.println("Набор в группу окончен");
              }
        }

    @Override
    public String toString() {
        return "Group{" +
                "isNabor=" + isNabor +
                ", climbers=" + Arrays.toString(climbers) +
                ", mountain=" + mountain +
                ", sizeGroup=" + sizeGroup +
                '}';
    }
}
