package DorD.AttackResult;

import DorD.AttackResult.AttackResult;
import DorD.Unit.Unit;

public class EmptyAttackResult extends AttackResult {

    public EmptyAttackResult(){}

    @Override
    public void ApplyAttackResultOnAttacker(Unit unit) {

    }

    @Override
    public void ApplyAttackResultOnReceiver(Unit unit) {

    }
}
