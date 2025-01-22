package live.soupsy.attunements;

import net.minecraft.entity.Entity;

public class Flamecharm implements Attunement{
    private final String name = "Flamecharm";
    private final int color = 0xFFFFFFFF;

    @Override
    public String getAttunementName() {
        return this.name;
    }

    @Override
    public String abbrev() {
        return "Flm";
    }

    @Override
    public int getAttunementColor() {
        return color;
    }

    @Override
    public boolean applyStatusEffect(Entity entity) {
        return false;
    }

    public String toString(){
        return name.toLowerCase();
    }
}
