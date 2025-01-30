package live.soupsy.attribute;

import java.util.HashMap;
import java.util.Map;

public class Attributes {
    // BASICS
    public static final Attribute STRENGTH;
    public static final Attribute FORTITUDE;
    public static final Attribute AGILITY;
    public static final Attribute INTELLIGENCE;
    public static final Attribute WILLPOWER;
    public static final Attribute CHARISMA;

    // WEAPON
    public static final Attribute HEAVY_WEAPON;
    public static final Attribute MEDIUM_WEAPON;
    public static final Attribute LIGHT_WEAPON;

    // ATTUNEMENT
    public static final Attribute FLAMECHARM;
    public static final Attribute FROSTDRAW;
    public static final Attribute THUNDERCALL;
    public static final Attribute GALEBREATHE;
    public static final Attribute SHADOWCAST;
    public static final Attribute IRONSING;
    public static final Attribute BLOODREND;

    private static final Map<String, Attribute> attributes = new HashMap<>();

    public Attributes(){}

    static
    {
        STRENGTH = register("strength", new Attribute(), "str", "");
        FORTITUDE = register("fortitude", );
        AGILITY = register("agility", );
        INTELLIGENCE = register("intelligence", );
        WILLPOWER = register("willpower", );
        CHARISMA = register("charisma", );
        HEAVY_WEAPON = register("heavy_weapon", );
        MEDIUM_WEAPON = register("medium_weapon", );
        LIGHT_WEAPON = register("light_weapon", );
        FLAMECHARM = register("flamecharm", );
        FROSTDRAW = register("frostdraw", );
        THUNDERCALL = register("thundercall", );
        GALEBREATHE = register("galebreathe", );
        SHADOWCAST = register("shadowcast", );
        IRONSING = register("ironsing", );
        BLOODREND = register("bloodrend", );
    }

    public static Attribute register(String id, Attribute attData, String abbrev, String desc)
    {
        attributes.put(id, attData);
        return attData;
    }

    public static Attribute getFromString(String id)
    {
        if (!attributes.containsKey(id))
            return null;
        return attributes.get(id);
    }




}
