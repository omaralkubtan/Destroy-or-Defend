package DorD.Unit;

import DorD.Team.Player.Player;

public class MainBase extends Unit{
    public MainBase(AttackStrategy attackStrategy, Player owner) {
        super(attackStrategy,owner);
        unitname = unit_name.MainBase;
        MaxHealth =10000;
        damge=0;
        reloadspeed=0;
        price=0;
        range=0;
        radius=50;
        getUnitProperties().add(new HealthUnitProperty(10000));
        getUnitProperties().add(new SpeedUnitProperty(0));
        getUnitProperties().add(new ArmorUnitProperty(1));
        movement= null;
    }
}
