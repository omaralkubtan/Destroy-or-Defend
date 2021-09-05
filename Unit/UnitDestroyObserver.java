package DorD.Unit;

import DorD.Game.Game;

public class UnitDestroyObserver {
    public void OnUnitDestroy(Unit destroyedUnit,Unit unit){
        System.out.println(destroyedUnit.getUnitname().name() +"  "+ destroyedUnit.getUnitId() +" has been destroyed by"+unit.getUnitname().getValue() +"  "+ unit.getUnitId()+"\n");
        Game.getGame().OnUnitDestroy(destroyedUnit,unit);
    }
}
