package live.soupsy.mantas;

import live.soupsy.attunements.Attunement;
import live.soupsy.attunements.Flamecharm;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class TestMantra extends MantraOld {

    private HashMap<String, Integer> requirements;

    // Stats
    private Attunement attunement;
    private int rating; // Star count
    private int level; // Ya know, when ya level up stuff
    private float attunementScaling;

    private float damage;
    private int etherCost;
    private ArrayList<Object> modifiers; //everything from gems to stones
    private int tickCooldown;

    // Var Modifiers
    private float levelDamageScale; // Mult to increase base damage by level
    private float etherCostMultiplier; // Total changes from everything

    public TestMantra(String name) {
        Attunement flame = new Flamecharm();
        this.requirements = new HashMap<String, Integer>();

        this.requirements.put(flame.getAttunementName(), 10);
        this.attunement = flame;
        this.rating = 1;
        this.level = 1;
        this.attunementScaling = 1.05f;

        this.damage = 2f;
        this.etherCost = 20;
        this.modifiers = new ArrayList<Object>();
        this.tickCooldown = 10*20;

        this.levelDamageScale = 1.07f;
        this.etherCostMultiplier = 1f;
    }

    public TestMantra(ItemStack item) {
        // Will go through the entire item NBT data
        super(item);
    }

    public boolean useMantra(){
        return true;
    }




}
