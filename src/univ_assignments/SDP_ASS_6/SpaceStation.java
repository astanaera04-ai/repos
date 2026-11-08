package univ_assignments.SDP_ASS_6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Object structure: a collection of modules.
 * It traverses the elements and calls accept() on each one.
 * The client never loops over elements by hand.
 */
public class SpaceStation {

    private final String name;
    private final List<StationModule> modules = new ArrayList<>();

    public SpaceStation(String name) {
        this.name = name;
    }

    public SpaceStation addModule(StationModule module) {
        modules.add(module);
        return this;
    }

    public String getName() {
        return name;
    }

    public List<StationModule> getModules() {
        return Collections.unmodifiableList(modules);
    }

    public void accept(StationVisitor visitor) {
        for (StationModule module : modules) {
            module.accept(visitor);
        }
    }
}
