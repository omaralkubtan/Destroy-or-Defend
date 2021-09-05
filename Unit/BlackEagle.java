package DorD.Unit;

import DorD.Team.Player.Player;
import DorD.UnitAttack.NormalUnitAttack;

public class BlackEagle extends Unit{
    public BlackEagle(AttackStrategy attackStrategy, Player owner) {
        super(attackStrategy,owner);
        unitname = unit_name.BlackEagle;
        MaxHealth =1500;
        MaxSpeed = 100;
        damge=40;
        reloadspeed=0;
        price=75;
        range=30;
        radius=1;
        activeUnitAttack = new NormalUnitAttack();
        getUnitProperties().add(new HealthUnitProperty(1500));
        getUnitProperties().add(new SpeedUnitProperty(100));
        getUnitProperties().add(new ArmorUnitProperty(1.0));
        unit_name s = unit_name.MainBase;
                canAttack.add(s);
        if(owner.getId()==1)
            movement= new AttackerMovement();
        else
            movement= new DefenderMovement();
    }
}
