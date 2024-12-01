package MinSpan;

import CustomUtilityFunctions.*;

import java.util.concurrent.atomic.AtomicInteger;

public class PrimsMST {
    public int node;
    public CustomLinkedList<int[]>[] GraphRepresentationList;

    public PrimsMST(CustomLinkedList<int[]>[] GraphRepresentationList) {
        this.GraphRepresentationList = GraphRepresentationList;
        this.node = GraphRepresentationList.length;
        display();
    }



    public CustomLinkedList<int[]> primMST() {
        CustomLinkedList<int[]> resultMST = new CustomLinkedList<>();
        int[] parent = new int[node];
        int[] key = new int[node];
        Boolean[] mstSet = new Boolean[node];

        for (int i = 0; i < node; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < node - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int j = 0; j < GraphRepresentationList[u].length(); j++) {
                int[] edge = GraphRepresentationList[u].get(j);
                int v = edge[0];
                int weight = edge[1];
                if (!mstSet[v] && weight < key[v]) {
                    parent[v] = u;
                    key[v] = weight;
                }
            }
        }

        for (int i = 1; i < node; i++) {
            int[] edge = { parent[i], i, key[i] };
            resultMST.addLast(edge);
        }

        return resultMST;
    }

    int minKey(int key[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < node; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

   public void display()
    {
        CustomLinkedList<int[]> minimumSpanningTree = primMST();


        System.out.println("Edges in the Minimum Spanning Tree (MST):");
        AtomicInteger min_cost = new AtomicInteger();
        minimumSpanningTree.forEach(edge -> {
            System.out.println("Edge: " + edge[0] + " - " + edge[1] + " | Weight: " + edge[2]);
            min_cost.addAndGet(edge[2]);
        });
        System.out.println("Total Cost of MST:" + min_cost);
    }
}
