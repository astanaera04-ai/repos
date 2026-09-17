package univ_assignments.SDP_ASS_1;

public final class AdvancedWorkoutPlan implements WorkoutPlan {

    private static final String INTENSITY_LABEL = "Advanced (high intensity)";
    private static final double CALORIES_PER_MINUTE_ESTIMATE = 9.5;

    private final String goal;
    private final String warmUp;
    private final String cardio;
    private final String strengthTraining;
    private final int durationInMinutes;

    public AdvancedWorkoutPlan(String goal, String warmUp, String cardio,
                               String strengthTraining, int durationInMinutes) {
        this.goal = goal;
        this.warmUp = warmUp;
        this.cardio = cardio;
        this.strengthTraining = strengthTraining;
        this.durationInMinutes = durationInMinutes;
    }

    @Override public String getGoal() { return goal; }
    @Override public String getWarmUp() { return warmUp; }
    @Override public String getCardio() { return cardio; }
    @Override public String getStrengthTraining() { return strengthTraining; }
    @Override public int getDurationInMinutes() { return durationInMinutes; }

    private double estimateCaloriesBurned() {
        return durationInMinutes * CALORIES_PER_MINUTE_ESTIMATE;
    }

    @Override
    public String printSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("=== ").append(INTENSITY_LABEL).append(" ===\n");
        summary.append("Goal: ").append(goal).append('\n');
        summary.append("Warm-up: ").append(warmUp).append('\n');
        summary.append("Cardio: ").append(cardio).append('\n');
        if (strengthTraining != null) {
            summary.append("Strength training: ").append(strengthTraining).append('\n');
        }
        summary.append("Duration: ").append(durationInMinutes).append(" minutes\n");
        summary.append(String.format("Estimated calories burned: %.0f kcal%n", estimateCaloriesBurned()));
        return summary.toString();
    }

    @Override
    public String toString() { return printSummary(); }
}