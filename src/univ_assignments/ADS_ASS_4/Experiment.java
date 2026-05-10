package univ_assignments.ADS_ASS_4;

import java.util.*;

public class Experiment {

    // Generate a connected graph with given number of vertices
    // Each vertex is connected to about 2-5 random neighbors
    public static Graph generateConnectedGraph(int numVertices, boolean isDirected) {
        Graph graph = new Graph(isDirected);

        // Add all vertices
        for (int i = 0; i < numVertices; i++) {
            graph.addVertex(i);
        }

        Random rand = new Random(42); // fixed seed for reproducibility

        // Ensure graph is connected: create a simple path first
        for (int i = 0; i < numVertices - 1; i++) {
            graph.addEdge(i, i + 1);
        }

        // Add extra random edges (about log(numVertices) per vertex)
        int extraEdges = Math.max(numVertices, numVertices * 2);
        for (int i = 0; i < extraEdges; i++) {
            int from = rand.nextInt(numVertices);
            int to = rand.nextInt(numVertices);
            if (from != to) {
                graph.addEdge(from, to);
            }
        }

        return graph;
    }

    // Run single traversal and measure time
    public static long measureTimeBFS(Graph graph, int start) {
        long startTime = System.nanoTime();
        graph.bfs(start);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long measureTimeDFS(Graph graph, int start) {
        long startTime = System.nanoTime();
        graph.dfs(start);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Run multiple tests and return average times
    public static void runMultipleTests() {
        int[] sizes = {10, 30, 100};
        boolean isDirected = false; // undirected graph

        System.out.println("\n" + "=".repeat(80));
        System.out.println("EXPERIMENT: Performance Analysis of BFS vs DFS");
        System.out.println("=".repeat(80));

        // Store results for summary table
        double[][] bfsAvgTimes = new double[sizes.length][3]; // [size][runs] -> we'll avg later
        double[][] dfsAvgTimes = new double[sizes.length][3];

        for (int idx = 0; idx < sizes.length; idx++) {
            int size = sizes[idx];
            System.out.println("\n--- Testing graph with " + size + " vertices ---");

            Graph graph = generateConnectedGraph(size, isDirected);
            graph.printGraph();

            int startVertex = 0;

            // Display traversal order for small graph (10 vertices)
            if (size == 10) {
                System.out.println("\nBFS Traversal Order (starting from V" + startVertex + "):");
                List<Integer> bfsOrder = graph.bfs(startVertex);
                System.out.println("  " + bfsOrder);

                System.out.println("\nDFS Traversal Order (starting from V" + startVertex + "):");
                List<Integer> dfsOrder = graph.dfs(startVertex);
                System.out.println("  " + dfsOrder);
            }

            // Run 3 trials for accuracy
            int trials = 3;
            long[] bfsTimes = new long[trials];
            long[] dfsTimes = new long[trials];

            for (int t = 0; t < trials; t++) {
                bfsTimes[t] = measureTimeBFS(graph, startVertex);
                dfsTimes[t] = measureTimeDFS(graph, startVertex);
            }

            // Calculate averages
            long bfsSum = 0, dfsSum = 0;
            for (int t = 0; t < trials; t++) {
                bfsSum += bfsTimes[t];
                dfsSum += dfsTimes[t];
            }
            double bfsAvg = bfsSum / (double) trials;
            double dfsAvg = dfsSum / (double) trials;

            bfsAvgTimes[idx][0] = bfsAvg;
            dfsAvgTimes[idx][0] = dfsAvg;

            System.out.printf("  BFS avg time: %.2f ns (trials: %d, %d, %d ns)%n",
                    bfsAvg, bfsTimes[0], bfsTimes[1], bfsTimes[2]);
            System.out.printf("  DFS avg time: %.2f ns (trials: %d, %d, %d ns)%n",
                    dfsAvg, dfsTimes[0], dfsTimes[1], dfsTimes[2]);
        }

        // Print final comparison table
        printResults(sizes, bfsAvgTimes, dfsAvgTimes);
    }

    public static void printResults(int[] sizes, double[][] bfsAvgs, double[][] dfsAvgs) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SUMMARY: Execution Time Comparison");
        System.out.println("=".repeat(80));
        System.out.printf("%-15s %-25s %-25s %-15s%n", "Graph Size", "BFS Avg Time (ns)", "DFS Avg Time (ns)", "Faster");
        System.out.println("-".repeat(80));

        for (int i = 0; i < sizes.length; i++) {
            String faster;
            if (bfsAvgs[i][0] < dfsAvgs[i][0]) {
                faster = "BFS";
            } else if (dfsAvgs[i][0] < bfsAvgs[i][0]) {
                faster = "DFS";
            } else {
                faster = "Similar";
            }
            System.out.printf("%-15d %-25.2f %-25.2f %-15s%n",
                    sizes[i], bfsAvgs[i][0], dfsAvgs[i][0], faster);
        }
        System.out.println("\nNote: Times are in nanoseconds. Results vary based on graph structure & hardware.");
    }

    public static void runTraversals(Graph g) {
        if (g.getVertexCount() == 0) {
            System.out.println("Graph is empty.");
            return;
        }
        int start = 0;
        if (!g.hasVertex(start)) {
            start = g.getVertexCount() > 0 ? 0 : -1;
        }
        if (start != -1) {
            System.out.println("BFS Order: " + g.bfs(start));
            System.out.println("DFS Order: " + g.dfs(start));
        }
    }
}