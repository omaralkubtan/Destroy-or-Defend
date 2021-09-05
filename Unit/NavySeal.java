package DorD.Unit;

import DorD.Team.Player.Player;
import DorD.UnitAttack.NormalUnitAttack;

public class NavySeal extends Unit {
    public NavySeal(AttackStrategy attackStrategy, Player owner) {
        super(attackStrategy,owner);
        unitname = unit_name.NavySeal;
        MaxHealth =400;
        MaxSpeed = 20;
        damge=60;
        reloadspeed=2;
        price=10;
        range=50;
        radius=3;
        activeUnitAttack = new NormalUnitAttack();
        getUnitProperties().add(new HealthUnitProperty(400));
        getUnitProperties().add(new SpeedUnitProperty(20));
        getUnitProperties().add(new ArmorUnitProperty(0.20));
        for (unit_name s:unit_name.values()) {
            if (s.getValue()=="Tank" || s.getValue()=="Soldier")
                canAttack.add(s);
        }
        if(owner.getId()==1)
            movement= new AttackerMovement();
        else
            movement= new DefenderMovement();
    }
}
