package live.soupsy.attribute;

import live.soupsy.Deepwoken;
import live.soupsy.mantra.Mantra;

import java.util.ArrayList;

public class Attribute {
    private String id;
    private ArrayList<String> talents; // TODO: Replace with Talents
    private ArrayList<Mantra> mantras;
    private String description;
    private String abbrev;

    public Attribute()
    {
        talents = new ArrayList<>();
        mantras = new ArrayList<>();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Mantra> getMantras() {
        return mantras;
    }

    public void addMantra(Mantra mantra)
    {
        if(containsMantra(mantra.getName()))
        {
            Deepwoken.LOGGER.warn("Tried to add mantra '"+mantra.getName()+"' to Attribute '"+this.id+"' but was already present");
            return;
        }
            mantras.add(mantra);
    }

    public void removeMantra(String mantraName)
    {
        mantras.removeIf(mantra -> mantra.getName().equals(mantraName));
    }

    public boolean containsMantra(Mantra mantra)
    {
        return containsMantra(mantra.getName());
    }

    public boolean containsMantra(String name)
    {
        for(Mantra mnta : mantras)
        {
            if(mnta.getName().equals(name))
                return true;
        }
        return false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public ArrayList<String> getTalents() {
        return talents;
    }


}
