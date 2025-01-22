package live.soupsy.attunements;

import net.minecraft.entity.Entity;


import java.awt.*;

public interface Attunement {

    // Basics
    String getAttunementName();
    String abbrev();
    int getAttunementColor();

    boolean applyStatusEffect(Entity entity);

    String toString();

}