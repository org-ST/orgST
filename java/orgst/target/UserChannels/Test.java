import org.orgst.Variables.ChannelData.Data;
public class Test {
    public static Data data(){
        return new Data(
                "Test",
                ()-> {System.out.println("Hello from the test chnl");}
                ,"https://weelam.ca",
                false,
                new String[]{"Wdboyes13"},
                "This is a test channel :3",
                "2025-05-04",
                ":3"
        );}
}