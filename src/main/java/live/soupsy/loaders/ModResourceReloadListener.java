package live.soupsy.loaders;

import live.soupsy.Deepwoken;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.io.InputStream;

public class ModResourceReloadListener implements SimpleSynchronousResourceReloadListener {
    @Override
    public Identifier getFabricId() {
        return Identifier.of(Deepwoken.MOD_ID, "my_resources");
    }

    @Override
    public void reload(ResourceManager manager) {
        for(Identifier id : manager.findResources("my_resource_folder", path -> path.getPath().endsWith(".json")).keySet()) {
            try(InputStream stream = manager.getResource(id).orElseThrow().getInputStream()) {
                
                // Do something
            } catch(Exception e) {
                Deepwoken.LOGGER.error("Error occurred while loading resource json " + id.toString(), e);
            }
        }
    }
}
