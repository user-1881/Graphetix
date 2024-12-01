package GraphTypes;

import CustomUtilityFunctions.*;
import GraphFunctionalities.*;
import GraphInterface.IGraph;

@SuppressWarnings("unchecked")
public class CompleteGraph implements IGraph
{

    int node;
    int edgeNo;

    public CustomLinkedList<int[]>[] GraphRepresentationList;


    public CompleteGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new CustomLinkedList[node];

        for (int i = 0; i < node; i++)
        {
            GraphRepresentationList [i] = new CustomLinkedList<>();
        }
        for (int i = 0; i < node; i++)
        {
            for (int j = i + 1; j < node; j++)
            {
                int[] edge1 = {j,0};
                int[] edge2 = {i,0};
                GraphRepresentationList[i].addLast(edge1);
                GraphRepresentationList[j].addLast(edge2);
                edgeNo++;
            }
        }

    }
    public void GraphDetails()
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.GraphDetail();
        System.out.print("Time complexity of MaxFlow : O(V*E^2 )"+"\n");
        System.out.print("No of Edges : "+ edgeNo +"\n");
        System.out.print("Complete Graph");



    }

    @Override
    public void addWeightedEdge(int source, int dest, int weight)
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.addWeightedEdge(source, dest, weight);
        edgeNo++;
    }



    @Override
    public void removeWeightedEdge(int source, int dest, int weight)
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.removeWeightedEdge(source, dest,weight);
         edgeNo--;
    }
    @Override
    public void addNode(int node_num)
    {
        int dummy = node;
        int num_of_new_nodes = node + node_num;
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.addNode(node_num,node);
        node = num_of_new_nodes;

        for (int i = 0; i < node; i++)
        {
            if(i<dummy)
            {
                if (!GraphRepresentationList[i].isEmpty())
                {
                    for(int j=dummy;j<node;j++)
                    {
                        int[] edge3 = {j,0};
                        GraphRepresentationList[i].addLast(edge3);
                    }

                }
            }
            else
            {
                for(int k=0;k<dummy;k++)
                {
                    if (!GraphRepresentationList[k].isEmpty())
                    {
                        int[] edge4 = {k,0};
                        GraphRepresentationList[i].addLast(edge4);
                    }
                }
                for(int l=dummy;l<node;l++)
                {
                    if(i!=l)
                    {
                        int[] edge5 = {l,0};
                        GraphRepresentationList[i].addLast(edge5);
                    }
                }
            }
        }


        System.out.println("Added "+ node_num+ " number of nodes in the Complete GraphDelegator.Graph.");
    }



    @Override
    public void removeNode(int node_num)
    {

        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        System.out.println("Removed the node "+ node_num + " from the complete graph.");

    }

    @Override
    public void GraphRepresentation()
    {
        System.out.println("List Representation for Complete graph:");
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
