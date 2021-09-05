package DorD.Unit;

public class UnitPosition {

    private int centerX,centerY,radius;

    public UnitPosition(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public boolean squareIsOccupied()
    {
return true;
    }

}
