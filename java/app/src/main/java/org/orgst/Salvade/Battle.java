import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Battle {
    private final Random random = new Random();
    private final Map<String, Skill> skills = new HashMap<>();

    public Battle() {
        skills.put("attack", new Skill(this::attack, 2));
        skills.put("hit", new Skill(this::hit, 2));
        skills.put("whack", new Skill(this::whack, 10));
        skills.put("charge", new Skill(this::charge, 0));
        skills.put("heal", new Skill(this::heal, 5));
        skills.put("stun", new Skill(this::stun, 5));
        skills.put("triple hit", new Skill(this::tripleHit, 5));
        skills.put("defend", new Skill(this::defend, 2));
        skills.put("pierce", new Skill(this::pierce, 5));
        skills.put("focus", new Skill(this::focus, 2));
        skills.put("burn", new Skill(this::burn, 5));
        skills.put("acidify", new Skill(this::acidify, 5));
        skills.put("the ultimate", new Skill(this::ultimate, 15));
    }

    public void damage(double dmg, Object attacker, Object victim) {
        int[] shield, hp;
        if (victim instanceof Player p) {
            shield = p.shield;
            hp = p.hp;
        } else if (victim instanceof Enemy e) {
            shield = e.shield;
            hp = e.hp;
        } else {
            throw new IllegalArgumentException("Invalid victim");
        }

        double critChance = (attacker instanceof Player) ? ((Player) attacker).crit : ((Enemy) attacker).crit;
        if (random.nextDouble() * 100 <= critChance) {
            dmg *= 2;
            System.out.println("Critical Hit!");
        }

        if (shield[1] > 0) {
            shield[1] -= dmg;
            if (shield[1] <= 0) {
                shield[1] = 0;
                if (victim instanceof Player p) p.statuses[3] = 1;
                else ((Enemy) victim).statuses[3] = 1;
            }
        } else {
            hp[1] -= dmg;
            if (hp[1] < 0) hp[1] = 0;
        }

        System.out.println((int)dmg);
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
    }

    public void increase(Object who, String param, int amount) {
        int[] hp, shield, mana;
        if (who instanceof Player p) {
            hp = p.hp;
            shield = p.shield;
            mana = p.mana;
        } else if (who instanceof Enemy e) {
            hp = e.hp;
            shield = e.shield;
            mana = e.mana;
        } else {
            throw new IllegalArgumentException("Invalid character");
        }

        switch (param.toLowerCase()) {
            case "hp", "health" -> hp[1] = Math.min(hp[1] + amount, hp[0]);
            case "shield", "sh" -> shield[1] = Math.min(shield[1] + amount, shield[0]);
            case "mana" -> mana[1] = Math.min(mana[1] + amount, mana[0]);
            default -> System.out.println("Error, " + param + " is not a stat");
        }
    }

    public void again(Object attacker, Object victim) {
        if (victim instanceof Player p) p.statuses[2] += 1;
        else if (victim instanceof Enemy e) e.statuses[2] += 1;
    }

    public String check(String inp, boolean willRun, Player player, Enemy enemy) {
        Skill skill = skills.get(inp.toLowerCase());
        if (skill == null) return "invalid";
        if (player.mana[1] < skill.manaCost) return "broke";

        if (willRun) {
            skill.action.execute(player, enemy);
            player.mana[1] -= skill.manaCost;
        }
        return "ok";
    }

    // Skill Methods
    public void attack(Player attacker, Enemy victim) { damage(attacker.attack, attacker, victim); }
    public void defend(Player attacker, Enemy victim) { increase(attacker, "shield", 1); again(attacker, victim); }
    public void stun(Player attacker, Enemy victim) { damage(attacker.attack * 1.5, attacker, victim); victim.statuses[2] = 1; }
    public void charge(Player who, Enemy enemy) { who.mana[1] = who.mana[0]; }
    public void tripleHit(Player attacker, Enemy victim) {
        damage(attacker.attack * 0.5, attacker, victim);
        sleep(500);
        damage(attacker.attack * 0.5, attacker, victim);
        sleep(500);
        damage(attacker.attack, attacker, victim);
    }
    public void pierce(Player attacker, Enemy victim) {
        victim.statuses[3] = 2;
        damage(attacker.attack * 1.5, attacker, victim);
    }
    public void focus(Player attacker, Enemy victim) {
        attacker.crit *= 2;
        attacker.statuses[4] = 3;
        again(attacker, victim);
    }
    public void burn(Player attacker, Enemy victim) { damage(attacker.attack * 1.5, attacker, victim); victim.statuses[0] += 2; }
    public void acidify(Player attacker, Enemy victim) { damage(attacker.attack * 1.5, attacker, victim); victim.statuses[1] += 2; }
    public void ultimate(Player attacker, Enemy victim) {
        damage(attacker.attack * 2.5, attacker, victim);
        victim.statuses[0] += 3;
        victim.statuses[1] += 3;
        victim.statuses[2] += 3;
        victim.statuses[3] += 3;
        attacker.statuses[4] += 3;
    }
    public void heal(Player attacker, Enemy victim) { increase(attacker, "hp", attacker.hp[0] / 4); }
    public void hit(Player attacker, Enemy victim) {
        damage(attacker.attack * 0.5, attacker, victim);
        again(attacker, victim);
    }
    public void whack(Player attacker, Enemy victim) {
        damage(attacker.attack * 2.5, attacker, victim);
        again(attacker, victim);
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }

    @FunctionalInterface
    interface Action {
        void execute(Player attacker, Enemy victim);
    }

    static class Skill {
        Action action;
        int manaCost;
        Skill(Action action, int manaCost) {
            this.action = action;
            this.manaCost = manaCost;
        }
    }
}