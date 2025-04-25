package org.orgst.Variables;
public class Ops {
    public class opInfo{
        public int argCount;
        public String opName;
        public opInfo(int argCount, String opName){
            this.argCount = argCount;
            this.opName = opName;
        }
    }
    public class op {
        public String[] name;
        public opInfo info;
        public op(String[] name, opInfo info){
            this.name = name;
            this.info = info;
        }
    }

    op[] ops = {
        new op(new String[] {"add", "sauce"}, new opInfo(1, "add")),
        new op(new String[]{"sub", "subtract"}, new opInfo(2, "subtract")),
        new op(new String[]{"mul", "multiply"}, new opInfo(2, "multiply")),
        new op(new String[]{"div", "divide"}, new opInfo(2, "divide")),
        new op(new String[]{"exp", "exponentiate"}, new opInfo(2, "exponentiate")),
        new op(new String[]{"sqrt", "square root"}, new opInfo(1, "squareRoot"))
    };
}
