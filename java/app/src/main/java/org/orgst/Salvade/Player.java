public class Player {
    public String name;
    public int[] hp; // [max, current]
    public int[] shield; // [max, current]
    public int[] mana; // [max, current]
    public int attack;
    public int crit;
    public int[] statuses; // [burn, acid, stun, break, crit more]
    public int broken;
    
    public Player(String name) {
        this.name = name;
        this.hp = new int[]{100, 100};
        this.shield = new int[]{15, 15};
        this.mana = new int[]{10, 10};
        this.attack = 10;
        this.crit = 25;
        this.statuses = new int[]{0, 0, 0, 0, 0};
        this.broken = 0;
    }
}