package live.soupsy.loaders;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import static live.soupsy.Deepwoken.LOGGER;
import static live.soupsy.Deepwoken.MOD_ID;

public class DatapackLoader {
    private static final Gson GSON = new Gson();

    public static void register() {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new SimpleSynchronousResourceReloadListener() {
            @Override
            public Identifier getFabricId() {
                return Identifier.of(MOD_ID, "deepwoken");
            }

            @Override
            public void reload(ResourceManager manager) {
                checkTalents(manager);
                checkMantras(manager);
                checkWeapons(manager);
            }
        });
    }

    private static void checkWeapons(ResourceManager manager)
    {
        manager.findResources("deepwoken_weapon", path -> path.getPath().endsWith(".json")).forEach((id, resource) -> {
            try (InputStream stream = resource.getInputStream()) {
                InputStreamReader reader = new InputStreamReader(stream);
                //GSON.fromJson(reader, )
                //BeaconConfig config = GSON.fromJson(reader, BeaconConfig.class);
                //beaconData.put(id, new BeaconData(config));
            } catch (Exception e) {
                LOGGER.warn("Failed to load beacon data from %s!".formatted(id), e);
            }
        });
    }

    private static void checkMantras(ResourceManager manager)
    {
        manager.findResources("deepwoken_mantra", path -> path.getPath().endsWith(".json")).forEach((id, resource) -> {
            try (InputStream stream = resource.getInputStream()) {
                InputStreamReader reader = new InputStreamReader(stream);

                //BeaconConfig config = GSON.fromJson(reader, BeaconConfig.class);
                //beaconData.put(id, new BeaconData(config));
            } catch (Exception e) {
                LOGGER.warn("Failed to load beacon data from %s!".formatted(id), e);
            }
        });
    }

    private static void checkTalents(ResourceManager manager)
    {
        manager.findResources("deepwoken_talents", path -> path.getPath().endsWith(".json")).forEach((id, resource) -> {
            try (InputStream stream = resource.getInputStream()) {
                InputStreamReader reader = new InputStreamReader(stream);

                //BeaconConfig config = GSON.fromJson(reader, BeaconConfig.class);
                //beaconData.put(id, new BeaconData(config));
            } catch (Exception e) {
                LOGGER.warn("Failed to load beacon data from %s!".formatted(id), e);
            }
        });
    }





//    @Nullable
//    public static List<BeaconData> findMatchingData(Block block) {
//        List<BeaconData> matching = new LinkedList<>();
//        for (BeaconData data : beaconData.values()) {
//            for (BlockOrTag blockOrTag : data.getBases()) {
//                if (blockOrTag.has(block)) {
//                    matching.add(data);
//                }
//            }
//        }
//        return matching.isEmpty() ? null : matching;
//    }
}
