package univ_assignments.SDP_ASS_1;

public class WorkoutDirector {
    public void buildWeightLossPlan(WorkoutPlanBuilder builder) {
        builder.setGoal("Weight Loss")
                .addWarmUp("Jumping jacks")
                .addCardio("Running 30 mins")
                .setDuration(45);
    }
}