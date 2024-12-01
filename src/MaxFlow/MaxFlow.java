package MaxFlow;
import CustomUtilityFunctions.*;
import java.util.Scanner;


public class MaxFlow {
    public  int node;

    public CustomLinkedList<int[]>[] graph;

    public MaxFlow(CustomLinkedList<int[]>[] GraphRepresentationList) {
        Scanner scanner= new Scanner(System.in);
        this.graph = GraphRepresentationList;
        this.node = GraphRepresentationList.length;
        System.out.print("Enter the source node: ");
        int src2 = scanner.nextInt();


        System.out.print("Enter the destination node: ");
        int destination = scanner.nextInt();
        int MaxFlow = findMaxFlow( src2, destination);
        System.out.println("The maximum possible MaxFlow is " + MaxFlow);
    }

    public void addWeightedEdge(int source, int destination, int weight) {
        int[] edge = { destination, weight };
        int[] reverseEdge = { source, 0 };
        graph[source].addLast(edge);
        graph[destination].addLast(reverseEdge);
    }



    private boolean bfs(int source, int sink, int[] parent) {
        boolean[] visited = new boolean[node];
        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.offer(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.pollQueue();

            graph[u].forEach(edge -> {
                int v = edge[0];
                int capacity = edge[1];
                if (!visited[v] &&capacity > 0) {
                    queue.offer(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            });
        }
        return visited[sink];
    }

    public int findMaxFlow(int source, int sink) {
        int[] parent = new int[node];
        int MaxFlow = 0;

        while (bfs(source, sink, parent)) {
            int pathMaxFlow = Integer.MAX_VALUE;


            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                final int[] minFlow = {pathMaxFlow};
                int finalV = v;
                graph[u].forEach(edge -> {
                    if (edge[0] == finalV) {
                        minFlow[0] = Math.min(minFlow[0], edge[1]);
                    }
                });

                pathMaxFlow = minFlow[0];
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];

                int finalPathMaxFlow = pathMaxFlow;
                int finalV = v;
                graph[u].forEach(edge -> {
                    if (edge[0] == finalV) {
                        edge[1] -= finalPathMaxFlow;
                    }
                });

                int finalPathMaxFlow1 = pathMaxFlow;
                graph[v].forEach(revEdge -> {
                    if (revEdge[0] == u) {
                        revEdge[1] += finalPathMaxFlow1;
                    }
                });
            }

            MaxFlow += pathMaxFlow;
        }

        return MaxFlow;
    }


}
