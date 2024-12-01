package GraphInterface;

public interface IGraph
{
    void addWeightedEdge(int source,int dest,int weight);
    void addNode(int node_num);
    void removeNode(int node_num);
    void removeWeightedEdge(int source,int dest,int weight);
    void GraphRepresentation();
    void bfs(int start_node);
    void dfs(int start_node);
    void GraphDetails();
}
