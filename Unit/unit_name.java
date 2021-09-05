package DorD.Unit;

public enum unit_name {

        TeslaTank("Tank",50),
        Sniper("Soldier",5),
        MirageTank("Tank",70),
        Infantry("Soldier",3),
        GrizzlyTank("Soldier",50),
        NavySeal("Soldier",10),
        TankDestroyer("Tank",50),
        PrismTank("Tank",60),
        PillBox("Structure",150),
        PrismTower("Structure",150),
        GrandCannon("Structure",200),
        BlackEagle("Airplane",75),
        PatriotMissile("Structure" ,175),
        MainBase("Structure",0);

        private  String value;
        private  int price ;
        private unit_name(String value,int price) {
                this.value = value;
                this.price=price;
        }

        public  unit_name getunit() {
                return this;
        }

        public int getPrice() {
                return price;
        }

        public String getValue() {
                return value;
        }
}
