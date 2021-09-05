package DorD.Unit;

import DorD.Team.Player.Player;
import DorD.UnitAttack.NormalUnitAttack;

public class MirageTank extends Unit{
    public MirageTank(AttackStrategy attackStrategy, Player owner) {
        super(attackStrategy,owner);
        unitname = unit_name.MirageTank;
        MaxHealth =750;
        MaxSpeed = 60;
        damge=1000;
        reloadspeed=1;
        price=70;
        range=10;
        radius=15;
        activeUnitAttack = new NormalUnitAttack();
        getUnitProperties().add(new HealthUnitProperty(750));
        getUnitProperties().add(new SpeedUnitProperty(60));
        getUnitProperties().add(new ArmorUnitProperty(0.10));
        for (unit_name s:unit_name.values()) {
            if (s.getValue()=="Tank" || s.getValue()=="Soldier" || s.getValue()=="Structure")
                canAttack.add(s);
        }
        if(owner.getId()==1)
            movement= new AttackerMovement();
        else
            movement= new DefenderMovement();
    }
}
