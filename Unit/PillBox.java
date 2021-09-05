package DorD.Unit;

import DorD.Team.Player.Player;
import DorD.UnitAttack.NormalUnitAttack;

public class PillBox extends Unit{
    public PillBox(AttackStrategy attackStrategy, Player owner) {
        super(attackStrategy,owner);
        unitname = unit_name.PillBox;
        MaxHealth =4000;
        damge=100;
        reloadspeed=0.70;
        price=150;
        range=200;
        radius=40;
        activeUnitAttack = new NormalUnitAttack();
        getUnitProperties().add(new HealthUnitProperty(4000));
        getUnitProperties().add(new SpeedUnitProperty(0));
        getUnitProperties().add(new ArmorUnitProperty(0.70));
        for (unit_name s:unit_name.values()) {
            if ( s.getValue()=="Soldier" )
                canAttack.add(s);
        }
            movement= null;
    }
}
