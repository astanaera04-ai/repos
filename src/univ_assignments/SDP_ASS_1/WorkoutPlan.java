package univ_assignments.SDP_ASS_1;

public interface WorkoutPlan {
    String getGoal();
    String getWarmUp();
    String getCardio();
    String getStrengthTraining();
    int getDurationInMinutes();
    String printSummary();
}