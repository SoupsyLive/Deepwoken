package live.soupsy.weapon;

import live.soupsy.attribute.Attribute;
import live.soupsy.component.ModDataComponentTypes;
import live.soupsy.component.components.MantraComponent;
import live.soupsy.component.components.WeaponComponent;
import live.soupsy.item.ModItems;
import live.soupsy.util.DataConversions;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class Weapon {
    private String name;
    private String id;
    private String weaponType;
    private HashMap<Attribute, Integer> requirements;
    private HashMap<Attribute, Float> scaling;

    private int rating;
    private int baseDamage;
    private int basePen;
    private float chipDamage;
    private int weight;
    private float swingSpeed;
    private float endLagTicks;

    private String enchant;
    private String specialRarity;

    public Weapon()
    {

    }

    public Weapon(ItemStack item)
    {
        WeaponComponent data = item.get(ModDataComponentTypes.WEAPON);
        if (data == null)
            return;

        fillFromComponent(data);
    }

    public ItemStack toItemStack()
    {
        ItemStack item = new ItemStack(ModItems.WEAPON);

        Set<Attribute> reqKeys = this.requirements.keySet();
        String reqs = reqKeys.stream()
                .map(Attribute::getId)
                .collect(Collectors.joining(","));

        Collection<Integer> reqValues = this.requirements.values();
        String reqVals = String.join(",", reqValues.stream().map(String::valueOf).toList());

        Set<Attribute> scalKeys = this.requirements.keySet();
        String scals = scalKeys.stream()
                .map(Attribute::getId)
                .collect(Collectors.joining(","));

        Collection<Integer> scalValues = this.requirements.values();
        String scalVals = String.join(",", scalValues.stream().map(String::valueOf).toList());


        item.set(ModDataComponentTypes.WEAPON, new WeaponComponent(
                this.name, this.id, this.weaponType, reqs, reqVals, scals, scalVals, this.rating,
                this.baseDamage, this.basePen, this.chipDamage, this.weight, this.swingSpeed,
                this.endLagTicks, this.enchant, this.specialRarity
        ));

        item.set(DataComponentTypes.CUSTOM_NAME, Text.literal(this.name));

        return item;
    }

    private void fillFromComponent(WeaponComponent data)
    {
        name = data.name();
        id = data.weaponId();
        weaponType = data.weaponType();

        requirements = new HashMap<>();
        DataConversions.twoStringToHashMap(requirements, data.reqKeysString(), data.reqValuesString());

        scaling = new HashMap<>();
        DataConversions.twoStringToHashMap(scaling, data.scalingKeysString(), data.scalingValuesString());

        rating = data.rating();
        baseDamage = data.baseDamage();
        basePen = data.basePen();
        chipDamage = data.chipDamage();
        weight = data.weight();
        swingSpeed = data.swingSpeed();
        endLagTicks = data.endLagTicks();

        // #TODO: ENCHANT LIST SYSTEM
        enchant = data.enchantment();
        specialRarity = data.specialRarity();
    }



}
