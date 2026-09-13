package univ_assignments.SDP_ASS_1;

public class WorkoutPlanBuilder {
    private String goal;
    private String cardio;

    public WorkoutPlanBuilder setGoal(String goal) {
        this.goal = goal;
        return this;
    }

    public WorkoutPlanBuilder addCardio(String cardio) {
        this.cardio = cardio;
        return this;
    }

    public WorkoutPlan build() {
        return new WorkoutPlan(goal, cardio);
    }
}
