package DorD.Unit;

import java.util.ArrayList;

public class LowestHealthAttackStrategy implements AttackStrategy {

    @Override
    public Unit PrioritizeUnitToAttack(ArrayList<Unit> units) {
        Unit temp = null;
        for (int i=0;i<units.size();i++)
        {
            if (temp==null){
                temp = units.get(i); continue;
            }else if (units.get(i).getUnitProperties().get(0).getPropertyValue()<temp.getUnitProperties().get(0).getPropertyValue())
                temp=units.get(i);
        }
        return temp;
    }

}
