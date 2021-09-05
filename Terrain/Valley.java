package DorD.Terrain;

import DorD.Unit.Unit;

public class Valley extends Terrain{

    public Valley(int x, int y, int radius) {
        super(x, y, radius);
    }

    @Override
    public void applyTerrainEffectOnUnitSpeed(Unit unit) {
        unit.getUnitProperties().get(1).setPropertyValue(0);
    }



}
