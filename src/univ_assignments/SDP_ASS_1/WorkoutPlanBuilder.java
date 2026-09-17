package univ_assignments.SDP_ASS_1;

public interface WorkoutPlanBuilder {
    WorkoutPlanBuilder setGoal(String goal);
    WorkoutPlanBuilder addWarmUp(String warmUp);
    WorkoutPlanBuilder addCardio(String cardio);
    WorkoutPlanBuilder addStrengthTraining(String strengthTraining);
    WorkoutPlanBuilder setDuration(int minutes);
    WorkoutPlan build();
}