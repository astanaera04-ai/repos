package univ_assignments.ADS_ASS_4;

import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList;
    private boolean isDirected;

    public Graph(boolean isDirected) {
        this.adjList = new HashMap<>();
        this.isDirected = isDirected;
    }

    public void addVertex(int id) {
        adjList.putIfAbsent(id, new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(to);
        if (!isDirected) {
            adjList.get(to).add(from);
        }
    }

    public void printGraph() {
        System.out.println("Graph adjacency list:");
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    // BFS traversal
    public List<Integer> bfs(int start) {
        if (!adjList.containsKey(start)) {
            return new ArrayList<>();
        }

        List<Integer> traversalOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            traversalOrder.add(current);

            for (int neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return traversalOrder;
    }

    // DFS traversal (iterative using stack)
    public List<Integer> dfs(int start) {
        if (!adjList.containsKey(start)) {
            return new ArrayList<>();
        }

        List<Integer> traversalOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                traversalOrder.add(current);

                // Push neighbors in reverse order to simulate recursion order
                List<Integer> neighbors = adjList.get(current);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    if (!visited.contains(neighbors.get(i))) {
                        stack.push(neighbors.get(i));
                    }
                }
            }
        }
        return traversalOrder;
    }

    public int getVertexCount() {
        return adjList.size();
    }

    public boolean hasVertex(int id) {
        return adjList.containsKey(id);
    }
}