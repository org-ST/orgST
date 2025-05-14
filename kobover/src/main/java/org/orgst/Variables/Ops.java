/*
orgST - A fun java console with apps
Copyright (C) 2025  Wdboyes13, MakiDevelops, Table37

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package org.orgst.Variables;
public class Ops {
    public static class opInfo {
        public int argCount;
        public String opName;

        public opInfo(int argCount, String opName) {
            this.argCount = argCount;
            this.opName = opName;
        }
    }

    public static class op {
        public String[] name;
        public opInfo info;

        public op(String[] name, opInfo info) {
            this.name = name;
            this.info = info;
        }

        public boolean hasName(String query) {
            for (String n : name) {
                if (n.equals(query)) return true;
            }
            return false;
        }
    }

    public static final op[] ops = {
        new op(new String[] {"add", "sauce"}, new opInfo(2, "add")),
        new op(new String[]{"sub", "subtract"}, new opInfo(2, "subtract")),
        new op(new String[]{"mul", "multiply"}, new opInfo(2, "multiply")),
        new op(new String[]{"div", "divide"}, new opInfo(2, "divide")),
        new op(new String[]{"exp", "exponentiate"}, new opInfo(2, "exponentiate")),
        new op(new String[]{"sqrt", "square root"}, new opInfo(1, "squareRoot")),
        new op(new String[]{"lop"}, new opInfo(0, "lastOp"))
    };
}
