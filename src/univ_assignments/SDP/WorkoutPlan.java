package univ_assignments.SDP;

public class WorkoutPlan {
    private String goal;
    private String warmUp;
    private String cardio;
    private String strengthTraining;
    private String cooldown;
    private int durationInMinutes;

    // Конструктор тек Builder арқылы шақырылады
    protected WorkoutPlan(String goal, String warmUp, String cardio,
                          String strengthTraining, String cooldown, int durationInMinutes) {
        this.goal = goal;
        this.warmUp = warmUp;
        this.cardio = cardio;
        this.strengthTraining = strengthTraining;
        this.cooldown = cooldown;
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String toString() {
        return "WorkoutPlan {" +
                "\n  Goal: '" + goal + '\'' +
                ",\n  Warm Up: '" + warmUp + '\'' +
                ",\n  Cardio: '" + cardio + '\'' +
                ",\n  Strength Training: '" + strengthTraining + '\'' +
                ",\n  Cooldown: '" + cooldown + '\'' +
                ",\n  Duration: " + durationInMinutes + " minutes" +
                "\n}";
    }
}
