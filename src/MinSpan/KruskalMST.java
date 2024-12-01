package MinSpan;

import CustomUtilityFunctions.*;
public class KruskalMST {

    public int node;
    public CustomLinkedList<int[]>[] GraphRepresentationList;
    int[] parent;

    public KruskalMST(CustomLinkedList<int[]>[] GraphRepresentationList)
    {
        this.GraphRepresentationList = GraphRepresentationList;
        node = GraphRepresentationList.length;

        parent = new int[node];
        for (int i = 0; i < node; i++) {
            parent[i] = i; // Initially, each node is its own parent
        }
        display();
    }

    public CustomLinkedList<int[]> kruskalMST()
    {
        CustomLinkedList<int[]> resultMST = new CustomLinkedList<>();
        CustomLinkedList<int[]> allEdges = new CustomLinkedList<>();

        // Collect all edges from the graph representation
        for (int i = 0; i < node; i++) {
            for (int j = 0; j < GraphRepresentationList[i].length(); j++) {
                int[] edge = GraphRepresentationList[i].get(j);
                if (i < edge[0]) {
                    allEdges.addLast(new int[]{i, edge[0], edge[1]});
                }
            }
        }

        // Sorting edges based on weights using the custom method
        sortEdges(allEdges);

        int edgesCount = 0;
        int index = 0;

        while (edgesCount < node - 1 && index < allEdges.length()) {
            int[] nextEdge = allEdges.get(index++);
            int rootX = find(nextEdge[0]);
            int rootY = find(nextEdge[1]);

            if (rootX != rootY) {
                resultMST.addLast(nextEdge);
                union(rootX, rootY);
                edgesCount++;
            }
        }

        return resultMST;
    }

    private int find(int vertex)
    {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex]); // Path compression
        }
        return parent[vertex];
    }

    private void union(int x, int y)
    {
        parent[y] = x;
    }

    private void sortEdges(CustomLinkedList<int[]> edgesList) {
        // Convert CustomLinkedList to an array for sorting
        int[][] edgesArray = new int[edgesList.length()][];
        for (int i = 0; i < edgesArray.length; i++) {
            edgesArray[i] = edgesList.get(i);
        }


        // Sorting edges based on weights using Arrays.sort
        for (int i = 0; i < edgesArray.length - 1; i++) {
            for (int j = 0; j < edgesArray.length - i - 1; j++) {
                if (edgesArray[j][2] > edgesArray[j + 1][2]) {
                    int[] temp = edgesArray[j];
                    edgesArray[j] = edgesArray[j + 1];
                    edgesArray[j + 1] = temp;
                }
            }
        }


        // Clear the original list and repopulate with sorted edges
        edgesList.clear();
        for (int[] edge : edgesArray) {
            edgesList.addLast(edge);
        }
    }


    public void display()
    {

        CustomLinkedList<int[]> minimumSpanningTree= kruskalMST();
        final int[] min_cost = {0};

        System.out.println("Edges in the Minimum Spanning Tree (MST):");
        minimumSpanningTree.forEach(edge -> {
            System.out.println("Edge: " + edge[0] + " - " + edge[1] + " | Weight: " + edge[2]);
            min_cost[0] += edge[2];
        });

        System.out.println("Total Cost of MST: " + min_cost[0]);
    }
}
