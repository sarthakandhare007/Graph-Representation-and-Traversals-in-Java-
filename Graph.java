import java.util.*;

class Graph {
    int vertices;
    LinkedList<Integer>[] adjList;

    // Constructor
    public Graph(int v) {
        this.vertices = v;
        adjList = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add edge (undirected)
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src); // Comment this line for directed graph
    }

    // BFS traversal from a given start node
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");
        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            
            for(int neighbor : adjList[node]) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // DFS traversal from a given start node
    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Traversal: ");
        dfsUtil(start, visited);
        System.out.println();
    }

    private void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        
        for(int neighbor : adjList[node]) {
            if(!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }
}

public class GraphDemo {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        // Adding edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.bfs(0);
        graph.dfs(0);
    }
}
