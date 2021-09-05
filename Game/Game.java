package DorD.Game;

import DorD.Arena.Arena;
import DorD.Team.AttackerTeam;
import DorD.Team.DeffenderTeam;
import DorD.Team.Player.Player;
import DorD.Team.Team;
import DorD.Unit.*;

import java.io.*;
import java.util.*;

public class Game {
    private static Game game =null;
   Arena arena;
    List <Team> team;
    Unit base;
    static int  remaining_units;
    GameState state;
    //Thread thread;
    Timer timer;
    int time;
    Timers t;
    ArrayList <Unit> destroyed;
    public static Game getGame(int attackPlayersNumber,int defendPlayersNumber, int time, int points) {
        if(game==null)
            game=new Game(attackPlayersNumber,defendPlayersNumber,time,points);
        return game;
    }
    public static Game getGame() {
        return game;
    }

    public  void setgame(Game game) {
        Game.game = game;
    }

    public Unit getBase()
    {
        return base;
    }
    public ArrayList getDestroyed (){return destroyed;}
    public static void addRemainingUnits() {
        ++remaining_units;
    }

    public void setBase(Unit base) { this.base = base; }
    private Game (){}
    private Game (int attackPlayersNumber, int defendPlayersNumber, int time, int points)
    {
        game =new Game();
        state=GameState.Running;
        arena = Arena.getArena();
        team = new ArrayList<Team>(2);
        destroyed = new ArrayList<Unit>();
        base = new MainBase(null,null);
        base.setType(UnitType.DefendUnit);
        System.out.println("Enter the Base Location");
        Scanner s = new Scanner(System.in);
        int x,y;
        x=s.nextInt();
        y=s.nextInt();
        while(!arena.SetUnits(x,y,base)){
            System.out.println("Enter Another Location");
            x=s.nextInt();
            y=s.nextInt();
        }
        team.add(0,new AttackerTeam());
        team.add(1,new DeffenderTeam());
        for (int i=0;i<defendPlayersNumber;i++)
            team.get(1).setPlayer(new Player(points,2));
            for (int i=0;i<attackPlayersNumber;i++)
            team.get(0).setPlayer(new Player(points, 1)) ;
        timer =new Timer();
        this.time=time;
        t = new Timers(time);


    }
    public void startGame()
    {
        for (int i=0;i<Arena.getArena().arena.size();i++)
        Arena.getArena().arena.get(i).start();
        timer.schedule(new TimeUp(),time*1000);
    }

    public GameState getState() { return state; }


    public void OnUnitDestroy(Unit destroyUnit,Unit unit)
    {
        destroyed.add(unit);
        destroyUnit.stop();
        Arena.getArena().arena.remove(destroyUnit);
        if(destroyUnit.getType()== UnitType.AttackUnit)
        {
            remaining_units--;
            if(remaining_units==0) {
                state=GameState.DeffenderWon;
                System.out.println(state);
                timer.cancel();
                for (int i = 0; i < Arena.getArena().arena.size(); i++){
                    if (Arena.getArena().arena.indexOf(unit)==i)
                        continue;
                    Arena.getArena().arena.get(i).stop();
                }
                Arena.getArena().arena.get(Arena.getArena().arena.indexOf(unit)).stop();
            }
        }
            else if(destroyUnit instanceof MainBase)
        {
            state=GameState.AttakerWon;
            System.out.println(time);
            System.out.println(state);
            for (int i=0;i<Arena.getArena().arena.size();i++)
                System.out.println(Arena.getArena().arena.get(i).getType()+" "+Arena.getArena().arena.get(i).getUnitname().name()+" "+Arena.getArena().arena.get(i).getx()+"-"+Arena.getArena().arena.get(i).gety()  + "    "+Arena.getArena().arena.get(i).getUnitProperties().get(0).getPropertyValue());
            timer.cancel();
            for (int i = 0; i < Arena.getArena().arena.size(); i++){
                if (Arena.getArena().arena.indexOf(unit)==i)
                    continue;
                Arena.getArena().arena.get(i).stop();
            }
            Arena.getArena().arena.get(Arena.getArena().arena.indexOf(unit)).stop();

        }

    }
    public boolean BuyUnit (Player player,int x,int y,Unit unit)
    {
        if (!Arena.getArena().SetUnits(x,y,unit))
            return false;
        return true;
    }

    private class TimeUp extends TimerTask
    {

        @Override
        public void run() {
            if (state==GameState.Running)
            {
                for (int i=0;i<Arena.getArena().arena.size();i++)
                    Arena.getArena().arena.get(i).stop();
                state=GameState.DeffenderWon;
                System.out.println(state);
//                for (int i=0;i<Arena.getArena().arena.size();i++)
//                    System.out.println(Arena.getArena().arena.get(i).getx()+"-"+Arena.getArena().arena.get(i).gety()  + "    "+Arena.getArena().arena.get(i).getUnitProperties().get(0).getPropertyValue());
                timer.cancel();
            }
        }
    }
    public  void SaveGame()throws IOException {
        FileOutputStream f = new FileOutputStream(new File("Game.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(game);
        o.close();
        f.close();
    }
    public void LoadGame() throws IOException {
        FileInputStream fi = new FileInputStream(new File("Game.txt"));
        ObjectInputStream oi = new ObjectInputStream(fi);

        try {
            Game pr1 = (Game) oi.readObject();
            game=pr1;
            oi.close();
            fi.close();

        } catch (FileNotFoundException | ClassNotFoundException e) {
            System.out.println("File not found");
        }
    }
    public void PauseGame(){

        for(int i=0; i<Arena.getArena().arena.size(); i++){
            Arena.getArena().arena.get(i).suspend();
        }
        timer.cancel();
        t.suspend();

    }
    public void Resume(){
        for(int i=0; i<Arena.getArena().arena.size(); i++){
            Arena.getArena().arena.get(i).resume();
        }
        t.resume();
        timer.schedule(new TimeUp(),t.GetTime()*1000);
    }



}
