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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class ChannelData {
    public static class Data {
        public String name;
        public Runnable files;
        public String website;
        public boolean products;
        public String[] people;
        public String info;
        public String date;
        public String comment;
        public Data(String name, Runnable files, String website, boolean products, String[] people, String info, String date, String comment) {
            this.name = name;
            this.files = files;
            this.website = website;
            this.products = products;
            this.people = people;
            this.info = info;
            this.date = date;
            this.comment = comment;
        }  
        @Override
        public String toString() {
            return "Name: " + name +
                   "\nWebsite: " + (website != null ? website : "none") +
                   "\nProducts: " + products +
                   "\nPeople: " + String.join(", ", people) +
                   "\nInfo: " + info +
                   "\nDate: " + date +
                   "\nComment: " + comment + "\n";
        }

    }
    public static List<String> Channels = new ArrayList<String>();
    static {
        Channels.add("OrgST Public Channel");
        Channels.add("CalcTech Channel");
        Channels.add("Toyathings MMD Channel");
        Channels.add("The Archive Channel");
        Channels.add("The Debug Channel");
        Channels.add("The Home Room Channel");
    }
    public static HashMap<String, Data> channels = new HashMap<>();
    static {
        channels = new HashMap<>();
        String[] orgstpeople = {"@Wdboyes13", "@kaycutier (program.task)"};
        Data orgst = new Data("The OrgST Public Channel", null, "https://satelliteearth.wordpress.com", false, orgstpeople, "The public orgST channel.", "2024-12-21", "Welcome to OrgST's workspace.");
        Data calctech = new Data("The CalcTech Channel", () -> org.orgst.channelapps.CTPorted.start() , "https://github.com/Chureki/CalcTrash", false, new String[]{"@chureki (Table)", "@kaycutier (program.task)"}, "A channel for CalcTech!", "2024-12-21", "How about YOU try ASM+");
        Data toyas = new Data("Toyathings MMD channel", null, null, false,  new String[]{"@toyathing"}, "A channel for MMD!", "2024-12-21", "code thingy");
        String[] archivepeople = {"@kaycutier", "@Wdboyes13", "@chureki", "@toyathing"};
        Data archive = new Data("The Archive Channel", null, null, false, archivepeople, "A channel that archives ANYTHING orgST", "2023-12-21", "when we said ANYTHING, we meant it, sleep tight :)");
        String[] debugpeople = {"@keycutier", "@chureki"};
        String[] args = {};
        Data debug = new Data("The Debug Channel", ()->org.orgst.Extras.orgIDimage.main(null), null, false, debugpeople, "fun fun smile", "2024-12-21", "Delusional office is the best doors game honestly.");
        String[] horopeople = {"@kaycutier", "@Wdboyes13"};
        Data horo = new Data("The Home Room Channel", ()-> System.out.println("Please go to AppLoader"), null, false, horopeople, "Info about home room.","2025-04-12", "updates coming soon!");
        channels.put("OrgST Public Channel", orgst);
        channels.put("CalcTech Channel", calctech);
        channels.put("Toyathings MMD Channel", toyas);
        channels.put("The Archive Channel", archive);
        channels.put("The Debug Channel", debug);
        channels.put("The Home Room Channel", horo);
    }
    
}
