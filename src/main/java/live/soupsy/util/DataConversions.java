package live.soupsy.util;

import java.util.HashMap;

public class DataConversions {


    public static void twoStringToHashMap(HashMap map, String keys, String vals)
    {
        String[] s1List = keys.split(",");
        String[] s2List = vals.split(",");

        for (int i = 0; i < s1List.length && i < s2List.length; i++) {
            map.put(s1List[i].trim(), s2List[i].trim());
        }
    }
}
