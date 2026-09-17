package univ_assignments.SDP_ASS_1;

public class Main {

    public static void main(String[] args) {
        demonstrateDirectorBuiltPlans();
        demonstrateCustomPlanWithoutDirector();
        demonstrateValidationFailure();
    }

    private static void demonstrateDirectorBuiltPlans() {
        System.out.println("---- Director: reusable plan templates ----\n");
        WorkoutDirector director = new WorkoutDirector();

        WorkoutPlan beginnerWeightLoss = director.buildWeightLossPlan(new BeginnerWorkoutPlanBuilder());
        WorkoutPlan advancedWeightLoss = director.buildWeightLossPlan(new AdvancedWorkoutPlanBuilder());

        System.out.println(beginnerWeightLoss.printSummary());
        System.out.println(advancedWeightLoss.printSummary());

        WorkoutPlan muscleGain = director.buildMuscleGainPlan(new AdvancedWorkoutPlanBuilder());
        System.out.println(muscleGain.printSummary());
    }

    private static void demonstrateCustomPlanWithoutDirector() {
        System.out.println("---- Client: fully custom plan (no Director) ----\n");
        WorkoutPlanBuilder builder = new BeginnerWorkoutPlanBuilder();
        WorkoutPlan customPlan = builder
                .setGoal("Flexibility")
                .addWarmUp("Light jogging 5 mins")
                .addCardio("Jump rope 10 mins")
                .setDuration(20)
                .build();

        System.out.println(customPlan.printSummary());
    }

    private static void demonstrateValidationFailure() {
        System.out.println("---- Client: invalid build is rejected ----\n");
        try {
            new AdvancedWorkoutPlanBuilder()
                    .setGoal("Endurance")
                    .setDuration(10)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Build correctly rejected: " + e.getMessage());
        }
    }
}