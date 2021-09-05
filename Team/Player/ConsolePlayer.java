package DorD.Team.Player;

import DorD.Game.Game;
import DorD.Unit.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsolePlayer extends  Player {

    int points;
    protected int id;
    AttackStrategy tactic;
    List<Unit> units;
//Thread thread;
    public ConsolePlayer(int points, int id) {
        super(points,id);
        this.points = points;
        this.id=id;
        units = new ArrayList<Unit>();
    }

}
