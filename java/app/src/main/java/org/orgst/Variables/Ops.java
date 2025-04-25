package org.orgst.Variables;
import java.util.*;
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
        public Map<String, opInfo> op = new HashMap<>();
        public op(String name , opInfo info){
            
        }
    }
}
