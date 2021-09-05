package DorD.Unit;

import java.util.ArrayList;

public class HighestDamageAttackStrategy implements AttackStrategy {

    @Override
    public Unit PrioritizeUnitToAttack(ArrayList<Unit> units) {
        Unit temp = null;
        for (int i=0;i<units.size();i++)
        {
            if (i==0){
                temp = units.get(i); continue;
            }
            if (units.get(i).damge>temp.damge)
                temp=units.get(i);
        }
        return temp;
    }

}
