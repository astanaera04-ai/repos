package univ_assignments.SDP_ASS_5;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ClosestToBaseStrategy implements TargetingStrategy {

    @Override
    public Optional<Enemy> selectTarget(List<Enemy> enemiesInRange) {
        return enemiesInRange.stream()
                .min(Comparator.comparingDouble(Enemy::distanceToBase));
    }
}