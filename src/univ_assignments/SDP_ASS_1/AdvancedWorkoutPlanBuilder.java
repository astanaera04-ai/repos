package univ_assignments.SDP_ASS_1;

public class AdvancedWorkoutPlanBuilder extends AbstractWorkoutPlanBuilder {
    @Override
    public WorkoutPlan build() {
        validateState();
        return new AdvancedWorkoutPlan(goal, warmUp, cardio, strengthTraining, durationInMinutes);
    }
}