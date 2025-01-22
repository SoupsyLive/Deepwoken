package live.soupsy.mantas;

import live.soupsy.attunements.Attunement;
import live.soupsy.attunements.Attunements;
import live.soupsy.component.ModDataComponentTypes;
import live.soupsy.component.components.MantraComponent;
import live.soupsy.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;


import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractMantra {
    protected String name;
    protected HashMap<Attunement, Integer> requirements;

    // Stats
    protected Attunement attunement;
    protected int rating; // Star count
    protected int level; // Ya know, when ya level up stuff

    protected float damage;
    protected int etherCost;
    protected ArrayList<Object> modifiers; //everything from gems to stones
    protected int tickCooldown;

    // Var Modifiers
    protected float levelDamageScale; // Mult to increase base damage by level
    protected float etherCostMultiplier; // Total changes from everything
    protected float attunementScaling; // Mult to increase base damage by attunement stat

    public AbstractMantra(String name)
    {

    }

    public AbstractMantra(ItemStack item){
        var data = item.get(ModDataComponentTypes.MANTRA);
        if (data == null)
            return;

        this.name = data.name();
        String reqAtt = data.reqKeysString();
        String reqAttStat = data.reqValuesString();

        this.requirements = new HashMap<>();

        List<String> reqsKeys = Arrays.asList(reqAtt.split(","));
        List<String> reqsValues = Arrays.asList(reqAttStat.split(","));

        for (int i=0; i<reqsKeys.size(); i++)
        {
            Attunement att = Attunements.getFromString(reqsKeys.get(i));
            int val = Integer.parseInt(reqsValues.get(i));
            if(att != null)
                requirements.put(att, val);
        }

        this.attunement = Attunements.getFromString(data.attunementId());
        this.rating = data.rating();
        this.level = data.level();
        this.attunementScaling = data.attunementScaling();

        this.damage = data.damage();
        this.etherCost = data.etherCost();
        this.modifiers = new ArrayList<>();

        List<String> mods = Arrays.asList(data.modifiersString().split(","));

        // Eventually system of modifiers item
        modifiers.addAll(mods);

        this.tickCooldown = data.tickCooldown();

        this.levelDamageScale = data.levelDamageScale();
        this.etherCostMultiplier = data.etherCostMultiplier();
    }

    public ItemStack toItemStack() {
        ItemStack item = new ItemStack(ModItems.MANTRA);

        Set<Attunement> atts = this.requirements.keySet();
        String reqs = atts.stream()
                .map(Attunement::toString)
                .collect(Collectors.joining(","));

        Collection<Integer> values = this.requirements.values();
        String cols = String.join(",", values.stream().map(String::valueOf).toList());

        String mods = String.join(",", this.modifiers.stream()
                .map(Object::toString)
                .toList());

        item.set(ModDataComponentTypes.MANTRA, new MantraComponent(
                this.name, reqs, cols, this.attunement.toString(), this.rating,
                this.level, this.attunementScaling, this.damage, this.etherCost,
                mods, this.tickCooldown, this.levelDamageScale, this.etherCostMultiplier
        ));

        return item;
    }

    public boolean reachesRequirements(PlayerEntity player) {
        return false;
    }


}
