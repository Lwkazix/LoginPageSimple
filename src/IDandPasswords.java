import java.util.HashMap;

public class IDandPasswords {

    HashMap<String,String> loginInfo = new HashMap<String,String>();

    IDandPasswords(){
        loginInfo.put("Bro","pizza");
        loginInfo.put("Lwkazix","14460880");
        loginInfo.put("BroCode","abc123");
    }
    protected HashMap getLoginInfo(){
        return loginInfo;
    }
}
