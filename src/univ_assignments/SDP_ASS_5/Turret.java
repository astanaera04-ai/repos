package univ_assignments.SDP_ASS_5;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Turret {

    private final String name;
    private final double range;
    private TargetingStrategy strategy;

    public Turret(String name, double range, TargetingStrategy strategy) {
        this.name = name;
        this.range = range;
        this.strategy = Objects.requireNonNull(strategy, "strategy");
    }

    /** Switch the algorithm at runtime. */
    public void setStrategy(TargetingStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "strategy");
    }

    public Optional<Enemy> acquireTarget(List<Enemy> enemies) {
        return strategy.selectTarget(enemiesInRange(enemies));
    }

    private List<Enemy> enemiesInRange(List<Enemy> enemies) {
        return enemies.stream()
                .filter(enemy -> enemy.distanceToTurret() <= range)
                .toList();
    }

    public String getName() {
        return name;
    }
}
