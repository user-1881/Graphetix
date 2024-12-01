package ShortestPathTraversal;
import CustomUtilityFunctions.*;
import java.util.Scanner;
import java.util.Comparator;


public class DijkstraShortestPath {
    Scanner scanner = new Scanner(System.in);

    public int node;
    public int source;
    public CustomLinkedList<int[]>[] GraphRepresentationList;

    public DijkstraShortestPath(CustomLinkedList<int[]>[] GraphRepresentationList) {
        this.GraphRepresentationList = GraphRepresentationList;
        this.node = GraphRepresentationList.length;
        display();
    }


    public void addWeightedEdge(int source, int destination, int weight) {
        int[] edge = { destination, weight };
        int[] edge2 = { source, weight };
        GraphRepresentationList[source].addLast(edge);
        GraphRepresentationList[destination].addLast(edge2);
    }

    public CustomLinkedList<Integer> findShortestPath(int source, int destination) {
        int[] dist = new int[node];
        int[] parent = new int[node];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        CustomPriorityQueue<int[]> minHeap = new CustomPriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        minHeap.add(new int[]{source, 0});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int u = current[0];

            if (current[1] > dist[u]) {
                continue;
            }

            GraphRepresentationList[u].forEach(neighbor -> {
                int v = neighbor[0];
                int alt = dist[u] + neighbor[1];
                if (alt < dist[v]) {
                    dist[v] = alt;
                    parent[v] = u;
                    minHeap.add(new int[]{v, alt});
                }
            });
        }

        CustomLinkedList<Integer> shortestPath = new CustomLinkedList<>();
        buildPath(shortestPath, parent, destination);
        return shortestPath;
    }

    private void buildPath(CustomLinkedList<Integer> path, int[] parent, int current) {

        if (current == source) {
            path.addLast(current);
            return;
        }


        if (current >= 0 && parent[current] != -1) {
            buildPath(path, parent, parent[current]);
        }

        path.addLast(current);
    }


    public void display(){


        System.out.print("Enter the source node: ");
        int src = scanner.nextInt();

        System.out.print("Enter the destination node: ");
        int destination = scanner.nextInt();
        CustomLinkedList<Integer> shortestPath = findShortestPath(src, destination);
        System.out.println("Shortest Path from node " + src + " to node " + destination + ": " + shortestPath);







    }
}
