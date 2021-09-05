package DorD.Team;

import DorD.Team.Player.Player;
import DorD.Unit.UnitPosition;
import DorD.Unit.UnitProperty;

import java.util.ArrayList;

public abstract class Team {
    ArrayList <Player> player;


    public Team() {
        player =new ArrayList<Player>();
    }

    public void setPlayer(Player player)
    {


        this.player.add(player);
        player.buyunits();
    }
}
