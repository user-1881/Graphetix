package GraphTypeChecker;

import CustomUtilityFunctions.*;

import java.util.Scanner;

public class GraphTypeChecker {
    private final CustomLinkedList<CustomLinkedList<Integer>> adjacencyList;
    private final boolean[] visited;
    private final boolean[] recStack;
    private final int vertices;
    private int totalEdges;
    public boolean isSimple;
    public boolean isDirected;
    private boolean foundDirectedEdge = false;

    public GraphTypeChecker(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new CustomLinkedList<>();
        for (int i = 0; i < vertices; i++) {

            this.adjacencyList.addFirst(new CustomLinkedList<>());
        }
        this.visited = new boolean[vertices];
        this.recStack = new boolean[vertices];
        this.isSimple = true;
        this.isDirected = false;
        this.totalEdges = 0;
    }

    public void addEdge(int from, int to) {
        if (from == to || adjacencyList.get(from).contains(to)) {
            isSimple = false;
            return;
        }

        if (!adjacencyList.get(to).contains(from)) {
            isDirected = true;
        }
        adjacencyList.get(from).addFirst(to);
        if (from < to) {
            totalEdges++;
        }
    }
    public void checkDirected() {
        foundDirectedEdge = false;

        for (int from = 0; from < vertices; from++) {
            int finalFrom = from; // Required for use inside lambda
            CustomLinkedList<Integer> fromList = adjacencyList.get(from);

            fromList.forEach(to -> {
                if (finalFrom != to && !adjacencyList.get(to).contains(finalFrom)) {
                    foundDirectedEdge = true;
                }
            });

            if (foundDirectedEdge) {
                break;
            }
        }

        isDirected = foundDirectedEdge;
    }
    public boolean isCyclic() {
        fill(visited, false);
        fill(recStack, false);

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int node) {
        if (recStack[node]) {
            return true;
        }
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        recStack[node] = true;

        CustomLinkedList<Integer> neighbors = adjacencyList.get(node);
        boolean hasCycle = neighbors.anyMatch(neighbor -> (!visited[neighbor] && isCyclicUtil(neighbor)) || recStack[neighbor]);

        recStack[node] = false;
        return hasCycle;
    }

    public boolean isConnected() {
        fill(visited, false);
        dfs(0);

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }


    private void dfs(int v) {
        visited[v] = true;


        CustomLinkedList<Integer> neighbors = adjacencyList.get(v);


        neighbors.forEach(neighbor -> {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        });
    }
    private void fill(boolean[] array, boolean value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }
    public boolean isTree() {
        return !isCyclic() && isConnected() && totalEdges == vertices - 1;
    }

    public boolean isComplete() {
        checkDirected();
        if( !isDirected && isSimple )
            return totalEdges == vertices * (vertices - 1) / 2;
        else
            return false;
    }



    public void checkGraph()
    {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter the connections for each node:");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Connections for node " + i + " (end with -1): ");
            while (true) {
                int connection = scanner.nextInt();
                if (connection == -1) {
                    break;
                }
                if (connection < 0 || connection >= vertices) {
                    System.out.println("Invalid input: Node " + connection + " does not exist. Try again.");
                    continue;
                }
                addEdge(i, connection);
            }
        }


        System.out.println("Based on the input:");
        if (vertices == 1) {
            System.out.println("The graph is Trivially Connected (only one node).");
        } else if (isConnected()) {
            System.out.println("The graph is Connected.");
        } else {
            System.out.println("The graph is Disconnected.");
        }

        if (isSimple) {
            System.out.println("The graph is Simple.");
        }

        if (isTree()) {
            System.out.println("The graph is a Tree.");
        } else {
            System.out.println("The graph is not a Tree.");
        }

        if (isCyclic()) {
            System.out.println("The graph is Cyclic.");
        } else {
            System.out.println("The graph is Acyclic.");
        }

        if (isComplete()) {
            System.out.println("The graph is a Complete Graph.");
        }


        if (isDirected) {
            System.out.println("The graph is Directed.");
        } else {
            System.out.println("The graph is Undirected.");
        }
    }


}


