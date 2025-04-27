package org.orgst.Salvade;
import java.util.HashMap;
public class Classes {
    public class enemy {
        String name;
        int[] stats;
        String[] skills;
        String[] dialogue;
        int aggro;
        int[] hp;
        int[] sheild;
        int[] mana;
        int attack;
        int crit = 25;
        int[] statuses = {0, 0, 0, 0, 0};
        int broken = 0;

        public enemy(String name, int[] stats, String[] skills, String[] dialogue, int aggro) {
            this.name = name;
            this.stats = stats;
            this.skills = skills;
            this.dialogue = dialogue;
            this.aggro = aggro;

            this.hp = new int[] { stats[0], stats[0] };
            this.sheild = new int[] { stats[1], stats[1] };
            this.mana = new int[] { stats[2], stats[2] };
            this.attack = stats[3];
        }
    }
    public class player {
        String name;
        int[] hp;
        int[] sheild;
        int[] mana;
        int attack;
        int crit;
        int[] statuses;
        int broken;

        public player(String name) {
            this.name = name;
            this.hp = new int[]{100, 100};
            this.sheild = new int[]{15, 15};
            this.mana = new int[]{10, 10};
            this.attack = 10;
            this.crit = 25;
            this.statuses = new int[]{0,0,0,0,0};
            this.broken = 0;
        }
    }
    public class battle {
        HashMap<String, HashMap<Runnable, Integer>> skills;
    }
}
