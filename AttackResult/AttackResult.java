package DorD.AttackResult;

import DorD.Unit.Unit;

public  class AttackResult {

    protected AttackResult attackResult;

    public AttackResult(){}

    public AttackResult(AttackResult attackResult) {
        this.attackResult = attackResult;
    }

    public  void ApplyAttackResultOnAttacker(Unit unit){
        this.attackResult.ApplyAttackResultOnAttacker(unit);
    }
    public  void ApplyAttackResultOnReceiver(Unit unit){
        this.attackResult.ApplyAttackResultOnReceiver(unit);
    }
}
