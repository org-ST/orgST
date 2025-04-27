import java.util.List;

public class Enemy {
    public String name;
    public int[] hp; // [max, current]
    public int[] shield; // [max, current]
    public int[] mana; // [max, current]
    public int attack;
    public int crit;
    public List<String> skills;
    public List<String> dialogue; // [type, message1, message2, etc]
    public int aggro;
    public int[] statuses; // [burn, acid, stun, break, crit more]
    public int broken;
    
    public Enemy(String name, int[] stats, List<String> skills, List<String> dialogue, int aggro) {
        this.name = name;
        this.hp = new int[]{stats[0], stats[0]};
        this.shield = new int[]{stats[1], stats[1]};
        this.mana = new int[]{stats[2], stats[2]};
        this.attack = stats[3];
        this.crit = 25;
        this.skills = skills;
        this.dialogue = dialogue;
        this.aggro = aggro;
        this.statuses = new int[]{0, 0, 0, 0, 0};
        this.broken = 0;
    }
}