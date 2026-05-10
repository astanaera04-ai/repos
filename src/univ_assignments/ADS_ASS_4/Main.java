package univ_assignments.ADS_ASS_4;

public class Main {
    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("CS Assignment 4: Graph Traversal (BFS & DFS)");
        System.out.println("================================================\n");

        // Part 1: Demonstrate BFS and DFS on a small custom graph
        System.out.println("PART 1: DEMONSTRATION ON SMALL CUSTOM GRAPH");
        System.out.println("-------------------------------------------");

        Graph smallDemoGraph = new Graph(false); // undirected
        for (int i = 0; i < 6; i++) {
            smallDemoGraph.addVertex(i);
        }
        smallDemoGraph.addEdge(0, 1);
        smallDemoGraph.addEdge(0, 2);
        smallDemoGraph.addEdge(1, 3);
        smallDemoGraph.addEdge(1, 4);
        smallDemoGraph.addEdge(2, 5);

        smallDemoGraph.printGraph();

        System.out.println("\nStarting BFS from vertex 0:");
        System.out.println("Order: " + smallDemoGraph.bfs(0));

        System.out.println("\nStarting DFS from vertex 0:");
        System.out.println("Order: " + smallDemoGraph.dfs(0));

        // Part 2: Run experiments on different graph sizes
        System.out.println("\n\n\n");
        Experiment.runMultipleTests();

        // Part 3: Final summary message
        System.out.println("\n" + "=".repeat(80));
        System.out.println(" All tests completed successfully!");
        System.out.println("=".repeat(80));
        System.out.println("\n Check README.md for:");
        System.out.println("   - Analysis of results");
        System.out.println("   - Time complexity discussion (O(V+E))");
        System.out.println("   - When to use BFS vs DFS");
        System.out.println("   - Reflection on implementation\n");
    }
}
