package live.soupsy;

import live.soupsy.component.ModDataComponentTypes;
import live.soupsy.item.ModItemGroups;
import live.soupsy.item.ModItems;
import net.fabricmc.api.ModInitializer;

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

		LOGGER.info("The deep calls");
	}
}