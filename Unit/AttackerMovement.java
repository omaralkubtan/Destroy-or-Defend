package DorD.Unit;

import DorD.Arena.Arena;
import DorD.Game.Game;
import DorD.Terrain.Terrain;

import java.util.Scanner;

public class AttackerMovement extends Movement {
    boolean initialPlan;
    int x,y,n;
    AttackerMovement()
    {
        System.out.println("initial plan?\n 1 if yes \n 2 if no ");
        Scanner sc = new Scanner(System.in);
        if (sc.nextInt() == 1) initialPlan = true;
        else initialPlan = false;
        if (initialPlan) {
            System.out.println("Enter x for plan destination:");
            x = sc.nextInt();
            System.out.println("Enter y for plan destination:");
            y = sc.nextInt();
            System.out.println("Enter time in seconds to wait in plan coordinates");
            n = sc.nextInt();
        }
    }

    @Override
        public synchronized void move(Unit unit) {
        if (initialPlan) initialPlan(unit);
        int Xbase = Game.getGame().getBase().getx();
        int Ybase = Game.getGame().getBase().gety();
        int xd = Xbase, yd = Ybase;
        while (!unit.check())
        {
            if (unit.checkunits())  continue;
//            System.out.println(unit.getx()+" "+unit.gety());
            if ( Xbase < unit.getx())
                xd = (int) (unit.getx() - unit.getRadius() -1);
            else if ( Xbase > unit.getx())
                xd = (int) (unit.getx() + unit.getRadius()+1);
            if (Ybase <  unit.gety())
                yd = (int) (unit.gety() - unit.getRadius() -1);
            else if (Ybase >  unit.gety())
                yd = (int) (unit.gety() + unit.getRadius() +1);
            if(unit.getUnitname().getValue().equals("Airplane")){
                if ( Xbase < unit.getx())
                    xd += unit.getRadius();
                else if ( Xbase > unit.getx())
                    xd -=unit.getRadius();
                if (Ybase <  unit.gety())
                    yd += unit.getRadius();
                else if (Ybase >  unit.gety())
                    yd -=unit.getRadius();
                unit.setx(xd);
                unit.sety(yd);
                try {
                    unit.sleep((long) (1/unit.getUnitProperties().get(1).getPropertyValue()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            Terrain temp = Arena.getArena().checkTerrain(unit,xd,yd);
            if (temp!=null){
              temp.applyTerrainEffectOnUnitSpeed(unit);
                if (unit.getUnitProperties().get(1).getPropertyValue()==0)
                    break;
            }
            if (Arena.getArena().checkCell(xd, yd) == null ) {
                //System.out.printf(xd+"-"+yd);
                if(Arena.getArena().AcceptUnitMovement(unit,xd,yd))
                {
                    if ( Xbase < unit.getx())
                        xd += unit.getRadius();
                    else if ( Xbase > unit.getx())
                        xd -=unit.getRadius();
                    if (Ybase <  unit.gety())
                        yd += unit.getRadius();
                    else if (Ybase >  unit.gety())
                        yd -=unit.getRadius();
                    unit.setx(xd);
                    unit.sety(yd);
                }
            }
            else {
                if (Arena.getArena().checkCell(xd, unit.gety()) == null ) {
                    if(Arena.getArena().AcceptUnitMovement(unit,xd,unit.gety()))
                    {
                        if ( Xbase < unit.getx())
                            xd += unit.getRadius();
                        else if ( Xbase > unit.getx())
                        unit.setx(xd);
                    }

                }
                else if (Arena.getArena().checkCell(unit.getx(), yd) == null ) {
                    if(Arena.getArena().AcceptUnitMovement(unit,unit.getx(),yd))
                    {
                        if (Ybase <  unit.gety())
                            yd += unit.getRadius();
                        else if (Ybase >  unit.gety())
                            yd -=unit.getRadius();
                        unit.sety(yd);
                    }
                }
            }
            try {

                 unit.sleep((long) (1/unit.getUnitProperties().get(1).getPropertyValue()*1000));
                 unit.getUnitProperties().get(1).setPropertyValue(unit.MaxSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void initialPlan(Unit unit) {
        int xd = this.x, yd = this.y;
        while (unit.getx()!=this.x || unit.gety() != this.y )
        {
            if (unit.checkunits())  continue;
            if ( this.x < unit.getx())
                xd = (int) (unit.getx() - unit.getRadius() -1);
            else if ( this.x > unit.getx())
                xd = (int) (unit.getx() + unit.getRadius()+1);
            if (this.y <  unit.gety())
                yd = (int) (unit.gety() - unit.getRadius() -1);
            else if (this.y >  unit.gety())
                yd = (int) (unit.gety() + unit.getRadius() +1);
            if(unit.getUnitname().getValue().equals("Airplane")){
                unit.setx(xd);
                unit.sety(yd);
                try {
                    unit.sleep((long) (1/unit.getUnitProperties().get(1).getPropertyValue()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            Terrain temp = Arena.getArena().checkTerrain(unit,xd,yd);
            if (temp!=null){
                temp.applyTerrainEffectOnUnitSpeed(unit);
                if (unit.getUnitProperties().get(1).getPropertyValue()==0)
                    break;
            }
            if (Arena.getArena().checkCell(xd, yd) == null ) {
                if(Arena.getArena().AcceptUnitMovement(unit,xd,yd))
                {
                    if ( this.x < unit.getx())
                        xd += unit.getRadius();
                    else if ( this.x > unit.getx())
                        xd -=unit.getRadius();
                    if (this.y <  unit.gety())
                        yd += unit.getRadius();
                    else if (this.y >  unit.gety())
                        yd -=unit.getRadius();
                    unit.setx(xd);
                    unit.sety(yd);
                }
            }
            else {
                if (Arena.getArena().checkCell(xd, unit.gety()) == null ) {
                    if(Arena.getArena().AcceptUnitMovement(unit,xd,unit.gety()))
                    {
                        if ( this.x < unit.getx())
                            xd += unit.getRadius();
                        else if ( this.x > unit.getx())
                            xd -=unit.getRadius();
                        unit.setx(xd);
                    }

                }
                else if (Arena.getArena().checkCell(unit.getx(), yd) == null ) {
                    if(Arena.getArena().AcceptUnitMovement(unit,unit.getx(),yd))
                    {
                        if (this.y <  unit.gety())
                            yd += unit.getRadius();
                        else if (this.y >  unit.gety())
                            yd -=unit.getRadius();
                        unit.sety(yd);
                    }
                }
            }
            try {

                unit.sleep((long) (1/unit.getUnitProperties().get(1).getPropertyValue()*1000));
                unit.getUnitProperties().get(1).setPropertyValue(unit.MaxSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            unit.sleep(n*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    }
