package DorD.Arena;

import DorD.Terrain.Terrain;
import DorD.Unit.MainBase;
import DorD.Unit.Unit;
import DorD.Unit.UnitType;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private static Arena x = null;

    public ArrayList<Unit> arena;
    public int array[][];
    public ArrayList<Terrain> terrains;
    private Arena() {
        arena = new ArrayList<Unit>();
        terrains = new ArrayList<Terrain>();
    }

    public static Arena getArena() {
        if (x == null)
            return x = new Arena();
        return x;
    }

    public synchronized Unit checkCell(int x, int y) {
        for (int i=0;i<arena.size();i++)
            if (arena.get(i).squareIsOccupied(x, y))
                return arena.get(i);

        return null;
    }
    public Unit checkCell(int x, int y,Unit unit) {
        for (int i=0;i<arena.size();i++)
            if (arena.get(i).squareIsOccupied(x, y,unit))
                return arena.get(i);

        return null;
    }
    public boolean SetUnits(int x, int y, Unit unit) {
        if(unit.getRadius()+x>1e6 || unit.getRadius()+y>1e6 || x-unit.getRadius()<0 || y-unit.getRadius()<0)
            return false;
        if (checkCell(x, y,unit) == null || unit.getUnitname().getValue().equals("Airplane") || checkCell(x, y,unit).getUnitname().getValue().equals("Airplane") ) {
         //  if(unit instanceof MainBase) {
               unit.setx(x);
               unit.sety(y);
           //}
            //System.out.println(unit.getx());
            arena.add(unit);
            return true;
        }
        return false;
    }

    public void zoom(int x, int y, int i, int j) {
        for (i = 0; i < x; i++)
            for (j = 0; j < y; i++)
                System.out.println(array[i][j]);
    }

    public ArrayList rangeUnits(Unit unit) {
        UnitType target;
        if (unit.getType() == UnitType.AttackUnit)
            target = UnitType.DefendUnit;
        else target = UnitType.AttackUnit;
        List<Unit> unitsInRange = new <Unit>ArrayList();
        Unit u;
        int z = unit.getx()-unit.getRadius();
        for (int i = unit.getx()+unit.getRadius(); i < unit.gety() +unit.getRadius()+ unit.getrange(); i++) {
            int k = unit.gety()-unit.getRadius();
            for (int j = unit.gety()+unit.getRadius(); j < unit.gety() +unit.getRadius()+ unit.getrange(); j++) {
                     u = Arena.x.checkCell(i, j);
                if (u != null && u.getType() == target && !unitsInRange.contains(u))
                    unitsInRange.add(u);
                u= Arena.x.checkCell(i, k);
                if ( u != null &&u.getType() == target && !unitsInRange.contains(u))
                    unitsInRange.add(u);
                k--;
            }
            if (i == unit.getx()+unit.getRadius()) {z--; continue;}
            k = unit.gety()-unit.getRadius();
            for (int j = unit.gety()+unit.getRadius(); j < unit.gety() +unit.getRadius()+ unit.getrange(); j++) {
                u=Arena.x.checkCell(z, j);
                if (u != null && u.getType() == target && !unitsInRange.contains(u))
                    unitsInRange.add(u);
                u =Arena.x.checkCell(z, k);
                if ( u!= null && u.getType() == target && !unitsInRange.contains(u))
                    unitsInRange.add(u);
                k--;
            }
            z--;
        }
        return (ArrayList) unitsInRange;
    }

    public boolean AcceptUnitMovement(Unit unit, int xd, int yd) {
        int x=unit.getx();
        int y=unit.gety();
        int j = y, i = x ;
        if (unit.getx() > xd) { x = unit.getx()-unit.getRadius(); i = x-1;}
        if (unit.getx() < xd) { x = unit.getx()+unit.getRadius(); i = x+1;}
        if (unit.gety() > yd) { y = unit.gety()-unit.getRadius(); j = y-1;}
        if (unit.gety() < yd) { y = unit.gety()+unit.getRadius(); j = y+1;}
        while (i < xd || j < yd) {
            if (checkCell(i, j) != null)
                return false;
            if (j < yd)
                j++;
            else if (j > yd)
                j--;
            if (i < xd)
                i++;
            else if (i>xd)
                i--;
        }
        return true;

    }

    public Terrain checkTerrain(Unit unit,int xd,int yd)
    {
//        int x=unit.getx();
//        int y=unit.gety();
//        int j = y, i = x ;
//        if (unit.getx() > xd) { x = unit.getx()-unit.getRadius(); i = x-1;}
//        if (unit.getx() < xd) { x = unit.getx()+unit.getRadius(); i = x+1;}
//        if (unit.gety() > yd) { y = unit.gety()-unit.getRadius(); j = y-1;}
//        if (unit.gety() < yd) { y = unit.gety()+unit.getRadius(); j = y+1;}
//        while (i < xd || j < yd) {
            for (int k=0;k<terrains.size();k++) {
                if (terrains.get(k).squareIsOccupied(xd, yd))
                    return terrains.get(k);
           }
//            if (j < yd)
//                j++;
//            else if (j > yd)
//                j--;
//            if (i < xd)
//                i++;
//            else if (i>xd)
//                i--;
//        }
        return null;
    }

}