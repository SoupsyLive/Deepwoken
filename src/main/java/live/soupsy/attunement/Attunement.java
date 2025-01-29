package live.soupsy.attunement;

import net.minecraft.entity.Entity;

public interface Attunement {

    // Basics
    String getAttunementName();
    int getAttunementColor();
    boolean applyStatusEffect(Entity entity);

    String toString();

}