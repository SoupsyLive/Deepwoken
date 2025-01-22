package live.soupsy.component;

import live.soupsy.Deepwoken;
import live.soupsy.component.components.MantraComponent;
import live.soupsy.mantas.Mantra;
import net.minecraft.component.ComponentType;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<MantraComponent> MANTRA =
            register("mantra", builder -> builder.codec(MantraComponent.CODEC));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Deepwoken.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        Deepwoken.LOGGER.info("Registering Deepwoken data components");
    }
}
