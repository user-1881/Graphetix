package GraphTypes;

import CustomUtilityFunctions.*;
import GraphFunctionalities.*;
import GraphInterface.IGraph;

import java.util.Scanner;

@SuppressWarnings("unchecked")
public class SimpleGraph implements IGraph
{
    public int node;
    int edgeNo=0;

    public CustomLinkedList<int[]>[] GraphRepresentationList;


    public SimpleGraph(int node)
    {

        this.node=node;
        GraphRepresentationList = new CustomLinkedList[node];

        int i=0;
        while(i<node)
        {
            GraphRepresentationList[i] = new CustomLinkedList<>();
            i++;
        }
    }
    @Override
    public void addWeightedEdge(int source, int dest, int weight) {
        BasicMethod g = new BasicMethod(GraphRepresentationList);
        Scanner scanner = new Scanner(System.in);


        while (true) {
            if (source == dest) {
                System.out.println("Cannot add any loop in a simple graph.");
            } else if (edgeExists(source, dest)) {
                System.out.println("Cannot add multi edges between two same nodes in a simple graph");
            } else {
                g.addWeightedEdge(source, dest, weight);
                edgeNo++;
                return;

            }


            System.out.print("Enter the source & destination node: ");
            source = scanner.nextInt();
            dest = scanner.nextInt();
        }
    }
    public void GraphDetails()
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.GraphDetail();
        System.out.print("Time complexity of MaxFlow : O(V*E^2 )"+"\n");
        System.out.print("No of Edges : "+ edgeNo +"\n");
        System.out.print("Simple Graph ");

    }


    private boolean edgeExists(int source, int dest) {
        for (int i = 0; i < GraphRepresentationList[source].length(); i++) {
            int[] edge = GraphRepresentationList[source].get(i);
            if (edge[0] == dest) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeWeightedEdge(int source,int dest,int weight)
    {
        BasicMethod g =new BasicMethod(GraphRepresentationList);
        g.removeWeightedEdge(source, dest,weight);
        edgeNo--;

    }

    @Override
    public void addNode(int node_num)
    {

        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.addNode(node_num,node);
        System.out.println("Added "+ node_num+ " number of nodes in the Simple GraphDelegator.Graph.");
    }

    @Override
    public void removeNode(int node_num)
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        System.out.println("Removed the node "+ node_num + " from the simple graph.");


    }

    @Override
    public void GraphRepresentation()
    {

        System.out.println("List Representation for Simple graph:");
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.GraphRepresentation(node);

    }

    public void bfs(int start_node)
    {
        TraversalMethod graphTraversal=new TraversalMethod(GraphRepresentationList,node);
        graphTraversal.BFS(start_node);

    }
    public void dfs(int start_node)
    {
        TraversalMethod graphTraversal=new TraversalMethod(GraphRepresentationList,node);
        graphTraversal.DFS(start_node);

    }






}