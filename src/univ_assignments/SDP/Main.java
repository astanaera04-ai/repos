package univ_assignments.SDP;

public class Main {
    public static void main(String[] args) {
        WorkoutDirector director = new WorkoutDirector();

        // 1. Директор арқылы "Арықтау" жоспарын құру
        WorkoutPlanBuilder weightLossBuilder = new WorkoutPlanBuilder();
        director.buildWeightLossPlan(weightLossBuilder);
        WorkoutPlan weightLossPlan = weightLossBuilder.build();

        System.out.println("--- Standard Weight Loss Plan ---");
        System.out.println(weightLossPlan);

        // 2. Директор арқылы "Бұлшықет өсіру" жоспарын құру
        WorkoutPlanBuilder muscleGainBuilder = new WorkoutPlanBuilder();
        director.buildMuscleGainPlan(muscleGainBuilder);
        WorkoutPlan muscleGainPlan = muscleGainBuilder.build();

        System.out.println("\n--- Standard Muscle Gain Plan ---");
        System.out.println(muscleGainPlan);

        // 3. Client өзі кастомды (жеке) жоспар құрастыруы (Method Chaining арқылы)
        try {
            WorkoutPlan customPlan = new WorkoutPlanBuilder()
                    .setGoal("General Fitness")
                    .addCardio("15 minutes cycling")
                    .setDuration(30)
                    // cooldown және strengthTraining қоспадық
                    .build();

            System.out.println("\n--- Custom Short Workout Plan ---");
            System.out.println(customPlan);

            // 4. Валидацияны тексеру (Exception лақтыру)
            System.out.println("\n--- Testing Validation (Exception Expected) ---");
            WorkoutPlan invalidPlan = new WorkoutPlanBuilder()
                    .setGoal("Too Short")
                    .setDuration(10) // 15-тен аз болғандықтан қате беруі керек
                    .build();

        } catch (IllegalStateException e) {
            System.out.println("Error caught: " + e.getMessage());
        }
    }
}