package univ_assignments.SDP;

public class WorkoutDirector {

    public void buildWeightLossPlan(WorkoutPlanBuilder builder) {
        builder.setGoal("Weight Loss")
                .addWarmUp("10 minutes jumping jacks")
                .addCardio("40 minutes running on treadmill")
                .addStrengthTraining("Light dumbbell exercises (3 sets of 15)")
                .addCooldown("10 minutes full body stretch")
                .setDuration(60);
    }

    public void buildMuscleGainPlan(WorkoutPlanBuilder builder) {
        builder.setGoal("Muscle Gain")
                .addWarmUp("5 minutes mobility work")
                .addCardio("No cardio, save energy for lifting")
                .addStrengthTraining("Heavy deadlifts, squats, bench press (5 sets of 5)")
                .addCooldown("5 minutes static stretching")
                .setDuration(90);
    }
}
