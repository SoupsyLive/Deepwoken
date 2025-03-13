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
        STRENGTH = register("strength", new Attribute(), "str", "Physical strength. Increases carry load, armor penetration, and the damage scaling of strength mantras.");
        FORTITUDE = register("fortitude", new Attribute(), "ftd", "Resilience against threats. Increases Health slightly per point.");
        AGILITY = register("agility", new Attribute(), "agl", "Sleight of Hand and Nimbleness. Increases Parkour and Stealth slightly per point.");
        INTELLIGENCE = register("intelligence", new Attribute(), "int", "Logic and problem-solving skills. Increases Ether slightly per intelligence point.");
        WILLPOWER = register("willpower", new Attribute(), "wll", "Your character's mental integrity and ability to keep a steady mind. Increases Sanity and Tempo and reduce knock time per point.");
        CHARISMA = register("charisma", new Attribute(), "cha", "Your character's ability to influence others with their personality. Increases Ether slightly per Charisma.");
        HEAVY_WEAPON = register("heavy_weapon", new Attribute(), "hvy", "Increases your character's proficiency with heavy weapons—this increases the extra damage dealt by your weapon's scaling.");
        MEDIUM_WEAPON = register("medium_weapon", new Attribute(), "med", "Increases your character's proficiency with medium weapons—this increases the extra damage dealt by your weapon's scaling.");
        LIGHT_WEAPON = register("light_weapon", new Attribute(), "lht", "Increases your character's proficiency with light weapons—this increases the extra damage dealt by your weapon's scaling.");
        FLAMECHARM = register("flamecharm", new Attribute(), "fir", "Increases damage scaling of Flamecharm mantras.");
        FROSTDRAW = register("frostdraw", new Attribute(), "ice", "Increases damage scaling of Frostdraw mantras.");
        THUNDERCALL = register("thundercall", new Attribute(), "ltn", "Increases damage scaling of Thundercall mantras.");
        GALEBREATHE = register("galebreathe", new Attribute(), "wnd", "Increases damage scaling of Galebreathe mantras.");
        SHADOWCAST = register("shadowcast", new Attribute(), "sdw", "Increases damage scaling of Shadowcast mantras and the amount of ether you steal from enemies.");
        IRONSING = register("ironsing", new Attribute(), "mtl", "Increases damage scaling of Ironsing mantras.");
        BLOODREND = register("bloodrend", new Attribute(), "bld", "Increases damage scaling of Bloodrend mantras.");
    }

    public static Attribute register(String id, Attribute attData, String abbrev, String desc)
    {
        attData.setAbbrev(abbrev);
        attData.setDescription(desc);
        attData.setId(id);

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
