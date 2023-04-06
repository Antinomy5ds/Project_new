import java.util.HashMap;

public class AdminPass {
    HashMap<String, String> adminAccount = new HashMap<String, String>();
    String name;

    AdminPass() {
        adminAccount.put("CrossZ", "12345");
    }

    protected HashMap getAdmin() {
        return adminAccount;
    }
}
