package univ_assignments.SDP_ASS_5;

import java.util.List;
import java.util.Optional;


@FunctionalInterface
public interface TargetingStrategy {

    /** @return the chosen target, or empty if there is nobody to shoot at */
    Optional<Enemy> selectTarget(List<Enemy> enemiesInRange);
}

