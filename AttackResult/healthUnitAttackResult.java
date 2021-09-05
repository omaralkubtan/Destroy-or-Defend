package DorD.AttackResult;

import DorD.AttackResult.AttackResult;
import DorD.Unit.Unit;

public class healthUnitAttackResult extends AttackResult {

    public healthUnitAttackResult(AttackResult attackResult){
        super(attackResult);
    }

    @Override
    public void ApplyAttackResultOnAttacker(Unit unit) {
    }

    @Override
    public void ApplyAttackResultOnReceiver(Unit unit) {
        this.attackResult.ApplyAttackResultOnReceiver(unit);
        unit.getTargetedUnit().AcceptDamage(unit.getDamge(),unit);
    }


}
