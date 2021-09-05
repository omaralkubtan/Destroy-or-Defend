package DorD.Unit;

import DorD.Team.Player.Player;
import DorD.UnitAttack.NormalUnitAttack;

public class PatriotMissile extends Unit{
    public PatriotMissile(AttackStrategy attackStrategy, Player owner) {
        super(attackStrategy,owner);
        unitname = unit_name.PatriotMissile;
        MaxHealth =2500;
        damge=50;
        reloadspeed=0.90;
        price=175;
        range=400;
        radius=40;
        activeUnitAttack = new NormalUnitAttack();
        getUnitProperties().add(new HealthUnitProperty(2500));
        getUnitProperties().add(new SpeedUnitProperty(0));
        getUnitProperties().add(new ArmorUnitProperty(0.20));
        for (unit_name s:unit_name.values()) {
            if (s.getValue().equals("Airplane"))
                canAttack.add(s);
        }
            movement=null;
    }
}
