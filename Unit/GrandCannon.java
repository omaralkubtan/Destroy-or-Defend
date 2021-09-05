package DorD.Unit;

import DorD.Team.Player.Player;
import DorD.UnitAttack.NormalUnitAttack;

public class GrandCannon extends Unit{
    public GrandCannon(AttackStrategy attackStrategy, Player owner) {
        super(attackStrategy,owner);
        unitname = unit_name.GrandCannon;
        MaxHealth =6500;
        MaxSpeed = 0;
        damge=150;
        reloadspeed=0.90;
        price=200;
        range=400;
        radius=40;
        activeUnitAttack = new NormalUnitAttack();
        getUnitProperties().add(new HealthUnitProperty(6500));
        getUnitProperties().add(new SpeedUnitProperty(0));
        getUnitProperties().add(new ArmorUnitProperty(0.30));
        for (unit_name s:unit_name.values()) {
            if ( s.getValue()=="Soldier" || s.getValue()=="Tank")
                canAttack.add(s);
        }
        movement= null;
    }
}
