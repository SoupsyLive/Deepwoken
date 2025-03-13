package live.soupsy;

import live.soupsy.component.ModDataComponentTypes;
import live.soupsy.item.ModItemGroups;
import live.soupsy.item.ModItems;
import live.soupsy.loaders.DatapackLoader;
import live.soupsy.loaders.ModResourceReloadListener;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Deepwoken implements ModInitializer {
	public static final String MOD_ID = "deepwoken";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModDataComponentTypes.registerDataComponentTypes();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();

		DatapackLoader.register();

		ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new ModResourceReloadListener());

		LOGGER.info("The deep calls");
	}



}