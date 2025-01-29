package live.soupsy.attunement;


import java.util.HashMap;
import java.util.Map;

public class Attunements {
    public static final Attunement FLAMECHARM;
    public static final Attunement FROSTDRAW;
    public static final Attunement THUNDERCALL;
    public static final Attunement GALEBREATHE;
    public static final Attunement SHADOWCAST;
    public static final Attunement IRONSING;
    public static final Attunement BLOODREND;

    private static final Map<String, Attunement> attunements = new HashMap<>();

    public Attunements(){}

    static
    {
        FLAMECHARM = register("flamecharm", new Flamecharm());
        FROSTDRAW = register("frostdraw", new Flamecharm());
        THUNDERCALL = register("thundercall", new Flamecharm());
        GALEBREATHE = register("galebreathe", new Flamecharm());
        SHADOWCAST = register("shadowcast", new Flamecharm());
        IRONSING = register("ironsing", new Flamecharm());
        BLOODREND = register("bloodrend", new Flamecharm());
    }

    public static Attunement register(String id, Attunement attData)
    {
        attunements.put(id, attData);
        return null;
    }

    public static Attunement getFromString(String att) {
        if (!attunements.containsKey(att))
            return null;
        return attunements.get(att);
    }
}
