package DorD.Unit;
import java.lang.*;
import DorD.Team.Player.Player;

public class UnitFactory {
    public Unit CreatUnits(unit_name name, AttackStrategy attackStrategy, Player owner)
    {
       if(unit_name.TeslaTank==name)
            return new TeslaTank(attackStrategy,owner);
        if(unit_name.Sniper==name)
            return new Sniper(attackStrategy,owner);
        if(unit_name.MirageTank==name)
            return new MirageTank(attackStrategy,owner);
        if(unit_name.Infantry==name)
            return new Infantry(attackStrategy,owner);
        if(unit_name.GrizzlyTank==name)
            return new GrizzlyTank(attackStrategy,owner);
        if(unit_name.NavySeal==name)
            return new NavySeal(attackStrategy,owner);
        if(unit_name.TankDestroyer==name)
            return new TankDestroyer(attackStrategy,owner);
        if(unit_name.PrismTank==name)
            return new PrismTank(attackStrategy,owner);
        if(unit_name.PillBox==name)
            return new PillBox(attackStrategy,owner);
        if(unit_name.PrismTower==name)
            return new PrismTower(attackStrategy,owner);
        if(unit_name.GrandCannon==name)
            return new GrandCannon(attackStrategy,owner);
        if(unit_name.BlackEagle==name)
            return new BlackEagle(attackStrategy,owner);
        if(unit_name.PatriotMissile==name)
            return new PatriotMissile(attackStrategy,owner);
        return null;
    }

}
