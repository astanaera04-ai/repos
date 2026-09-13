package univ_assignments.SDP_ASS_1;

public class WorkoutPlanBuilder {
    private String goal;
    private String warmUp;
    private String cardio;
    private String strengthTraining;
    private int durationInMinutes;

    private static final int MINIMUM_WORKOUT_DURATION = 15;

    public WorkoutPlanBuilder setGoal(String goal) {
        this.goal = goal;
        return this;
    }

    public WorkoutPlanBuilder addWarmUp(String warmUp) {
        this.warmUp = warmUp;
        return this;
    }

    public WorkoutPlanBuilder addCardio(String cardio) {
        this.cardio = cardio;
        return this;
    }

    public WorkoutPlanBuilder addStrengthTraining(String strengthTraining) {
        this.strengthTraining = strengthTraining;
        return this;
    }

    public WorkoutPlanBuilder setDuration(int minutes) {
        this.durationInMinutes = minutes;
        return this;
    }

    public WorkoutPlan build() {
        if (goal == null || goal.trim().isEmpty()) {
            throw new IllegalStateException("Goal cannot be empty!");
        }
        if (durationInMinutes < MINIMUM_WORKOUT_DURATION) {
            throw new IllegalStateException("Duration must be at least " + MINIMUM_WORKOUT_DURATION + " minutes.");
        }
        return new WorkoutPlan(goal, warmUp, cardio, strengthTraining, durationInMinutes);
    }
}