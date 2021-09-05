package DorD.Unit;

import DorD.Team.Player.Player;
import DorD.UnitAttack.NormalUnitAttack;

public class GrizzlyTank extends Unit{
    public GrizzlyTank(AttackStrategy attackStrategy, Player owner) {
        super(attackStrategy,owner);
        unitname = unit_name.GrizzlyTank;
        MaxHealth =1000;
        MaxSpeed = 30;
        damge=250;
        reloadspeed=0.60;
        price=50;
        range=250;
        radius=20;
        activeUnitAttack = new NormalUnitAttack();
        getUnitProperties().add(new HealthUnitProperty(1000));
        getUnitProperties().add(new SpeedUnitProperty(30));
        getUnitProperties().add(new ArmorUnitProperty(0.40));
        for (unit_name s:unit_name.values()) {
            if (s.getValue()=="Tank" || s.getValue()=="Soldier"||s.getValue()=="Structure")
                canAttack.add(s);
        }
        if(owner.getId()==1)
            movement= new AttackerMovement();
        else
            movement= new DefenderMovement();
    }
}
