package DorD.AttackResult;

import DorD.AttackResult.AttackResult;
import DorD.Unit.Unit;

public class speedUnitAttackResult extends AttackResult {

    public speedUnitAttackResult(AttackResult attackResult){
        super(attackResult);
    }

    @Override
    public void ApplyAttackResultOnAttacker(Unit unit) {

    }

    @Override
    public void ApplyAttackResultOnReceiver(Unit unit) {
        this.attackResult.ApplyAttackResultOnReceiver(unit);
        unit.getTargetedUnit().getUnitProperties().get(1).setPropertyValue(unit.getTargetedUnit().getUnitProperties().get(1).getPropertyValue()/3);
    }
}
