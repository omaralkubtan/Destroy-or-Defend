package DorD.Unit;

import DorD.Team.Player.Player;
import DorD.UnitAttack.NormalUnitAttack;

public class PrismTower extends Unit{
    public PrismTower(AttackStrategy attackStrategy, Player owner) {
        super(attackStrategy,owner);
        unitname = unit_name.PrismTower;
        MaxHealth =4000;
        damge=100;
        reloadspeed=0.50;
        price=150;
        range=200;
        radius=30;
        activeUnitAttack = new NormalUnitAttack();
        getUnitProperties().add(new HealthUnitProperty(4000));
        getUnitProperties().add(new SpeedUnitProperty(0));
        getUnitProperties().add(new ArmorUnitProperty(0.70));
        for (unit_name s:unit_name.values()) {
            if ( s.getValue()=="Soldier" || s.getValue()=="Tank")
                canAttack.add(s);
        }
        movement= null;
    }
}
