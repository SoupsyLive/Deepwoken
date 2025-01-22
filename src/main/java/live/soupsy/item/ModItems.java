package live.soupsy.item;

import live.soupsy.Deepwoken;
import live.soupsy.component.ModDataComponentTypes;
import live.soupsy.component.components.MantraComponent;
import live.soupsy.item.custom.MantraItem;
import live.soupsy.mantas.Mantra;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item MANTRA = registerItem("mantra", new MantraItem(
            new Item.Settings()
                    .component(ModDataComponentTypes.MANTRA, new MantraComponent(
                            "Blank Mantra", "flamecharm","10", "test_mantra",
                            1, 1,1.05f, 1.0f,
                            10, "",20*10, 1.1f,
                            1.0f
                    ))
            ));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Deepwoken.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Deepwoken.LOGGER.info("Registering Deepwoken's items");

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
//            entries.add(MANTRA);
//        });
    }
}
