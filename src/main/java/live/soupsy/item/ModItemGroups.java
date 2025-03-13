package live.soupsy.item;

import live.soupsy.Deepwoken;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {



    public static final ItemGroup DEEPWOKEN_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Deepwoken.MOD_ID, "deepwoken_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.MANTRA))
                    .displayName(Text.translatable("itemgroup.deepwoken.deepwoken_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.MANTRA);
                        entries.add(ModItems.WEAPON);

                    })
                    .build());

    public static final ItemGroup MANTRAS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Deepwoken.MOD_ID, "deepwoken_mantras"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.MANTRA))
                    .displayName(Text.translatable("itemgroup.deepwoken.deepwoken_mantras"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.MANTRA);
                    })
                    .build());

    public static final ItemGroup WEAPONS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Deepwoken.MOD_ID, "deepwoken_weapons"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.WEAPON))
                    .displayName(Text.translatable("itemgroup.deepwoken.deepwoken_weapons"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.WEAPON);
                    })
                    .build());




    public static void registerItemGroups(){
        Deepwoken.LOGGER.info("Registering Deepwoken's item groups");
    }
}
