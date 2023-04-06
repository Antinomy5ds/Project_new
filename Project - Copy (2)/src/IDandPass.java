import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class IDandPass {
    HashMap<String, String> account = new HashMap<String, String>();
    private String getName;

    IDandPass() {
        account.put("John", "45689");
        account.put("Jack", "45789");
        account.put("Mack", "45876");
        account.put("Zack", "59445");
        account.put("Shogun", "15484");
        account.put("Nut", "18455");
        account.put("Astar", "48542");
        account.put("Yee", "78915");
        account.put("Tangmo", "54785");
        account.put("SomO", "35245");
    }

    public int countMember() {
        return account.size();
    }

    public String getValue(int i) {
        Collection<String> value = account.values();
        String[] valueArray = value.toArray(new String[value.size()]);
        return valueArray[i];
    }

    public String getName(int i) {
        Set<String> names = account.keySet();
        String[] nameArray = names.toArray(new String[names.size()]);
        return nameArray[i];
    }

    protected HashMap getAccountInfo() {
        return account;
    }
}
