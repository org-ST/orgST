package org.orgst.Salvade;

import java.util.HashMap;

public class SkillVar {
    public class Skill{
    String name;
    Runnable fun;
    int num;
    public Skill(String name, Runnable run, int num) {
        this.name = name;
        this.fun = run;
        this.num = num;
    }}
}
