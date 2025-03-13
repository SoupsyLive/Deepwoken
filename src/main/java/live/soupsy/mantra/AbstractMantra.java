package live.soupsy.mantra;

import live.soupsy.attribute.Attribute;
import live.soupsy.attribute.Attributes;
import live.soupsy.component.ModDataComponentTypes;
import live.soupsy.component.components.MantraComponent;
import live.soupsy.item.ModItems;
import live.soupsy.util.DataConversions;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;


import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractMantra {
    protected String name;
    protected String mantraId;
    protected HashMap<Attribute, Integer> requirements;

    // Stats
    protected Attribute mainAttribute;
    protected int rating; // Star count
    protected int level; // Ya know, when ya level up stuff

    protected float damage;
    protected int etherCost;
    protected ArrayList<Object> modifiers; //everything from gems to stones
    protected int tickCooldown;

    // Var Modifiers
    protected float levelDamageScale; // Mult to increase base damage by level
    protected float etherCostMultiplier; // Total changes from everything
    protected float attributeScaling; // Mult to increase base damage by attunement stat

    public AbstractMantra(String name)
    {

    }


    public AbstractMantra(ItemStack item){
        MantraComponent data = item.get(ModDataComponentTypes.MANTRA);
        if (data == null)
            return;

        fillFromComponent(data);
    }

    private void fillFromComponent(MantraComponent data)
    {
        this.name = data.name();
        this.mantraId = data.mantraId();
        String reqAtt = data.reqKeysString();
        String reqAttStat = data.reqValuesString();

        this.requirements = new HashMap<>();
        DataConversions.twoStringToHashMap(requirements, data.reqKeysString(), data.reqValuesString());

        this.mainAttribute = Attributes.getFromString(data.mainAttributeId());
        this.rating = data.rating();
        this.level = data.level();
        this.attributeScaling = data.mainAttributeScaling();

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

    public AbstractMantra() {

    }

    public ItemStack toItemStack() {
        ItemStack item = new ItemStack(ModItems.MANTRA);

        Set<Attribute> atts = this.requirements.keySet();
        String reqs = atts.stream()
                .map(Attribute::getId)
                .collect(Collectors.joining(","));

        Collection<Integer> values = this.requirements.values();
        String cols = String.join(",", values.stream().map(String::valueOf).toList());

        String mods = String.join(",", this.modifiers.stream()
                .map(Object::toString)
                .toList());

        item.set(ModDataComponentTypes.MANTRA, new MantraComponent(
                this.name, this.mantraId, reqs, cols, this.mainAttribute.getId(), this.rating,
                this.level, this.attributeScaling, this.damage, this.etherCost,
                mods, this.tickCooldown, this.levelDamageScale, this.etherCostMultiplier
        ));

        item.set(DataComponentTypes.CUSTOM_NAME, Text.literal(this.name));

        return item;
    }

    public boolean reachesRequirements(PlayerEntity player) {
        return false;
    }

}
