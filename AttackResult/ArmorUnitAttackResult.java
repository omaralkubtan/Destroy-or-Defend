package DorD.AttackResult;

import DorD.Unit.Unit;

public class ArmorUnitAttackResult extends AttackResult {

    public ArmorUnitAttackResult(AttackResult attackResult){
        super(attackResult);

    }

    @Override
    public void ApplyAttackResultOnAttacker(Unit unit) {}

    @Override
    public void ApplyAttackResultOnReceiver(Unit unit) {
        System.out.println(unit.getUnitname().name()+" "+unit.getUnitId()+" attacked "+unit.getTargetedUnit().getUnitname().name()+" "+unit.getTargetedUnit().getUnitId());
        this.attackResult.ApplyAttackResultOnReceiver(unit);
        unit.getTargetedUnit().AcceptDamage((unit.getDamge() * unit.getTargetedUnit().getUnitProperties().get(2).getPropertyValue()),unit);
    }
}
