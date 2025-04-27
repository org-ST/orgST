package org.orgst.Salvade;

import org.orgst.Salvade.Skill.SkillAction;

public class Skill {
    public interface Participant {
        int[] getHp();
        int[] getShield();
        int[] getMana();
        int getAttack();
        int getCrit();
        int[] getStatuses();
        int getBroken();
    }
    @FunctionalInterface
    public interface SkillAction {
        void run(Participant attacker, Participant victim, int damage, int bonus);
    }
    public class SkillVar {
    public static class SkillDetails {
        String name;
        SkillAction action;
        int num;

        public SkillDetails(String name, SkillAction action, int num) {
            this.name = name;
            this.action = action;
            this.num = num;
        }

        public void use(Participant attacker, Participant victim, int damage, int bonus) {
            action.run(attacker, victim, damage, bonus);
        }
    }
}
}
