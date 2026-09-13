package univ_assignments.SDP_ASS_1;


public class WorkoutPlan {
    private String goal;
    private String warmUp;
    private String cardio;
    private String strengthTraining;
    private int durationInMinutes;

    protected WorkoutPlan(String goal, String warmUp, String cardio, String strengthTraining, int durationInMinutes) {
        this.goal = goal;
        this.warmUp = warmUp;
        this.cardio = cardio;
        this.strengthTraining = strengthTraining;
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String toString() {
        return "WorkoutPlan {" +
                "goal='" + goal + '\'' +
                ", warmUp='" + warmUp + '\'' +
                ", cardio='" + cardio + '\'' +
                ", strengthTraining='" + strengthTraining + '\'' +
                ", durationInMinutes=" + durationInMinutes +
                '}';
    }
}