package fitness;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Abonement implements CheckAbonement {
    protected LocalDate registrDate;
    protected LocalDate endDate;
    protected OwnerInform ownerInform;
    protected String visitArea;

    public Abonement(LocalDate registrDate, LocalDate endDate, OwnerInform ownerInform) {
        this.registrDate = Objects.requireNonNull(registrDate,"registrDate н.б. null");
        this.endDate = Objects.requireNonNull(endDate,"endDate н.б. null");
        if (registrDate.isAfter(endDate)){
            throw new IllegalArgumentException("Дата регистрация д.б. ранее даты конца регистрации");
        }
        this.ownerInform = Objects.requireNonNull(ownerInform,"ownerInform н.б. null");
    }

    public void setVisitArea(String visitArea) {
        this.visitArea = visitArea;
    }

    public OwnerInform getOwnerInform() {
        return ownerInform;
    }

    @Override
    public String toString() {
        return "Abonement{" +
                "registrDate=" + registrDate +
                ", endDate=" + endDate +
                ", ownerInform=" + ownerInform +
                ", visitArea='" + visitArea + '\'' +
                '}';
    }
}
