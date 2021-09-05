package DorD.Terrain;

import DorD.Unit.Unit;

public class Bridge extends Terrain{
    boolean broken;
    public Bridge(int x, int y, int radius) {
        super(x, y, radius);
        broken=false;
    }

    public void setBroken(boolean broken) { this.broken = broken; }

    @Override
    public void applyTerrainEffectOnUnitSpeed(Unit unit) {
        if (broken)
             unit.getUnitProperties().get(1).setPropertyValue(0);
    }

}
