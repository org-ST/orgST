package org.orgst.Salvade;

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
        }
    }
}
