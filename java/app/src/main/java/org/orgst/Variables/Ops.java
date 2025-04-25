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
        public String name;
        public opInfo info;
        public op(String name, opInfo info){
            this.name = name;
            this.info = info;
        }
    }

    op[] ops = {
        new op("add", new opInfo(1, "add")),
        new op("sauce", new opInfo(1, "add")),
        new op("sub", new opInfo(2, "subtract")),
        new op("subtract", new opInfo(2, "subtract")),
        
    };
}
