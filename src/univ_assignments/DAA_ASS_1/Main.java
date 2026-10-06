package univ_assignments.DAA_ASS_1;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static final String BARCODE = "252156";
    public static void main(String[] args) {
        Checker.run(BARCODE, Main::findClosestPairBruteForce, Main::findClosestPairDivideAndConquer, Main::findFirstUnsafeN);
    }

    //  Part A: Brute Force
    /** Returns the two closest drones as new Drone[] {a, b}. */
    static Drone[] findClosestPairBruteForce(Drone[] drones) {
        Drone bestA = drones[0];
        Drone bestB = drones[1];
        long bestDist = Long.MAX_VALUE;

        for (int i = 0; i < drones.length; i++) {
            for (int j = i + 1; j < drones.length; j++) {
                long d = Drone.distSq(drones[i], drones[j]);
                if (d < bestDist) {
                    bestDist = d;
                    bestA = drones[i];
                    bestB = drones[j];
                }
            }
        }
        return new Drone[] {bestA, bestB};
    }

    //   Part B: Divide & Conquer

    /** Returns the two closest drones as new Drone[] {a, b}. */
    static Drone[] findClosestPairDivideAndConquer(Drone[] drones) {
        Drone[] copy = drones.clone();
        Arrays.sort(copy, Comparator.comparingInt(d -> d.x));
        return closest(copy, 0, copy.length);
    }

    /**
     * Closest pair among sorted[from] .. sorted[to - 1], where sorted is already sorted by x.
     * Everything below is squared: delta is a squared distance, so compare dx*dx and dy*dy with it.
     */
    private static Drone[] closest(Drone[] sorted, int from, int to) {
        int n = to - from;

        // BASE CASE: 3 drones or fewer - just check all pairs
        if (n <= 3) {
            Drone bestA = sorted[from];
            Drone bestB = sorted[from + 1];
            long bestDist = Long.MAX_VALUE;
            for (int i = from; i < to; i++) {
                for (int j = i + 1; j < to; j++) {
                    long d = Drone.distSq(sorted[i], sorted[j]);
                    if (d < bestDist) {
                        bestDist = d;
                        bestA = sorted[i];
                        bestB = sorted[j];
                    }
                }
            }
            return new Drone[] {bestA, bestB};
        }

        // DIVIDE: split in the middle BY INDEX; midX is the x of the middle drone
        int mid = from + n / 2;
        int midX = sorted[mid].x;

        // RECURSIVE CASE: solve the left half and the right half, keep the better pair.
        //                 delta = the smaller of the two squared distances.
        Drone[] left = closest(sorted, from, mid);
        Drone[] right = closest(sorted, mid, to);
        long leftDist = Drone.distSq(left[0], left[1]);
        long rightDist = Drone.distSq(right[0], right[1]);

        Drone[] best;
        long delta;
        if (leftDist <= rightDist) {
            best = left;
            delta = leftDist;
        } else {
            best = right;
            delta = rightDist;
        }

        // COMBINE: the closest pair may have one drone on each side.

        Drone[] strip = new Drone[n];
        int stripSize = 0;
        for (int i = from; i < to; i++) {
            long dx = sorted[i].x - midX;
            if (dx * dx < delta) {
                strip[stripSize++] = sorted[i];
            }
        }
        Arrays.sort(strip, 0, stripSize, Comparator.comparingInt(d -> d.y));

        for (int i = 0; i < stripSize; i++) {
            for (int j = i + 1; j < stripSize; j++) {
                long dy = strip[j].y - strip[i].y;
                if (dy * dy >= delta) {
                    break;
                }
                long d = Drone.distSq(strip[i], strip[j]);
                if (d < delta) {
                    delta = d;
                    best = new Drone[] {strip[i], strip[j]};
                }
            }
        }

        return best;
    }

    // Part C: Safety limit

    static int findFirstUnsafeN(Drone[] drones) {
        long safeDistSq = (long) Drone.SAFE_DISTANCE_CM * Drone.SAFE_DISTANCE_CM;
        int low = 2;
        int high = drones.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            Drone[] subset = Arrays.copyOfRange(drones, 0, mid);
            Drone[] pair = findClosestPairDivideAndConquer(subset);
            long d = Drone.distSq(pair[0], pair[1]);

            if (d < safeDistSq) {
                // unsafe - the answer is mid or smaller
                high = mid;
            } else {
                // still safe -the answer is bigger
                low = mid + 1;
            }
        }
        return low;
    }
}