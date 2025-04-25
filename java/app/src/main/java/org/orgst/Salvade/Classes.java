package org.orgst.Salvade;

public class Classes {
    public class enemy {
        String name;
        int[] stats;
        String[] skills;
        String[] dialogue;
        int aggro;
        int[] hp = {stats[0], stats[0]};
        int[] sheild = {stats[1], stats[1]};
        int[] mana = {stats[2], stats[2]};
        int attack = stats[3];
        int crit = 25;
        int[] statuses = {0, 0, 0, 0, 0};
        int broken = 0;
        public enemy(String name, int[] stats, String[] skills, String[] dialogue, int aggro) {
            this.name = name;
            this.stats = stats;
            this.skills = skills;
            this.dialogue = dialogue;
            this.aggro = aggro;
        }
    }
}
