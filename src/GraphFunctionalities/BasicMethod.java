package GraphFunctionalities;
import CustomUtilityFunctions.CustomLinkedList;


@SuppressWarnings("unchecked")

public class BasicMethod {
    public CustomLinkedList<int[]>[] GraphRepresentationList ;

    public BasicMethod(CustomLinkedList<int[]>[] GraphRepresentationList)
    {
        this.GraphRepresentationList=GraphRepresentationList;
    }
    public void addWeightedEdge(int source, int dest,int weight)
    {
        int[] edge = {dest, weight};
        int[] edge2 ={source,weight};
        GraphRepresentationList[source].addFirst(edge);
        GraphRepresentationList[dest].addFirst(edge2);
        System.out.println("Added an edge between " + source + " & " + dest+" having weight: "+weight);


    }
    public void removeWeightedEdge(int source,int dest,int weight)
    {

        for(int j=0;j<GraphRepresentationList[source].length();j++)
        {
            int[] edge = GraphRepresentationList[source].get(j);
            if(dest == edge[0] && weight == edge[1])
            {
                GraphRepresentationList[source].removeValue(edge);
            }
        }
        for(int j=0;j<GraphRepresentationList[dest].length();j++)
        {
            int[] edge = GraphRepresentationList[dest].get(j);
            if(source == edge[0] && weight == edge[1])
            {
                GraphRepresentationList[dest].removeValue(edge);
            }
        }

        System.out.println("Removed an edge between " + source + " & " + dest+" having weight: "+weight);

    }
    public void addNode(int node_num, int node)
    {
        int num_of_new_nodes = node + node_num;
        CustomLinkedList<int[]>[] newGraphRepresentList = new CustomLinkedList[num_of_new_nodes];
        for(int i = 0; i < node; i++)
        {
            newGraphRepresentList[i] = GraphRepresentationList[i];
        }

        for (int i = node; i < num_of_new_nodes; i++)
        {
            newGraphRepresentList[i] = new CustomLinkedList<>();
        }

        node = num_of_new_nodes;
        GraphRepresentationList = newGraphRepresentList;



    }
    public void removeNode(int node_num,int node) {
        GraphRepresentationList[node_num].clear();

        for (int i=0;i<node;i++)
        {
            for(int j=0;j<GraphRepresentationList[i].length();j++)
            {
                int[] edge = GraphRepresentationList[i].get(j);
                if(node_num == edge[0])
                {
                    GraphRepresentationList[i].removeValue(edge);
                }

            }
        }

    }
    public void GraphRepresentation(int node)
    {

        for (int i = 0; i < node; i++)
        {
            System.out.print("Vertex " + i + " is connected to: ");
            int f = GraphRepresentationList[i].length();
            if(f==0)
            {
                System.out.println("Empty List");
                continue;
            }
            for (int j = 0; j < f; j++)
            {

                int[] edge = GraphRepresentationList[i].get(j);
                System.out.print("(" + edge[0] + ", Weight: " + edge[1] + ") ");
            }

            System.out.println();
        }

    }
    public void GraphDetail()
    {
        System.out.print("Number of nodes : " + GraphRepresentationList.length+"\n");
        System.out.print("Time complexity of DFS : O(V+E)"+"\n");
        System.out.print("Time complexity of BFS : O(V+E)"+"\n");
        System.out.print("Time complexity of Dijkstra : O(V logV + E logV)"+"\n");
        System.out.print("Time complexity of kruskals : O(E logE )"+"\n");
        System.out.print("Time complexity of PRIMS: O(V^2)"+"\n");







    }
    public void GraphDetailDirected()
    {
        System.out.print("Number of nodes : " + GraphRepresentationList.length+"\n");
        System.out.print("Time complexity of BellmanFord : O(V*E)\n");



    }
}
