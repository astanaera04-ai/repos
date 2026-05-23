package univ_assignments.ADS_BONUS;

import java.util.ArrayList;
import java.util.List;

// 1. Edge класы (салмақ - weight қосылған)
class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Graph {
    private int V; // Төбелер саны
    private List<List<Edge>> adj; // Көршілік тізімі (Adjacency list)

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Графқа жаңа жол қосу
    public void addEdge(int from, int to, int weight) {
        adj.get(from).add(new Edge(to, weight));
        adj.get(to).add(new Edge(from, weight)); // Бағытталмаған граф үшін
    }

    // 2. Dijkstra алгоритмі
    public void dijkstra(int start) {
        int[] distances = new int[V];
        boolean[] visited = new boolean[V];

        // Барлық қашықтықтарды "шексіздік" етіп толтыру
        for (int i = 0; i < V; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        distances[start] = 0; // Бастапқы нүктенің өзіне дейінгі қашықтығы 0

        // Негізгі цикл
        for (int i = 0; i < V - 1; i++) {
            int min_dist = Integer.MAX_VALUE;
            int u = -1;

            // Әлі қаралмаған, қашықтығы ең аз төбені табу
            for (int j = 0; j < V; j++) {
                if (!visited[j] && distances[j] <= min_dist) {
                    min_dist = distances[j];
                    u = j;
                }
            }

            // Егер қалған төбелерге жол жоқ болса (немесе бөлек граф болса), тоқтату
            if (u == -1) break;

            visited[u] = true; // Төбені "қаралды" деп белгілейміз

            // Табылған төбенің көршілерінің қашықтығын жаңарту
            for (Edge edge : adj.get(u)) {
                int v = edge.to;
                int weight = edge.weight;

                // Егер жаңа жол бұрынғыдан қысқа болса, қашықтықты жаңартамыз
                if (!visited[v] && distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                }
            }
        }

        System.out.println("Бастапқы нүктеден (" + start + ") басқа нүктелерге дейінгі ең қысқа қашықтықтар:");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " нүктесіне дейін: ");
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("Жол жоқ");
            } else {
                System.out.println(distances[i]);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5); // 5 төбесі бар граф

        // Жолдарды қосу (қайдан, қайда, салмағы)
        g.addEdge(0, 1, 10);
        g.addEdge(0, 4, 5);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 4, 2);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 4, 2);

        // 0-ші нүктеден бастап барлық қысқа жолдарды табу
        g.dijkstra(0);
    }
}