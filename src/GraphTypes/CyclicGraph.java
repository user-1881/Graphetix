package GraphTypes;

import CustomUtilityFunctions.*;
import GraphFunctionalities.*;
import GraphInterface.IGraph;

@SuppressWarnings("unchecked")
public class CyclicGraph implements IGraph
{
    public  int node;
    int edgeNo;

    public CustomLinkedList<int[]>[] GraphRepresentationList;

    public CyclicGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new CustomLinkedList[node];
        for (int i = 0; i < node; i++) {
            GraphRepresentationList[i] = new CustomLinkedList<>();
        }
    }

    @Override
    public void addWeightedEdge(int source, int dest,int weight)
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.addWeightedEdge(source, dest, weight);
        edgeNo++;
    }

    public void GraphDetails()
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.GraphDetail();
        System.out.print("Time complexity of MaxFlow : O(V*E^2 )"+"\n");
        System.out.print("No of Edges : "+ edgeNo +"\n");
        System.out.print("Cyclic Graph");

    }

    @Override
    public void removeWeightedEdge(int source,int dest,int weight)
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.removeWeightedEdge(source, dest,weight);
        edgeNo--;


    }
    @Override
    public void addNode(int node_num)
    {

        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.addNode(node_num,node);
        System.out.println("Added "+ node_num+ " number of nodes in the Cyclic GraphDelegator.Graph.");
    }


    @Override
    public void removeNode(int node_num)
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        System.out.println("Removed the node "+ node_num + " from the Cyclic graph.");

    }
    public void convertToAcyclic() {
        boolean[] visited = new boolean[node];
        for (int i = 0; i < node; i++) {
            if (!visited[i]) {
                DFSRemoveCycles(i, visited, -1);
            }
        }
    }

    private void DFSRemoveCycles(int currentNode, boolean[] visited, int parent) {
        visited[currentNode] = true;

        for (int j = 0; j < GraphRepresentationList[currentNode].length(); j++) {
            int[] neighbor = GraphRepresentationList[currentNode].get(j);

            if (!visited[neighbor[0]]) {
                DFSRemoveCycles(neighbor[0], visited, currentNode);
            } else if (neighbor[0] != parent) {
                // This edge forms a cycle, so remove it
                removeWeightedEdge(currentNode, neighbor[0], neighbor[1]);
            }
        }
    }


    @Override
    public void GraphRepresentation()
    {
        System.out.println("List Representation for Cyclic graph:");
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