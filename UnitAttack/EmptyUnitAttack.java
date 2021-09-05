package DorD.UnitAttack;

import DorD.AttackResult.AttackResult;
import DorD.Unit.Unit;

public class EmptyUnitAttack extends UnitAttack {

    protected EmptyUnitAttack() {}

    public AttackResult PerformAttack(Unit unit){return null;}
}
