package DorD.Unit;

import java.util.ArrayList;

public interface AttackStrategy {
    public abstract Unit PrioritizeUnitToAttack(ArrayList <Unit> units);
}
