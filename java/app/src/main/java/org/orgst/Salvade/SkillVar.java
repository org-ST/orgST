package org.orgst.Salvade;

import java.util.HashMap;

public class SkillVar {
    public class Skill{
    String name;
    Runnable fun;
    int num;
    public Skill(String name, Runnable run, int num) {
        HashMap<Runnable, Integer> skillMap = new HashMap<>();
        skillMap.put(run, Integer.valueOf(num));
    }}
}
