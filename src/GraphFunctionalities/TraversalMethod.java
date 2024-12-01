package GraphFunctionalities;

import CustomUtilityFunctions.*;

@SuppressWarnings("unused")
public class TraversalMethod {
    int start_node;
    int node;
    CustomLinkedList<int[]>[] GraphRepresentationList;
    public TraversalMethod(CustomLinkedList<int[]>[] GraphRepresentationList, int n)
    {
        this.node=n;

        this.GraphRepresentationList= GraphRepresentationList;
    }
    public void BFS(int start_node)
    {
        boolean[] visited = new boolean[node];

        CustomQueue<Integer> queue = new CustomQueue<>();

        visited[start_node] = true;
        queue.addQueue(start_node);

        while (!queue.isEmpty())
        {
            start_node = queue.pollQueue();
            System.out.print(start_node + " ");

            CustomLinkedList<int[]> neighbors = GraphRepresentationList[start_node];
            neighbors.forEach(n -> {
                if (!visited[n[0]])
                {
                    visited[n[0]] = true;
                    queue.addLast(n[0]);
                }
            });

        }
        System.out.print("\n");
    }

    void DFSUtil(int start_node, boolean[] visited)
    {

        visited[start_node] = true;
        System.out.print(start_node + " ");


        GraphRepresentationList[start_node].forEach(n -> {
            if (!visited[n[0]]) {
                DFSUtil(n[0], visited);
            }
        });
    }

    public void DFS(int start_node)
    {
        boolean[] visited = new boolean[node];
        DFSUtil(start_node, visited);
    }

}
