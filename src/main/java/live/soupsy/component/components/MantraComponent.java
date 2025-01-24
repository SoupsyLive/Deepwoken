package live.soupsy.component.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record MantraComponent(String name, String reqKeysString, String reqValuesString,
                              String attunementId, int rating, int level, float attunementScaling,
                              float damage, int etherCost, String modifiersString,
                              int tickCooldown, float levelDamageScale, float etherCostMultiplier) {


    public static final Codec<MantraComponent> CODEC = RecordCodecBuilder.create(builder ->{
        return builder.group(
                Codec.STRING.optionalFieldOf("name", "Blank Mantra").forGetter(MantraComponent::name),
                Codec.STRING.optionalFieldOf("reqKeysString", "flamecharm").forGetter(MantraComponent::reqKeysString),
                Codec.STRING.optionalFieldOf("reqValuesString","10").forGetter(MantraComponent::reqValuesString),
                Codec.STRING.optionalFieldOf("attunementId","test_mantra").forGetter(MantraComponent::attunementId),
                Codec.INT.optionalFieldOf("rating",0).forGetter(MantraComponent::rating),
                Codec.INT.optionalFieldOf("level",1).forGetter(MantraComponent::level),
                Codec.FLOAT.optionalFieldOf("attunementScaling",1.05f).forGetter(MantraComponent::attunementScaling),
                Codec.FLOAT.optionalFieldOf("damage",1.0f).forGetter(MantraComponent::damage),
                Codec.INT.optionalFieldOf("etherCost",10).forGetter(MantraComponent::etherCost),
                Codec.STRING.optionalFieldOf("modifiersString","").forGetter(MantraComponent::modifiersString),
                Codec.INT.optionalFieldOf("tickCooldown",20*10).forGetter(MantraComponent::tickCooldown),
                Codec.FLOAT.optionalFieldOf("levelDamageScale",1.1f).forGetter(MantraComponent::levelDamageScale),
                Codec.FLOAT.optionalFieldOf("etherCostMultiplier",1.0f).forGetter(MantraComponent::etherCostMultiplier)
        ).apply(builder, MantraComponent::new);
    });
}
