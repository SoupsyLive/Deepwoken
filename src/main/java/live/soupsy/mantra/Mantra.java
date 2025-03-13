package live.soupsy.mantra;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class Mantra extends AbstractMantra{
    public Mantra(String name) {
        super(name);
    }

    public Mantra(ItemStack item) {
        super(item);
    }

    public String getName()
    {
        return name;
    }

    public String getName(boolean addStars, boolean addLevel)
    {
        StringBuilder mantraString = new StringBuilder();
        mantraString.append(name);
        if (addStars)
        {
            mantraString.append(" ");
            mantraString.append("⭐".repeat(Math.max(0, rating)));
        }
        if (addLevel)
            mantraString.append(" Lvl ").append(level);

        return mantraString.toString();
    }

    public int getLevel()
    {
        return level;
    }

    public float getBaseDamage()
    {
        return damage;
    }

    public float calcDamage()
    {
        float levelDmgModifier = damage * Float.max(1, (level*levelDamageScale));
        levelDmgModifier -= damage;
        float attunementDmgModifier = damage * Float.max(1, (attributeScaling * 1)); // TODO: REPLACE LATER WITH ATT STAT
        attunementDmgModifier -= damage;
        return damage + levelDmgModifier + attunementDmgModifier;
    }

    public int getBaseEtherCost()
    {
        return etherCost;
    }

    public int getEtherCost()
    {
        return (int) (etherCost * etherCostMultiplier);
    }

    private void reCalcEtherCost()
    {
        // TODO: Implement Mantra Modifiers lol
    }
    // TODO: Add Mantra Modifiers
    public ArrayList<Object> getModifiers()
    {
        return modifiers;
    }


    public boolean addModifier(Object modifier)
    {
        if(canAddModifier(modifier))
        {
            modifiers.add(modifier);
            return true;
        }
        return false;
    }

    public boolean canAddModifier(Object modifier)
    {
        int maxCount = 3;
        int count = 0;
        for(Object mod : modifiers)
        {
            if (!(mod instanceof Object)) {
                continue;
            }
            count++;
            if(count >= maxCount)
                return false;
        }
        return true;
    }

    // TODO: Add Modifiers to ItemStacks
    public ArrayList<ItemStack> clearModifiers()
    {
        ArrayList<ItemStack> list = new ArrayList<>();

        return list;
    }

    public int getTickCooldown()
    {
        return tickCooldown;
    }

    // TODO: Later replace with entity stats object
    public boolean reachesRequirements(PlayerEntity player) {
        return false;
    }


    public void useMantra()
    {

    }
}
