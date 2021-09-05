package DorD.AttackResult;

import DorD.Unit.Unit;

public class HealUnitAttackResult extends AttackResult {

    public HealUnitAttackResult(AttackResult attackResult){
        super(attackResult);

    }

    @Override
    public void ApplyAttackResultOnAttacker(Unit unit) {
    }

    @Override
    public void ApplyAttackResultOnReceiver(Unit unit) {
        this.attackResult.ApplyAttackResultOnReceiver(unit);
        /*if(unit.getTargetedUnit().getUnitProperties().get(0).getPropertyValue()<=0){
            return;
        }

        else{
            unit.getTargetedUnit().getUnitProperties().get(0).setPropertyValue(unit.getTargetedUnit().getMaxHealth()* 0.1);
        }*/

    }
}
