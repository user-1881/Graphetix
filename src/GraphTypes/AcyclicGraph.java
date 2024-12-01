package GraphTypes;

import CustomUtilityFunctions.*;
import GraphFunctionalities.*;
import GraphInterface.IGraph;

@SuppressWarnings("unchecked")

public class AcyclicGraph implements IGraph
{
    public  int node;

    public CustomLinkedList<int[]>[] GraphRepresentationList ;
    int edgeNo=0;

    public AcyclicGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new CustomLinkedList[node];
        for (int i = 0; i < node; i++)
        {
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
        System.out.println("Added "+ node_num+ " number of nodes in the Acyclic GraphDelegator.Graph.");
    }


    @Override
    public void removeNode(int node_num)
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        System.out.println("Removed the node "+ node_num + " from the Acyclic graph.");

    }
    public boolean isCyclic() {
        boolean[] visited = new boolean[node];
        for (int i = 0; i < node; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCyclicUtil(int currentNode, boolean[] visited, int parent) {
        visited[currentNode] = true;

        for (int j = 0; j < GraphRepresentationList[currentNode].length(); j++) {
            int[] neighbor = GraphRepresentationList[currentNode].get(j);

            if (neighbor[0] == currentNode) {
                continue;
            }

            if (!visited[neighbor[0]]) {
                if (isCyclicUtil(neighbor[0], visited, currentNode)) {
                    return true;
                }
            } else if (neighbor[0] != parent) {
                return true;
            }
        }

        return false;
    }

    public void convertToCyclic() {
        if (isCyclic()) {
            System.out.println("The graph is already cyclic.");
            return;
        }

        for (int i = 0; i < node; i++) {
            for (int j = i + 1; j < node; j++) {
                if (!hasEdge(i, j)) {
                    addWeightedEdge(i, j, 0);
                    if (isCyclic()) {
                        System.out.println("Successfully converted the graph to cyclic by adding an edge between " + i + " and " + j);
                        return;
                    } else {
                        removeWeightedEdge(i, j, 0);
                    }
                }
            }
        }

        System.out.println("Could not convert the graph to cyclic.");
    }

    private boolean hasEdge(int source, int dest) {
        for (int i = 0; i < GraphRepresentationList[source].length(); i++) {
            int[] neighbor = GraphRepresentationList[source].get(i);
            if (neighbor[0] == dest) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void GraphRepresentation()
    {
        System.out.println("List Representation for Acyclic graph:");
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
    public void GraphDetails()
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.GraphDetail();
        System.out.print("Time complexity of MaxFlow : O(V*E^2 )"+"\n");
        System.out.print("No of Edges : "+ edgeNo +"\n");
        System.out.print("Acyclic Graph" +"\n");


    }



}