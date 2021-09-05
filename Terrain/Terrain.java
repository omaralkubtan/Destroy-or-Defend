package DorD.Terrain;

import DorD.Unit.Unit;

public abstract class Terrain {
    int x,y,radius;

    public Terrain(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public abstract void applyTerrainEffectOnUnitSpeed(Unit unit);
    public boolean squareIsOccupied(int x,int y)
    {
        int z = this.x;
        for (int i = this.x; i <this.x+ radius; i++) {
            int k = this.y;
            for (int j = this.y; j <this.y+ radius; j++) {

                if (i==x&&j==y)
                    return true;
                if (i==x && k==y)
                    return true;
                k--;
            }
            if (i == this.x) {z--; continue;}
            k = this.y;
            for (int j = this.y; j <this.y+ radius; j++) {
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

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }
}
