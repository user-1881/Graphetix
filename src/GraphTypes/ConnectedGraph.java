package GraphTypes;

import CustomUtilityFunctions.CustomLinkedList;
import GraphFunctionalities.*;
import GraphInterface.IGraph;

@SuppressWarnings("unchecked")
public class ConnectedGraph implements IGraph
{
    int node;
    int edgeNo;

    CustomLinkedList<Integer> deletedIndex = new CustomLinkedList<>();

    public CustomLinkedList<int[]>[] GraphRepresentationList;
    public ConnectedGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new CustomLinkedList[node];

        for (int i = 0; i < node; i++)
        {
            GraphRepresentationList[i] = new CustomLinkedList<>();
        }
        for (int i = 0; i < node-1 ; i++)
        {
            int[] edge1 = {i+1,0};
            int[] edge2 = {i,0};
            GraphRepresentationList[i].addLast(edge1);
            GraphRepresentationList[i+1].addLast(edge2);
        }

    }

    @Override
    public void addWeightedEdge(int source, int dest, int weight)
    {
        BasicMethod g =new BasicMethod(GraphRepresentationList);
        if(deletedIndex.contains(source))
        {
            System.out.println("vertex "+ source+ " doesn't exist. So no edge can be added");
        }
        else
        {
            g.addWeightedEdge(source,dest,weight);
        }
        edgeNo++;
    }
    @Override
    public void removeWeightedEdge(int source,int dest,int weight)
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.removeWeightedEdge(source, dest,weight);
        edgeNo--;

    }
    public void GraphDetails()
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.GraphDetail();
        System.out.print("No of Edges : "+ edgeNo +"\n");
        System.out.print("Connected Graph");


    }
    public  void ConvertToDisconnected()
    {
        for (int i = 0; i < node-1 ; i++)
        {
            GraphRepresentationList[i].clear();


        }
        System.out.println("The graph has been converted to Disconnected");
    }


    @Override
    public void addNode(int node_num)
    {
        int dummy = node;
        int num_of_new_nodes = node + node_num;
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.addNode(node_num,node);
        node = num_of_new_nodes;

            for(int i= dummy-1;i<node-1;i++)
            {
                int[] edge3 = {i+1,0};
                int[] edge4 = {i,0};
                GraphRepresentationList[i].addLast(edge3);
                GraphRepresentationList[i+1].addLast(edge4);
            }


        System.out.println("Added "+ node_num+ " number of nodes in the Connected GraphDelegator.Graph.");
    }
    @Override
    public void removeNode(int node_num)
    {
        deletedIndex.addLast(node_num);
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        int[] edge5 = {node_num+1,0};
        int[] edge6 = {node_num-1,0};
        GraphRepresentationList[node_num-1].addLast(edge5);
        GraphRepresentationList[node_num+1].addLast(edge6);
        System.out.println("Removed the node "+ node_num + " from the connected graph.");


    }
    @Override
    public void GraphRepresentation()
    {
        System.out.println("List Representation for Connected graph:");
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
