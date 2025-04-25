package org.orgst.Variables;
import java.util.HashMap;
public class ChannelData {
    public static class Data {
        public String name;
        public String[] files;
        public String website;
        public boolean products;
        public String[] people;
        public String info;
        public String date;
        public String comment;
        public Runnable fp;
        public Data(String name, String[] files, String website, boolean products, String[] people, String info, String date, String comment, String fp) {
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
                   "\nFiles: " + (files != null ? String.join(", ", files) : "none") +
                   "\nWebsite: " + (website != null ? website : "none") +
                   "\nProducts: " + products +
                   "\nPeople: " + String.join(", ", people) +
                   "\nInfo: " + info +
                   "\nDate: " + date +
                   "\nComment: " + comment + "\n";
        }

    }
    public static String[] Channels = {"OrgST Public Channel", "CalcTech Channel", "Toyathings MMD Channel", "The Archive Channel", "The Debuc Channel", "The Home Room Channel"};
    public static HashMap<String, Data> channels = new HashMap<>();
    static {
        channels = new HashMap<>();
        String[] orgstpeople = {"@Wdboyes13", "@kaycutier (program.task)"};
        String[] orgstfiles = null;
        Data orgst = new Data(
            "The OrgST Public Channel",
            orgstfiles,
            "https://satelliteearth.wordpress.com",
            false,
            orgstpeople,
            "The public orgST channel.",
            "2024-12-21",
            "Welcome to OrgST's workspace.",
            "channels/pub.py"
            );
        String[] clactechfiles = {"calctrash.py"};
        String[] calctechpeople = {"@chureki (Table)", "@kaycutier (program.task)"};
        Data calctech = new Data("The CalcTech Channel", clactechfiles, "https://github.com/Chureki/CalcTrash", false, calctechpeople, "A channel for CalcTech!", "2024-12-21", "How about YOU try ASM+", "channels/calctech.py");
        String[] toyaspeople = {"@toyathing"};
        Data toyas = new Data("Toyathings MMD channel", null, null, false, toyaspeople, "A channel for MMD!", "2024-12-21", "code thingy", "channels/mmd.py");
        String[] archivepeople = {"@kaycutier", "@Wdboyes13", "@chureki", "@toyathing"};
        Data archive = new Data("The Archive Channel", null, null, false, archivepeople, "A channel that archives ANYTHING orgST", "2023-12-21", "when we said ANYTHING, we meant it, sleep tight :)", "channels/archive.py");
        String[] debugpeople = {"@keycutier", "@chureki"};
        Data debug = new Data("The Debug Channel", null, null, false, debugpeople, "fun fun smile", "2024-12-21", "Delusional office is the best doors game honestly.", "channels/debug.py");
        String[] horopeople = {"@kaycutier"};
        Data horo = new Data("The Home Room Channel", null, null, false, horopeople, "Info about home room.","2025-04-12", "updates coming soon!", "channels/debug.py");
        channels.put("OrgST Public Channel", orgst);
        channels.put("CalcTech Channel", calctech);
        channels.put("Toyathings MMD Channel", toyas);
        channels.put("The Archive Channel", archive);
        channels.put("The Debug Channel", debug);
        channels.put("The Home Room Channel", horo);
    }
    
}
