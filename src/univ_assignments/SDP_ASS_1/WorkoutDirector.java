package univ_assignments.SDP_ASS_1;

public class WorkoutDirector {

    private static final int WEIGHT_LOSS_DURATION_MINUTES = 45;
    private static final int MUSCLE_GAIN_DURATION_MINUTES = 60;

    public WorkoutPlan buildWeightLossPlan(WorkoutPlanBuilder builder) {
        return builder
                .setGoal("Weight Loss")
                .addWarmUp("Jumping jacks")
                .addCardio("Running 30 mins")
                .setDuration(WEIGHT_LOSS_DURATION_MINUTES)
                .build();
    }

    public WorkoutPlan buildMuscleGainPlan(WorkoutPlanBuilder builder) {
        return builder
                .setGoal("Muscle Gain")
                .addWarmUp("Dynamic stretching")
                .addCardio("Brisk walking 10 mins")
                .addStrengthTraining("Squats, bench press, deadlifts (4x8)")
                .setDuration(MUSCLE_GAIN_DURATION_MINUTES)
                .build();
    }
}