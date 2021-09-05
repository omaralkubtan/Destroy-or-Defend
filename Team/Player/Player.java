package DorD.Team.Player;

import DorD.Arena.Arena;
import DorD.Game.Game;
import DorD.Unit.*;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {//implements Runnable

    int points;
    protected int id;
    AttackStrategy tactic;
    List<Unit> units;
//Thread thread;

    public Player(int points,int id) {
        this.points = points;
        this.id=id;
        units = new ArrayList<Unit>();
    }


public int getId(){return id;}

    public void buyunits() {
        UnitFactory unitFactory = new UnitFactory();
        buy:
        while (this.points > unit_name.Infantry.getPrice()) {
            System.out.println("Chose the unit that you want :");
            for(unit_name s : unit_name.values() )
                if (s.getValue()!="MainBase")
                System.out.println(s.ordinal()+"-"+s.name());
                System.out.println("4-Exit");
            String name;
            Scanner sc = new Scanner(System.in);
            name =sc.next();
            if(name.equals("Exit"))
                break;
            unit_name v = null;
            for(  unit_name s : unit_name.values() )
            {
                if (name.equals(s.name())) {
                    if (s.getPrice() > this.points) {
                        System.out.println("You don't have enough points");
                        continue buy;
                    }
                    v=s;
                    this.points -= v.getPrice();
                   break ;
                }
            }
            System.out.println("Set your plan for this unit : \n1)" +"HighestDamage" + "\n2)" + "LowestHealth" + "\n3)" +"Randomly");
            int k;
            k = sc.nextInt();
            switch (k) {
                case 1:
                    tactic = new HighestDamageAttackStrategy();
                case 2:
                    tactic=new LowestHealthAttackStrategy();
                case 3:
                    tactic = new RandomAttackStrategy();
            }

            Unit temp  = unitFactory.CreatUnits(v,tactic,this);
            int x,y;
            System.out.println("Enter x :");
                x=sc.nextInt();
            System.out.println("Enter y :");
                y=sc.nextInt();
            while (!Game.getGame().BuyUnit(this,x,y,temp)) {
                System.out.println("Enter another location for this units");
                sc = new Scanner(System.in);
                x = sc.nextInt();
                y = sc.nextInt();
            }
            if (this.id==1) Game.getGame().addRemainingUnits();
            temp.setx(x);
            temp.sety(y);
            units.add(temp);
        }
            }

    public AttackStrategy getTactic() {
        return tactic;
    }
}