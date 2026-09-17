package univ_assignments.SDP_ASS_1;

public class BeginnerWorkoutPlanBuilder extends AbstractWorkoutPlanBuilder {
    @Override
    public WorkoutPlan build() {
        validateState();
        return new BeginnerWorkoutPlan(goal, warmUp, cardio, strengthTraining, durationInMinutes);
    }
}