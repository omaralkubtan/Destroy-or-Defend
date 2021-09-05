package DorD.Unit;

import DorD.Team.Player.Player;
import DorD.UnitAttack.NormalUnitAttack;

public class TankDestroyer extends Unit{
    public TankDestroyer(AttackStrategy attackStrategy, Player owner) {
        super(attackStrategy,owner);
        unitname = unit_name.TankDestroyer;
        MaxHealth =1000;
        MaxSpeed = 20;
        damge=400;
        reloadspeed=0.60;
        price=50;
        range=150;
        radius=20;
        activeUnitAttack = new NormalUnitAttack();
        getUnitProperties().add(new HealthUnitProperty(1000));
        getUnitProperties().add(new SpeedUnitProperty(20));
        getUnitProperties().add(new ArmorUnitProperty(0.50));
        for (unit_name s:unit_name.values()) {
            if (s.getValue()=="Tank")
                canAttack.add(s);
        }
        if(owner.getId()==1)
            movement= new AttackerMovement();
        else
            movement= new DefenderMovement();
    }
}
