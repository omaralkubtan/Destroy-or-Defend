package DorD.UnitAttack;

import DorD.AttackResult.AttackResult;
import DorD.Unit.Unit;

public class UnitAttack {
    protected UnitAttack unitAttack;
    private AttackResult attackResult;

    public UnitAttack() {}

    protected UnitAttack(UnitAttack unitAttack) {
        this.unitAttack = unitAttack;
    };

    public AttackResult PerformAttack(Unit unit){
        return this.unitAttack.PerformAttack(unit);
    }

}
