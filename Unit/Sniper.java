package DorD.Unit;

import DorD.Team.Player.Player;
import DorD.UnitAttack.NormalUnitAttack;

public class Sniper extends Unit {

    public Sniper(AttackStrategy attackStrategy, Player owner) {
        super(attackStrategy, owner);
        unitname = unit_name.Sniper;
        MaxHealth =250;
        MaxSpeed = 10;
        damge=75;
        reloadspeed=0.4;
        price=5;
        range=700;
        radius=3;
        activeUnitAttack = new NormalUnitAttack();
        getUnitProperties().add(new HealthUnitProperty(250));
        getUnitProperties().add(new SpeedUnitProperty(10));
        getUnitProperties().add(new ArmorUnitProperty(0.10));
        for (unit_name s:unit_name.values()) {
            if ( s.getValue()=="Soldier")
                canAttack.add(s);
        }
        if(owner.getId()==1)
            movement= new AttackerMovement();
        else
            movement= new DefenderMovement();
    }
}
