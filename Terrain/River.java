package DorD.Terrain;

import DorD.Unit.Unit;

public class River extends Terrain{

    public River(int x, int y, int radius) {
        super(x, y, radius);
    }

    @Override
    public void applyTerrainEffectOnUnitSpeed(Unit unit) {
        unit.getUnitProperties().get(1).setPropertyValue(unit.getUnitProperties().get(1).getPropertyValue()/2);

    }

}
