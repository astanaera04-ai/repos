package univ_assignments.SDP_ASS_5;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

 public class Main {

    public static void main(String[] args) {
        List<Enemy> battlefield = List.of(
                new Enemy("Goblin", 30, 8, 40),
                new Enemy("Orc", 120, 12, 25),
                new Enemy("Wraith", 60, 5, 60),
                new Enemy("Troll", 200, 18, 10)   // out of range (> 15)
        );

        // Client picks strategies by command name: a Map, not an if/switch chain.
        Map<String, TargetingStrategy> commands = Map.of(
                "nearest", new NearestEnemyStrategy(),
                "weakest", new WeakestEnemyStrategy(),
                "strongest", new StrongestEnemyStrategy(),
                "closest-to-base", new ClosestToBaseStrategy()
        );

        Turret turret = new Turret("Arrow Tower", 15, commands.get("nearest"));
        System.out.println("Battlefield: " + battlefield);
        System.out.println("Turret range: 15 (Troll is out of range)\n");

        for (String command : List.of("nearest", "weakest", "strongest", "closest-to-base")) {
            turret.setStrategy(commands.get(command));          // runtime switch
            report(turret, command, battlefield);
        }

        // Extensibility: a brand-new strategy, no existing class touched.
        turret.setStrategy(enemies -> enemies.stream()
                .max(Comparator.comparingDouble(Enemy::distanceToBase)));
        report(turret, "farthest-from-base (lambda)", battlefield);

        // Edge case: nobody in range.
        turret.setStrategy(commands.get("nearest"));
        report(turret, "nearest, empty field", List.of());
    }

    private static void report(Turret turret, String label, List<Enemy> enemies) {
        Optional<Enemy> target = turret.acquireTarget(enemies);
        System.out.printf("%-30s -> %s%n", label,
                target.map(Enemy::toString).orElse("no target in range"));
    }
}

