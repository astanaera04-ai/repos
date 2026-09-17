package univ_assignments.SDP_ASS_1;

public abstract class AbstractWorkoutPlanBuilder implements WorkoutPlanBuilder {

    protected static final int MINIMUM_WORKOUT_DURATION_MINUTES = 15;

    protected String goal;
    protected String warmUp;
    protected String cardio;
    protected String strengthTraining;
    protected int durationInMinutes;

    @Override
    public WorkoutPlanBuilder setGoal(String goal) {
        this.goal = goal;
        return this;
    }

    @Override
    public WorkoutPlanBuilder addWarmUp(String warmUp) {
        this.warmUp = warmUp;
        return this;
    }

    @Override
    public WorkoutPlanBuilder addCardio(String cardio) {
        this.cardio = cardio;
        return this;
    }

    @Override
    public WorkoutPlanBuilder addStrengthTraining(String strengthTraining) {
        this.strengthTraining = strengthTraining;
        return this;
    }

    @Override
    public WorkoutPlanBuilder setDuration(int minutes) {
        this.durationInMinutes = minutes;
        return this;
    }

    protected void validateState() {
        if (goal == null || goal.isBlank()) {
            throw new IllegalStateException("Cannot build workout plan: goal is required");
        }
        if (warmUp == null || warmUp.isBlank()) {
            throw new IllegalStateException("Cannot build workout plan: warm-up is required");
        }
        if (cardio == null || cardio.isBlank()) {
            throw new IllegalStateException("Cannot build workout plan: cardio is required");
        }
        if (durationInMinutes < MINIMUM_WORKOUT_DURATION_MINUTES) {
            throw new IllegalStateException(
                    "Cannot build workout plan: duration must be at least "
                            + MINIMUM_WORKOUT_DURATION_MINUTES + " minutes");
        }
    }
}