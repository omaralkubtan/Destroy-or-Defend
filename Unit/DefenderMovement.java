package DorD.Unit;

import DorD.Arena.Arena;
import DorD.Terrain.Terrain;
import com.sun.javaws.IconUtil;
import javafx.util.Pair;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DefenderMovement extends Movement {
private int type,end;
    public DefenderMovement() {
        System.out.println("Enter the Type of movement..\nEnter 1 if you want the movement Vertically\nEnter 2 if you want the movement Horizontally\n");
        Scanner sc = new Scanner(System.in);
        type=sc.nextInt();
        if(type==1 || type==2) {
            System.out.println("Enter the place do you want to go");
            end = sc.nextInt();
        }
    }

    @Override
    public void move(Unit unit) {
        if (type == 1)
            moveHorizontally(unit);
        else if (type == 2)
            moveVertically(unit);
    }
    public void moveHorizontally(Unit unit) {
        final int startx = unit.getx();
        final int endx = end;
        int start;
        while (true) {
            if (unit.checkunits()) continue;
            start = unit.getx();
            int xd;
            if (end == start) {
                if (end == startx)
                    end = endx;
                else end = startx;
            }
            if (start < end) {
                xd = (int) (start + 1);
                if (unit.getUnitname().getValue().equals("Airplane")) {
                    unit.setx(xd);
                    try {
                        unit.sleep((long) (1 / unit.getUnitProperties().get(1).getPropertyValue() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                Terrain temp = Arena.getArena().checkTerrain(unit, xd, unit.gety());
                if (temp != null) {
                    temp.applyTerrainEffectOnUnitSpeed(unit);
                    if (unit.getUnitProperties().get(1).getPropertyValue() == 0)
                        break;
                }
                if (Arena.getArena().AcceptUnitMovement(unit, xd, unit.gety()))
                    unit.setx(xd);
            } else {
                xd = (int) (start - 1);
                if (unit.getUnitname().getValue().equals("Airplane")) {
                    unit.setx(xd);
                    try {
                        unit.sleep((long) (1 / unit.getUnitProperties().get(1).getPropertyValue() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                Terrain temp = Arena.getArena().checkTerrain(unit, xd, unit.gety());
                if (temp != null) {
                    temp.applyTerrainEffectOnUnitSpeed(unit);
                    if (unit.getUnitProperties().get(1).getPropertyValue() == 0)
                        break;
                }
                if (Arena.getArena().checkCell(xd, unit.gety()) != null || Arena.getArena().checkCell(xd, unit.gety()).getUnitname().getValue() != "Airplane") {
                    unit.setx(xd);
                }
            }
            try {
                unit.sleep((long) (1 / unit.getUnitProperties().get(1).getPropertyValue() * 1000));
                unit.getUnitProperties().get(1).setPropertyValue(unit.MaxSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void moveVertically(Unit unit) {
        final int starty = unit.gety();
        final int endy = end;
        int start;
        while (true) {
            if (unit.checkunits()) continue;
            start = unit.gety();

            int yd;
            if (end == start) {
                if (end == starty)
                    end = endy;
                else end = starty;
            }
            if (start < end) {
                yd = (int) (start + 1);
                if (unit.getUnitname().getValue().equals("Airplane")) {
                    unit.sety(yd);
                    try {
                        unit.sleep((long) (1 / unit.getUnitProperties().get(1).getPropertyValue() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                Terrain temp = Arena.getArena().checkTerrain(unit, unit.getx(), yd);
                if (temp != null) {
                    temp.applyTerrainEffectOnUnitSpeed(unit);
                    if (unit.getUnitProperties().get(1).getPropertyValue() == 0)
                        break;
                }
                if (Arena.getArena().AcceptUnitMovement(unit, unit.getx(), yd))
                    unit.sety(yd);
            } else {
                yd = (int) (start - 1);
                if (unit.getUnitname().getValue().equals("Airplane")) {
                    unit.sety(yd);
                    try {
                        unit.sleep((long) (1 / unit.getUnitProperties().get(1).getPropertyValue() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                Terrain temp = Arena.getArena().checkTerrain(unit, unit.getx(), yd);
                if (temp != null) {
                    temp.applyTerrainEffectOnUnitSpeed(unit);
                    if (unit.getUnitProperties().get(1).getPropertyValue() == 0)
                        break;
                }
                if (Arena.getArena().checkCell(unit.getx(), yd) != null || Arena.getArena().checkCell(unit.getx(), yd).getUnitname().getValue() != "Airplane")
                    unit.sety(yd);
            }
            try {
                unit.sleep((long) (1 / unit.getUnitProperties().get(1).getPropertyValue() * 1000));
                unit.getUnitProperties().get(1).setPropertyValue(unit.MaxSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
