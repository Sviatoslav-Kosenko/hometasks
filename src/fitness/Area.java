package fitness;

import java.util.Objects;

public enum Area {
    SWIMMING,GROUPS,GYM;

    @Override
    public String toString() {
        return "Area: " + name();
    }
}