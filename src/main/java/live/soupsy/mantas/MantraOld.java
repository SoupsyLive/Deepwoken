package live.soupsy.mantas;

import live.soupsy.attunements.Attunement;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class MantraOld {
    private String name;
    private HashMap<Attunement, Integer> requirements;

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

    // Methods
    public MantraOld(){

    }
    public MantraOld(ItemStack item){}

    public boolean reachesRequirements(PlayerEntity player) {
        return false;
    }

    // Later for our custom entity whatever to directly checks stats
//    public boolean reachesRequirements(PlayerEntity player){
//        return false;
//    }

    public Attunement getMainAttunement(){
        return this.attunement;
    }

    public int getRating() {
        return this.rating;
    }

    public int getLevel(){
        return this.level;
    }

    public float getDamage() {
        return damage;
    }

    public int getEtherCost() {
        return etherCost;
    }

    public ArrayList<Object> getModifiers() {
        return modifiers;
    }

    public float calcDamage() {
        return this.damage * Float.max(1.0f,this.level * this.levelDamageScale);
    }


    public boolean useMantra(){
        return false;
    }

    public ItemStack toItemStack() {
        return null;
    }

    public String toString(){
        return this.name+" ["+this.level+"]: "+this.attunement.abbrev();
    }

}
