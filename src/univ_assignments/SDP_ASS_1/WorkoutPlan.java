package univ_assignments.SDP_ASS_1;

public class WorkoutPlan {
    private String goal;
    private String cardio;

    protected WorkoutPlan(String goal, String cardio) {
        this.goal = goal;
        this.cardio = cardio;
    }

    @Override
    public String toString() {
        return "WorkoutPlan { Goal: " + goal + ", Cardio: " + cardio + " }";
    }
}