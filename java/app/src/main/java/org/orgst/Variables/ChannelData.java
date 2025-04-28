package org.orgst.Variables;
import java.util.HashMap;
public class ChannelData {
    public static class Data {
        public String name;
        public Runnable[] files;
        public String website;
        public boolean products;
        public String[] people;
        public String info;
        public String date;
        public String comment;
        public Data(String name, Runnable[] files, String website, boolean products, String[] people, String info, String date, String comment) {
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
    public static String[] Channels = {"OrgST Public Channel", "CalcTech Channel", "Toyathings MMD Channel", "The Archive Channel", "The Debug Channel", "The Home Room Channel"};
    public static HashMap<String, Data> channels = new HashMap<>();
    static {
        channels = new HashMap<>();
        String[] orgstpeople = {"@Wdboyes13", "@kaycutier (program.task)"};
        Data orgst = new Data("The OrgST Public Channel", null, "https://satelliteearth.wordpress.com", false, orgstpeople, "The public orgST channel.", "2024-12-21", "Welcome to OrgST's workspace.");
        Data calctech = new Data("The CalcTech Channel", new Runnable[]{() -> {org.orgst.channelapps.CTPorted.start();}}, "https://github.com/Chureki/CalcTrash", false, new String[]{"@chureki (Table)", "@kaycutier (program.task)"}, "A channel for CalcTech!", "2024-12-21", "How about YOU try ASM+");
<<<<<<< HEAD
        Data toyas = new Data("Toyathings MMD channel", null, null, false,  new String[]{"@toyathing"}, "A channel for MMD!", "2024-12-21", "code thingy");
=======
        String[] toyaspeople = {"@toyathing"};
        Data toyas = new Data("Toyathings MMD channel", null, null, false, toyaspeople, "A channel for MMD!", "2024-12-21", "code thingy");
>>>>>>> 2d375c70e4e5980501842c7f104567d5fe9181b9
        String[] archivepeople = {"@kaycutier", "@Wdboyes13", "@chureki", "@toyathing"};
        Data archive = new Data("The Archive Channel", null, null, false, archivepeople, "A channel that archives ANYTHING orgST", "2023-12-21", "when we said ANYTHING, we meant it, sleep tight :)");
        String[] debugpeople = {"@keycutier", "@chureki"};
        String[] args = {};
<<<<<<< HEAD
        Data debug = new Data("The Debug Channel", new Runnable[]{() -> {org.orgst.Extras.ChannelMenu.main(args);}}, null, false, debugpeople, "fun fun smile", "2024-12-21", "Delusional office is the best doors game honestly.");
=======
        Data debug = new Data("The Debug Channel", new Runnable[]{() -> {org.orgst.Extras.ChannelMenu.main(args);;}}, null, false, debugpeople, "fun fun smile", "2024-12-21", "Delusional office is the best doors game honestly.");
>>>>>>> 2d375c70e4e5980501842c7f104567d5fe9181b9
        String[] horopeople = {"@kaycutier"};
        Data horo = new Data("The Home Room Channel", null, null, false, horopeople, "Info about home room.","2025-04-12", "updates coming soon!");
        channels.put("OrgST Public Channel", orgst);
        channels.put("CalcTech Channel", calctech);
        channels.put("Toyathings MMD Channel", toyas);
        channels.put("The Archive Channel", archive);
        channels.put("The Debug Channel", debug);
        channels.put("The Home Room Channel", horo);
    }
    
}
