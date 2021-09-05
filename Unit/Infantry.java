package DorD.Unit;

import DorD.Team.Player.Player;
import DorD.UnitAttack.NormalUnitAttack;

public class Infantry extends Unit{
    public Infantry(AttackStrategy attackStrategy, Player owner) {
        super(attackStrategy,owner);
        unitname = unit_name.Infantry;
        MaxHealth =250;
        MaxSpeed = 10;
        damge=50;
        reloadspeed=1.5;
        price=3;
        range=50;
        radius=3;
        activeUnitAttack = new NormalUnitAttack();
        getUnitProperties().add(new HealthUnitProperty(250));
        getUnitProperties().add(new SpeedUnitProperty(10));
        getUnitProperties().add(new ArmorUnitProperty(0.20));
        for (unit_name s:unit_name.values()) {
            if (s.getValue()=="Soldier")
                canAttack.add(s);
        }
        if(owner.getId()==1)
            movement= new AttackerMovement();
        else
            movement= new DefenderMovement();
    }
}
