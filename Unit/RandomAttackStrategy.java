package DorD.Unit;

import java.util.ArrayList;

public class RandomAttackStrategy implements AttackStrategy {
    @Override
    public Unit PrioritizeUnitToAttack(ArrayList<Unit> units) {
        Unit temp = null;
            if (units.get(0)!=null)
                temp = units.get(0);
        return temp;
    }

}
