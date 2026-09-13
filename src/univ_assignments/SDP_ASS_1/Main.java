package univ_assignments.SDP_ASS_1;

public class Main {
    public static void main(String[] args) {
        WorkoutDirector director = new WorkoutDirector();
        WorkoutPlanBuilder builder = new WorkoutPlanBuilder();

        director.buildWeightLossPlan(builder);
        WorkoutPlan plan = builder.build();

        System.out.println(plan);
    }
}
