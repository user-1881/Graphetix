package ShortestPathTraversal;

import java.util.*;
import CustomUtilityFunctions.CustomLinkedList;

public class BellmanFordShortestPath {
    int vertex;
    CustomLinkedList<int[]>[] GraphRepresentationList;

    public BellmanFordShortestPath(CustomLinkedList<int[]>[] GraphRepresentationList) {
        this.GraphRepresentationList = GraphRepresentationList;
        vertex = GraphRepresentationList.length;
        int source = 0;
        BellmanFord(source);

    }


    public void BellmanFord(int src) {
        int[] dist = new int[vertex];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;


        for (int i = 0; i < vertex - 1; ++i) {
            for (int j = 0; j < vertex; ++j) {
                int finalJ = j;
                GraphRepresentationList[j].forEach(edge -> {
                    int vertex = edge[0];
                    int weight = edge[1];
                    if (dist[finalJ] != Integer.MAX_VALUE && dist[finalJ] + weight < dist[vertex]) {
                        dist[vertex] = dist[finalJ] + weight;
                    }
                });
            }
        }

        for (int j = 0; j < vertex; ++j) {
            int finalJ = j;
            GraphRepresentationList[j].forEach(edge -> {
                int vertex = edge[0];
                int weight = edge[1];
                if (dist[finalJ] != Integer.MAX_VALUE && dist[finalJ] + weight < dist[vertex]) {
                    System.out.println("Graph contains negative weight cycle");

                }
            });
        }

        printArr(dist);
    }

    public void printArr(int[] dist)

    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < vertex; ++i) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }






}
