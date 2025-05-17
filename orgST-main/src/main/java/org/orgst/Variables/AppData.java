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

import java.util.HashMap;

public class AppData {
    public static HashMap<String, String> AppData;
    static {
        AppData = new HashMap<>();
        AppData.put("Version", "1.8.0");
        AppData.put("Updates", "9");
        AppData.put("Authors", "progman.task, Wdboyes13, chureki");
        AppData.put("Title", "orgST");
        AppData.put("Sponsors", "orgST Public, Archive, CalcTech, toyathing");
        AppData.put("GitHub", "https://github.com/MakiDevelops/orgST");
        AppData.put("Website", "https://orgst.ca");
    }
}
