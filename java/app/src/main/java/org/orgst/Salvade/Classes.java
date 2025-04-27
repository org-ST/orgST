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
            skills[0] = new Skill("attack", ()->{this.attack();}, 2);
            skills[1] = new Skill("hit", ()->{this.hit();}, 2);
            /*
            'whack': [self.whack, 10],
            'charge': [self.charge, 0],
            'heal': [self.heal, 5],
            'stun': [self.stun, 5],
            'triple hit': [self.triple_hit, 5],
            'defend': [self.defend, 2],
            'pierce': [self.pierce, 5],
            'focus': [self.focus, 2],
            'burn': [self.burn, 5],
            'acidify': [self.acidify, 5],
            'the ultimate': [self.ultimate, 15]
             */
        }
    }
}
