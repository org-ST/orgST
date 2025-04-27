package org.orgst.Salvade;
import org.orgst.Salvade.SkillVar.Skill;
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
        Skill[] skills;
        public void attack(){
        }
        public void hit(){

        }
        public void whack(){}
        public void charge(){}
        public void heal(){}
        public void stun(){}
        public void thit(){}
        public void defend(){}
        public void pierce(){}
        public void focus(){}
        public void burn(){}
        public void acidify(){}
        public void ultimate(){}
        public battle(){
            skills[0] = new Skill("attack", ()->this.attack(), 2);
            skills[1] = new Skill("hit", ()->this.hit(), 2);
            skills[2] = new Skill("whack", ()->this.whack(), 10);
            skills[3] = new Skill("charge", ()->this.charge(), 0);
            skills[4] = new Skill("heal", ()->this.heal(), 5);
            skills[5] = new Skill("stun", ()->this.stun(), 5);
            skills[6] = new Skill("triple hit", ()->this.thit(), 5);
            skills[7] = new Skill("defend", ()->this.defend(), 2);
            skills[8] = new Skill("pierce", ()->this.pierce(), 5);
            skills[9] = new Skill("focus", ()->this.focus(), 2);
            skills[10] = new Skill("burn", ()->this.burn(), 5);
            skills[11] = new Skill("acidify", ()->this.acidify(), 5);
            skills[12] = new Skill("the ultimate", ()->this.ultimate(), 15);
        }
    }
}
