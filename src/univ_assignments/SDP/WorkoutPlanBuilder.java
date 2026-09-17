package univ_assignments.SDP;

public class WorkoutPlanBuilder {
    private String goal;
    private String warmUp;
    private String cardio;
    private String strengthTraining;
    private String cooldown;
    private int durationInMinutes;

    // Clean Code: No magic numbers. Тұрақты (constant) мәндер қолданылды
    private static final int MINIMUM_WORKOUT_DURATION = 15;
    private static final String DEFAULT_WARM_UP = "5 minutes light stretching";

    public WorkoutPlanBuilder setGoal(String goal) {
        this.goal = goal;
        return this; // Method chaining үшін builder-дің өзін қайтарады
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

    public WorkoutPlanBuilder addCooldown(String cooldown) {
        this.cooldown = cooldown;
        return this;
    }

    public WorkoutPlanBuilder setDuration(int minutes) {
        this.durationInMinutes = minutes;
        return this;
    }

    // Объектіні құрастыруды аяқтайтын және тексеріс жасайтын әдіс
    public WorkoutPlan build() {
        // Clean Code: Validated construction
        if (goal == null || goal.trim().isEmpty()) {
            throw new IllegalStateException("Workout goal cannot be empty!");
        }
        if (durationInMinutes < MINIMUM_WORKOUT_DURATION) {
            throw new IllegalStateException("Workout duration must be at least " + MINIMUM_WORKOUT_DURATION + " minutes.");
        }

        // Егер қызу (warmUp) көрсетілмесе, базалық мәнді қою
        if (warmUp == null) {
            this.warmUp = DEFAULT_WARM_UP;
        }

        return new WorkoutPlan(goal, warmUp, cardio, strengthTraining, cooldown, durationInMinutes);
    }
}