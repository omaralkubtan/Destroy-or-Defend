package DorD.UnitAttack;

import DorD.AttackResult.*;
import DorD.Unit.Unit;
import DorD.UnitAttack.UnitAttack;

public class NormalUnitAttack extends UnitAttack {
    public NormalUnitAttack() {
    }

    protected NormalUnitAttack(UnitAttack unitAttack) {
        super(unitAttack);
    }

    @Override
    public AttackResult PerformAttack(Unit unit)
    {
        AttackResult temp = null;
        temp = new ArmorUnitAttackResult(new EmptyAttackResult());
//        switch(unit.getTargetedUnit().getUnitProperties().length){
//            case 1:
//            {
//                temp = new healthUnitAttackResult(new speedUnitAttackResult(new EmptyAttackResult()));
//            }
//            case 2:
//            {
//                temp = new healthUnitAttackResult(new speedUnitAttackResult(new ArmorUnitAttackResult(new EmptyAttackResult())));
//            }
//            case 3:
//            {
//                temp = new ArmorUnitAttackResult(new speedUnitAttackResult(new HealUnitAttackResult(new EmptyAttackResult())));
//            }
//        }
        return temp;
    }
}
