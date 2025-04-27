package org.orgst.Salvade;
public class SkillVar {
    public static class Skill{
    String name;
    Runnable fun;
    int num;
    public Skill(String name, Runnable run, int num) {
        this.name = name;
        this.fun = run;
        this.num = num;
    }}
}
