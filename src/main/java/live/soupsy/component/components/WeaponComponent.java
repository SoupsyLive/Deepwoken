package live.soupsy.component.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.stream.IntStream;

public record WeaponComponent(String name, String weaponId, String weaponType, String reqKeysString, String reqValuesString,
                              String scalingKeysString, String scalingValuesString, int rating,
                              int baseDamage, int basePen, float chipDamage, int weight, float swingSpeed,
                              float endLagTicks, String enchantment, String specialRarity) {


    public static final Codec<WeaponComponent> CODEC = RecordCodecBuilder.create(builder ->{
        return builder.group(
                Codec.STRING.optionalFieldOf("name", "Blank Weapon").forGetter(WeaponComponent::name),
                Codec.STRING.optionalFieldOf("weaponId", "blank_weapon").forGetter(WeaponComponent::weaponId),
                Codec.STRING.optionalFieldOf("weaponType", "medium").forGetter(WeaponComponent::weaponType),
                Codec.STRING.optionalFieldOf("reqKeysString", "strength").forGetter(WeaponComponent::reqKeysString),
                Codec.STRING.optionalFieldOf("reqValuesString", "1").forGetter(WeaponComponent::reqValuesString),
                Codec.STRING.optionalFieldOf("scalingKeysString", "strength").forGetter(WeaponComponent::scalingKeysString),
                Codec.STRING.optionalFieldOf("scalingValuesString", "1.1f").forGetter(WeaponComponent::scalingValuesString),
                Codec.INT.optionalFieldOf("rating", 0).forGetter(WeaponComponent::rating),
                Codec.INT.optionalFieldOf("baseDamage", 10).forGetter(WeaponComponent::baseDamage),
                Codec.INT.optionalFieldOf("basePen", 0).forGetter(WeaponComponent::basePen),
                Codec.FLOAT.optionalFieldOf("chipDamage", 0.0f).forGetter(WeaponComponent::chipDamage),
                Codec.INT.optionalFieldOf("weight", 5).forGetter(WeaponComponent::weight),
                Codec.FLOAT.optionalFieldOf("swingSpeed", 5.0f).forGetter(WeaponComponent::swingSpeed),
                Codec.FLOAT.optionalFieldOf("endLagTicks", 5.0f).forGetter(WeaponComponent::endLagTicks),
                Codec.STRING.optionalFieldOf("enchantment", "none").forGetter(WeaponComponent::enchantment),
                Codec.STRING.optionalFieldOf("specialRarity", "none").forGetter(WeaponComponent::specialRarity)
        ).apply(builder, WeaponComponent::new);
    });
}
