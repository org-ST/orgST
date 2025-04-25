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
}
