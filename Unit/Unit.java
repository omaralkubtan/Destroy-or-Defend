package DorD.Unit;

import DorD.Arena.Arena;
import DorD.AttackResult.AttackResult;
import DorD.Team.Player.Player;
import DorD.UnitAttack.UnitAttack;
import java.util.ArrayList;

public class Unit extends Thread {
    UnitType type;
    int x;
    int y;
    int MaxHealth;
    int MaxSpeed;
    int damge;
    double reloadspeed;
    int price;
    int range;
    int radius;
    int unitId;
    unit_name unitname;
    Movement movement;
    UnitAttack activeUnitAttack;
    AttackStrategy attackStrategy;
    ArrayList <unit_name> canAttack;
    Unit targetedUnit;
    UnitDestroyObserver unitDestroyObserver;
    ArrayList <UnitProperty> unitProperties;
    private UnitDestroyObserver destructionObserver;
    Player owner;
    private static int idcounter=0;
    public Unit(AttackStrategy attackStrategy, Player owner) {
         this();
        canAttack = new ArrayList<unit_name>();
        unitProperties = new ArrayList<UnitProperty>();
        this.attackStrategy = attackStrategy;
        this.owner=owner;
        idcounter++;
        unitId =idcounter;
        unitDestroyObserver = new UnitDestroyObserver();
        if (owner != null){
        if (owner.getId()==1)
            type = UnitType.AttackUnit;
        else if (owner.getId()==2)
            type = UnitType.DefendUnit;}
    }

    public Unit(){}

    public double getReloadspeed() { return reloadspeed; }

    public int getMaxHealth() { return MaxHealth; }
    public int getDamge() { return damge; }
    public Unit getTargetedUnit() { return targetedUnit; }
    public UnitType getType () {return type;}
    public int getRadius(){return radius;}
    public int getx(){return x;}
    public int gety(){return y;}
    public int getrange(){return range;}
    public void setx(int x){ this.x=x; }
    public void sety(int y){ this.y=y; }
    public void setType( UnitType type){ this.type=type; }
    public int getUnitId(){return unitId;}
    public unit_name getUnitname(){return unitname;}
    public int getMaxSpeed() { return MaxSpeed; }

    public boolean check()
    {
        ArrayList <Unit> o = Arena.getArena().rangeUnits(this);
        boolean foundInRange = false;
        for(int i=0;i<o.size();i++)
        {
            if(o.get(i) instanceof MainBase)
                foundInRange = true;
        }
        return foundInRange;
    }
    public synchronized boolean checkunits()
    {
        ArrayList <Unit> o = new ArrayList<Unit>( Arena.getArena().rangeUnits(this));
        for (int i=0;i<o.size();i++)
        {
            if (!canAttack.contains(o.get(i).getUnitname()))
                o.remove(i);
        }
        if (!o.isEmpty()){
        AttackUnit(attackStrategy.PrioritizeUnitToAttack(o),activeUnitAttack);
            try {
                Thread.sleep((long) (reloadspeed*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
    public boolean squareIsOccupied(int x,int y)
    {
        int z = this.x;
        for (int i = this.x; i < this.x +radius ; i++) {
            int k = this.y;
            for (int j = this.y; j < this.y+radius ; j++) {
                if (i==x&&j==y)
                    return true;
                if (i==x && k==y)
                    return true;
                k--;
            }
            if (i == this.x) {z--; continue;}
            k = this.y;
            for (int j = this.y; j < this.y+ radius; j++) {
                if (z==x && j==y)
                    return true;
                if (z==x && k==y)
                    return true;
                k--;
            }
            z--;
        }
        return false;
    }
    public boolean squareIsOccupied(int x,int y,Unit unit)
    {
        int z = this.x;
        for (int i = this.x; i < this.x +radius+unit.radius ; i++) {
            int k = this.y;
            for (int j = this.y; j < this.y+radius +unit.radius; j++) {
                if (i==x&&j==y)
                    return true;
                if (i==x && k==y)
                    return true;
                k--;
            }
            if (i == this.x) {z--; continue;}
            k = this.y;
            for (int j = this.y; j < this.y+ radius+unit.radius; j++) {
                if (z==x && j==y)
                    return true;
                if (z==x && k==y)
                    return true;
                k--;
            }
            z--;
        }
        return false;
    }
    public synchronized void AttackUnit(Unit targetedUnit,UnitAttack unitAttack)
    {
        this.targetedUnit = targetedUnit;
        AttackResult temp = unitAttack.PerformAttack(this);
        temp.ApplyAttackResultOnReceiver(this);
    }
    public void AcceptDamage(double damage,Unit unit)
    {
        this.unitProperties.get(0).setPropertyValue(this.unitProperties.get(0).getPropertyValue() - damage);
        if(getUnitProperties().get(0).getPropertyValue() <=0)
            onDestroy(unit);
    }

    public final void onDestroy(Unit unit)
    {
        unitDestroyObserver.OnUnitDestroy(this,unit);
    }


    public ArrayList<UnitProperty> getUnitProperties() {
        return unitProperties;
    }
    @Override
    public void run()
    {
       if (this.movement==null) while (true) this.checkunits();
       else
       {

           this.movement.move(this);
           while (true) this.checkunits();
       }
    }


}
