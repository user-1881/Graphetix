import java.util.Scanner;
import javax.swing.*;
import GraphDelegator.Graph;
import GraphFunctionalities.*;
import GraphTypeChecker.GraphTypeChecker;
import MaxFlow.MaxFlow;
import MinSpan.*;
import ShortestPathTraversal.*;


@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Graphetix");
        int choice;
        do {
            System.out.println("MAIN MENU");
            System.out.println("1. Create a graph");
            System.out.println("2. Exit");
            System.out.print("Press the number for the desired operation: ");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    createGraph(scanner);
                    break;
                case 2:
                    System.out.println("Thank you for using Graphetix");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 2);
    }

    public static void createGraph(Scanner scanner)
    {
        System.out.println("Which type of graph do you want to create?");
        System.out.println("1. Simple Graph");
        System.out.println("2. Directed Graph");
        System.out.println("3. Undirected Graph");
        System.out.println("4. Connected Graph");
        System.out.println("5. Disconnected Graph");
        System.out.println("6. Complete Graph");
        System.out.println("7. Weighted Graph");
        System.out.println("8. Acyclic Graph");
        System.out.println("9. Cyclic Graph");
        System.out.println("10. General Graph");
        System.out.print("Press the number for the desired graph type: ");
        int graphType = scanner.nextInt();

        Graph s1;
        int node;

        switch (graphType)
        {
            case 1:
                System.out.print("How many nodes do you want to start your Simple Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Simple Graph",node);
                OperationSimple(scanner,s1);
                break;
            case 2:
                System.out.print("How many nodes do you want to start your Directed Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Directed Graph",node);
                OperationDirected(scanner,s1);
                break;
            case 3:
                System.out.print("How many nodes do you want to start your Undirected Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Undirected Graph",node);
                OperationUndirected(scanner,s1);
                break;
            case 4:
                System.out.print("How many nodes do you want to start your Connected Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Connected Graph",node);
                OperationConnected(scanner,s1);
                break;
            case 5:
                System.out.print("How many nodes do you want to start your Disconnected Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Disconnected Graph",node);
                OperationDisconnected(scanner,s1);

                break;
            case 6:
                System.out.print("How many nodes do you want to start your Complete Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Complete Graph",node);
                OperationComplete(scanner,s1);

                break;
            case 7:
                System.out.print("How many nodes do you want to start your Weighted Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Weighted Graph",node);
                OperationWeighted(scanner,s1);

                break;
            case 8:
                System.out.print("How many nodes do you want to start your Acyclic Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Acyclic Graph",node);
                OperationAcyclic(scanner,s1);

                break;
            case 9:
                System.out.print("How many nodes do you want to start your Cyclic Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Cyclic Graph",node);
                OperationCyclic(scanner,s1);

                break;
            case 10:
                System.out.print("Enter the number of nodes you want to start with: ");
                node = scanner.nextInt();
                GraphTypeChecker gc = new GraphTypeChecker(node);
                gc.checkGraph();
                break;
            default:
                System.out.println("Invalid graph type choice. Please try again.");

        }

    }


    public static void OperationSimple(Scanner scanner,Graph s1)
    {
        System.out.println("How many edges do you want to add?");
        int edge_num = scanner.nextInt();
        for(int i=0; i<edge_num;i++)
        {
            System.out.print("Enter the source, destination and weight of node: ");
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            int w = scanner.nextInt();
            s1.getSimple().addWeightedEdge(s,d,w);
        }

        while (true)
        {
            System.out.println("\n Which operation do you want to perform?");
            System.out.println("1. Graph Modifications");
            System.out.println("2. Graph Traversal");
            System.out.println("3. Finding Shortest Path");
            System.out.println("4. Graph Representation");
            System.out.println("5. Minimum Spanning");
            System.out.println("6. Max flow");
            System.out.println("7. Graph Details");
            System.out.println("8. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int dest;
            int start_node;
            int node_num;
            switch (task)
            {
                case 1:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Add edge");
                    System.out.println("2. Add node");
                    System.out.println("3. Remove edge");
                    System.out.println("4. Remove node");
                    System.out.println("5. Exit");
                    int taskS1 = scanner.nextInt();
                    switch(taskS1)
                    {
                        case 1:
                            System.out.print("Enter the source, destination and weight of node: ");
                            int s = scanner.nextInt();
                            int d = scanner.nextInt();
                            int w = scanner.nextInt();
                            s1.getSimple().addWeightedEdge(s,d,w);
                            break;
                        case 2:
                            System.out.print("Enter the no. of node to be added: ");
                            node_num = scanner.nextInt();
                            s1.getSimple().addNode(node_num);
                            break;
                        case 3:
                            System.out.print("Enter the source & destination node: ");
                            source = scanner.nextInt();
                            dest = scanner.nextInt();
                            s1.getSimple().removeWeightedEdge(source,dest,0);
                            break;
                        case 4:
                            System.out.print("Enter the node number: ");
                            node_num = scanner.nextInt();
                            s1.getSimple().removeNode(node_num);
                            break;

                        case 5:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");

                    }
                    break; 
                    case 2:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Breadth-First Traversal");
                    System.out.println("2. Depth-First Traversal");
                    System.out.println("3. Exit");
                    int taskS2 = scanner.nextInt();
                    switch(taskS2)
                    {
                        case 1:
                            System.out.print("Enter the start node of the Breadth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                            s1.getSimple().bfs(start_node);
                            break;
                        case 2:
                            System.out.print("Enter the start node of the Depth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                            s1.getSimple().dfs(start_node);
                            break;
                        case 3:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Which algorithm do you want to follow?");
                    System.out.println("1. Dijkstra Algorithm");
                    System.out.println("2. Exit");
                    int taskS3 = scanner.nextInt();
                    switch(taskS3)
                    {
                        case 1:
                            DijkstraShortestPath dijkstra =new DijkstraShortestPath(s1.getSimple().GraphRepresentationList);
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 4:
                    System.out.println("How do you want to view the graph?");
                    System.out.println("1. In Adjacency List");
                    System.out.println("2. Visual Representation");
                    System.out.println("3. Exit");
                    int taskS4 = scanner.nextInt();
                    switch(taskS4)
                    {
                        case 1:
                            s1.getSimple().GraphRepresentation();
                            break;
                        case 2:
                            SwingUtilities.invokeLater(() -> {
                                GraphVisualization visualRep = new GraphVisualization(s1.getSimple().GraphRepresentationList,false);
                            });
                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 5:
                    System.out.println("Which algorithm do you want to follow?");
                    System.out.println("1.Kruskals Algorithm");
                    System.out.println("2.Prims Algorithm");
                    System.out.println("3. Exit");
                    int taskW5 = scanner.nextInt();
                    switch(taskW5)
                    {
                        case 1:
                            KruskalMST kruskalmst =new KruskalMST(s1.getSimple().GraphRepresentationList);
                            break;
                        case 2:
                            PrimsMST prims =new PrimsMST(s1.getSimple().GraphRepresentationList);
                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 6:
                    MaxFlow maxFLow = new MaxFlow(s1.getSimple().GraphRepresentationList);
                    break;

                case 7:s1.getSimple().GraphDetails();
                    break;

                case 8:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }



    public static void OperationDirected(Scanner scanner,Graph s1)
    {
        System.out.println("How many edges do you want to add?");
        int edge_num = scanner.nextInt();
        for(int i=0; i<edge_num;i++)
        {
            System.out.print("Enter the source, destination and weight of node: ");
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            int w = scanner.nextInt();
            s1.getDirected().addWeightedEdge(s,d,w);
        }

        while (true)
        {
            System.out.println("\n Which operation do you want to perform?");
            System.out.println("1. Graph Modifications");
            System.out.println("2. Graph Traversal");
            System.out.println("3. Finding Shortest Path");
            System.out.println("4. Graph Representation");
            System.out.println("5. Max flow");
            System.out.println("6. Degree of a node");
            System.out.println("7. Graph Details");
            System.out.println("8. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int weight;
            int dest;
            int start_node;
            int node_num;
            switch (task)
            {
                case 1:
                System.out.println("Which operation do you want to perform?");
                System.out.println("1. Add edge");
                System.out.println("2. Add node");
                System.out.println("3. Remove edge");
                System.out.println("4. Remove node");
                System.out.println("5. Exit");
                int taskD1 = scanner.nextInt();
                switch(taskD1)
                {
                    case 1:
                        System.out.print("Enter the source, destination and weight of node: ");
                        int s = scanner.nextInt();
                        int d = scanner.nextInt();
                        int w = scanner.nextInt();
                        s1.getDirected().addWeightedEdge(s,d,w);
                        break;
                    case 2:
                        System.out.print("Enter the no. of node to be added: ");
                        node_num = scanner.nextInt();
                        s1.getDirected().addNode(node_num);
                        break;
                    case 3:
                        System.out.print("Enter the source, destination and weight of node: ");
                        source = scanner.nextInt();
                        dest = scanner.nextInt();
                        weight = scanner.nextInt();
                        s1.getDirected().removeWeightedEdge(source,dest,weight);
                        break;
                    case 4:
                        System.out.print("Enter the node number: ");
                        node_num = scanner.nextInt();
                        s1.getDirected().removeNode(node_num);
                        break;

                    case 5:
                        return;
                    default:
                        System.out.println("Invalid operation choice. Please try again.");

                }
                break;
                case 2:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Breadth-First Traversal");
                    System.out.println("2. Depth-First Traversal");
                    System.out.println("3. Exit");
                    int taskD2 = scanner.nextInt();
                    switch(taskD2)
                    {
                        case 1:
                            System.out.print("Enter the start node of the Breadth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                            s1.getDirected().bfs(start_node);
                            break;
                        case 2:
                            System.out.print("Enter the start node of the Depth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                            s1.getDirected().dfs(start_node);
                            break;
                        case 3:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Which algorithm do you want to follow?");
                    System.out.println("1. Bellman Ford Algorithm");
                    System.out.println("2. Exit");
                    int taskD3 = scanner.nextInt();
                    switch(taskD3)
                    {
                        case 1:
                            BellmanFordShortestPath bellman =new BellmanFordShortestPath(s1.getDirected().GraphRepresentationList);
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 4:
                    System.out.println("How do you want to view the graph?");
                    System.out.println("1. In Adjacency List");
                    System.out.println("2. Visual Representation");
                    System.out.println("3. Exit");
                    int taskD4 = scanner.nextInt();
                    switch(taskD4)
                    {
                        case 1:
                            s1.getDirected().GraphRepresentation();
                            break;
                        case 2:
                            SwingUtilities.invokeLater(() -> {
                                GraphVisualization visualRep = new GraphVisualization(s1.getDirected().GraphRepresentationList,true);
                            });
                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 5:
                    MaxFlow maxFlow = new MaxFlow(s1.getDirected().GraphRepresentationList);
                    break;
                case 6:
                    System.out.println("Which node you want to find the degree of?");
                    int d = scanner.nextInt();
                    s1.getDirected().inDegree(d);
                    s1.getDirected().outDegree(d);
                    break;

                case 7:s1.getDirected().GraphDetails();
                    break;

                case 8:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }



    public static void OperationUndirected(Scanner scanner,Graph s1)
    {
        System.out.println("How many edges do you want to add?");
        int edge_num = scanner.nextInt();
        for(int i=0; i<edge_num;i++)
        {
            System.out.print("Enter the source, destination and weight of node: ");
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            int w = scanner.nextInt();
            s1.getUndirected().addWeightedEdge(s,d,w);
        }

        while (true)
        {
            System.out.println("\n Which operation do you want to perform?");
            System.out.println("1. Graph Modifications");
            System.out.println("2. Graph Traversal");
            System.out.println("3. Finding Shortest Path");
            System.out.println("4. Graph Representation");
            System.out.println("5. Minimum Spanning");
            System.out.println("6. Max flow");
            System.out.println("7. Graph Conversion");
            System.out.println("8. Graph Details");
            System.out.println("9. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int weight;
            int dest;
            int start_node;
            int node_num;
            switch (task)
            {
                case 1:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Add edge");
                    System.out.println("2. Add node");
                    System.out.println("3. Remove edge");
                    System.out.println("4. Remove node");
                    System.out.println("5. Exit");
                    int taskU1 = scanner.nextInt();
                    switch(taskU1)
                    {
                        case 1:
                            System.out.print("Enter the source, destination and weight of node: ");
                            int s = scanner.nextInt();
                            int d = scanner.nextInt();
                            int w = scanner.nextInt();
                            s1.getUndirected().addWeightedEdge(s,d,w);
                            break;
                        case 2:
                            System.out.print("Enter the no. of node to be added: ");
                            node_num = scanner.nextInt();
                            s1.getUndirected().addNode(node_num);
                            break;
                        case 3:
                            System.out.print("Enter the source, destination and weight of node: ");
                            source = scanner.nextInt();
                            dest = scanner.nextInt();
                            weight = scanner.nextInt();
                            s1.getUndirected().removeWeightedEdge(source,dest,weight);
                            break;
                        case 4:
                            System.out.print("Enter the node number: ");
                            node_num = scanner.nextInt();
                            s1.getUndirected().removeNode(node_num);
                            break;

                        case 5:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");

                    }
                    break;
                case 2:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Breadth-First Traversal");
                    System.out.println("2. Depth-First Traversal");
                    System.out.println("3. Exit");
                    int taskU2 = scanner.nextInt();
                    switch(taskU2)
                    {
                        case 1:
                            System.out.print("Enter the start node of the Breadth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                            s1.getUndirected().bfs(start_node);
                            break;
                        case 2:
                            System.out.print("Enter the start node of the Depth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                            s1.getUndirected().dfs(start_node);
                            break;
                        case 3:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Which algorithm do you want to follow?");
                    System.out.println("1. Dijkstra Algorithm");
                    System.out.println("2. Exit");
                    int taskU3 = scanner.nextInt();
                    switch(taskU3)
                    {
                        case 1:
                            DijkstraShortestPath dijkstra =new DijkstraShortestPath(s1.getUndirected().GraphRepresentationList);
                            break;
                        case 2:

                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 4:
                    System.out.println("How do you want to view the graph?");
                    System.out.println("1. In Adjacency List");
                    System.out.println("2. Visual Representation");
                    System.out.println("3. Exit");
                    int taskU4 = scanner.nextInt();
                    switch(taskU4)
                    {
                        case 1:
                            s1.getUndirected().GraphRepresentation();
                            break;
                        case 2:
                            SwingUtilities.invokeLater(() -> {
                                GraphVisualization visualRep = new GraphVisualization(s1.getUndirected().GraphRepresentationList,false);
                            });
                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 5:
                    System.out.println("Which algorithm do you want to follow?");
                    System.out.println("1.Kruskals Algorithm");
                    System.out.println("2.Prims Algorithm");
                    System.out.println("3. Exit");
                    int taskW5 = scanner.nextInt();
                    switch(taskW5)
                    {
                        case 1:
                            KruskalMST kruskalmst =new KruskalMST(s1.getUndirected().GraphRepresentationList);

                            break;
                        case 2:
                            PrimsMST prims =new PrimsMST(s1.getUndirected().GraphRepresentationList);

                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 6:
                    MaxFlow maxFlow = new MaxFlow(s1.getUndirected().GraphRepresentationList);
                    break;

                case 7:
                    System.out.print("Enter the source & destination node: ");
                    source = scanner.nextInt();
                    dest = scanner.nextInt();
                    s1.getUndirected().convertToDirected(source,dest);
                    break;
                case 8:s1.getUndirected().GraphDetails();
                    break;

                case 9:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }



    }



    public static void OperationConnected(Scanner scanner,Graph s1)
    {
        System.out.println("How many edges do you want to add?");
        int edge_num = scanner.nextInt();
        for(int i=0; i<edge_num;i++)
        {
            System.out.print("Enter the source, destination and weight of node: ");
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            int w = scanner.nextInt();
            s1.getConnectedG().addWeightedEdge(s,d,w);
        }

        while (true)
        {
            System.out.println("\n Which operation do you want to perform?");
            System.out.println("1. Graph Modifications");
            System.out.println("2. Graph Traversal");
            System.out.println("3. Finding Shortest Path");
            System.out.println("4. Graph Representation");
            System.out.println("5. Minimum Spanning");
            System.out.println("6. Max flow");
            System.out.println("7. ConvertToDisconnected");
            System.out.println("8. Graph Details");
            System.out.println("9. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int dest;
            int weight;
            int start_node;
            int node_num;
            switch (task)
            {
                case 1:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Add edge");
                    System.out.println("2. Add node");
                    System.out.println("3. Remove edge");
                    System.out.println("4. Remove node");
                    System.out.println("5. Exit");
                    int taskC1 = scanner.nextInt();
                    switch(taskC1)
                    {
                        case 1:
                            System.out.print("Enter the source, destination and weight of node: ");
                            int s = scanner.nextInt();
                            int d = scanner.nextInt();
                            int w = scanner.nextInt();
                            s1.getConnectedG().addWeightedEdge(s,d,w);
                            break;
                        case 2:
                            System.out.print("Enter the no. of node to be added: ");
                            node_num = scanner.nextInt();
                            s1.getConnectedG().addNode(node_num);
                            break;
                        case 3:
                            System.out.print("Enter the source, destination and weight of node: ");
                            source = scanner.nextInt();
                            dest = scanner.nextInt();
                            weight = scanner.nextInt();
                            s1.getConnectedG().removeWeightedEdge(source,dest,weight);
                            break;
                        case 4:
                            System.out.print("Enter the node number: ");
                            node_num = scanner.nextInt();
                            s1.getConnectedG().removeNode(node_num);
                            break;

                        case 5:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");

                    }
                    break;
                case 2:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Breadth-First Traversal");
                    System.out.println("2. Depth-First Traversal");
                    System.out.println("3. Exit");
                    int taskC2 = scanner.nextInt();
                    switch(taskC2)
                    {
                        case 1:
                            System.out.print("Enter the start node of the Breadth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                            s1.getConnectedG().bfs(start_node);
                            break;
                        case 2:
                            System.out.print("Enter the start node of the Depth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                            s1.getConnectedG().dfs(start_node);
                            break;
                        case 3:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Which algorithm do you want to follow?");
                    System.out.println("1. Dijkstra Algorithm");
                    System.out.println("2. Exit");
                    int taskC3 = scanner.nextInt();
                    switch(taskC3)
                    {
                        case 1:DijkstraShortestPath dijkstra =new DijkstraShortestPath(s1.getConnectedG().GraphRepresentationList);
                        break;
                        case 2:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 4:
                    System.out.println("How do you want to view the graph?");
                    System.out.println("1. In Adjacency List");
                    System.out.println("2. Visual Representation");
                    System.out.println("3. Exit");
                    int taskC4 = scanner.nextInt();
                    switch(taskC4)
                    {
                        case 1:
                            s1.getConnectedG().GraphRepresentation();
                            break;
                        case 2:
                            SwingUtilities.invokeLater(() -> {
                                GraphVisualization visualRep = new GraphVisualization(s1.getConnectedG().GraphRepresentationList,false);
                            });
                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                    break;
                case 5:
                    System.out.println("Which algorithm do you want to follow?");
                    System.out.println("1.Kruskals Algorithm");
                    System.out.println("2.Prims Algorithm");
                    System.out.println("3. Exit");
                    int taskW5 = scanner.nextInt();
                    switch(taskW5)
                    {
                        case 1:
                            KruskalMST kruskalmst =new KruskalMST(s1.getConnectedG().GraphRepresentationList);

                            break;
                        case 2:
                            PrimsMST prims =new PrimsMST(s1.getConnectedG().GraphRepresentationList);

                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                    break;
                case 6:
                    MaxFlow maxFlow = new MaxFlow(s1.getConnectedG().GraphRepresentationList);
                    break;

                case 7:s1.getConnectedG().ConvertToDisconnected();
                    break;

                case 8:s1.getConnectedG().GraphDetails();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }



    public static void OperationDisconnected(Scanner scanner,Graph s1)
    {
        System.out.println("How many edges do you want to add?");
        int edge_num = scanner.nextInt();
        for(int i=0; i<edge_num;i++)
        {
            System.out.print("Enter the source, destination and weight of node: ");
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            int w = scanner.nextInt();
            s1.getDisconnected().addWeightedEdge(s,d,w);
        }

        while (true)
        {
            System.out.println("\n Which operation do you want to perform?");
            System.out.println("1. Graph Modifications");
            System.out.println("2. Graph Traversal");
            System.out.println("3. Graph Representation");
            System.out.println("4. Max flow");
            System.out.println("5. Graph Conversion");
            System.out.println("6. Graph Details");
            System.out.println("7. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int dest;
            int weight;
            int start_node;
            int node_num;
            switch (task)
            {
                case 1:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Add edge");
                    System.out.println("2. Add node");
                    System.out.println("3. Remove edge");
                    System.out.println("4. Remove node");

                    System.out.println("5. Exit");
                    int taskU1 = scanner.nextInt();
                    switch(taskU1)
                    {
                        case 1:
                            System.out.print("Enter the source, destination and weight of node: ");
                            int s = scanner.nextInt();
                            int d = scanner.nextInt();
                            int w = scanner.nextInt();
                            s1.getDisconnected().addWeightedEdge(s,d,w);
                            break;
                        case 2:
                            System.out.print("Enter the no. of node to be added: ");
                            node_num = scanner.nextInt();
                            s1.getDisconnected().addNode(node_num);
                            break;
                        case 3:
                            System.out.print("Enter the source, destination and weight of node: ");
                            source = scanner.nextInt();
                            dest = scanner.nextInt();
                            weight = scanner.nextInt();
                            s1.getDisconnected().removeWeightedEdge(source,dest,weight);
                            break;
                        case 4:
                            System.out.print("Enter the node number: ");
                            node_num = scanner.nextInt();
                            s1.getDisconnected().removeNode(node_num);
                            break;

                        case 5:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");

                    }
                    break;
                case 2:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Breadth-First Traversal");
                    System.out.println("2. Depth-First Traversal");
                    System.out.println("3. Exit");
                    int taskU2 = scanner.nextInt();
                    switch(taskU2)
                    {
                        case 1:
                            System.out.print("Enter the start node of the Breadth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                            s1.getDisconnected().bfs(start_node);
                            break;
                        case 2:
                            System.out.print("Enter the start node of the Depth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                            s1.getDisconnected().dfs(start_node);
                            break;
                        case 3:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");
                    }
                    break;

                case 3:
                    System.out.println("How do you want to view the graph?");
                    System.out.println("1. In Adjacency List");
                    System.out.println("2. Visual Representation");
                    System.out.println("3. Exit");
                    int taskU4 = scanner.nextInt();
                    switch(taskU4)
                    {
                        case 1:
                            s1.getDisconnected().GraphRepresentation();
                            break;
                        case 2:
                            SwingUtilities.invokeLater(() -> {
                                GraphVisualization visualRep = new GraphVisualization(s1.getDisconnected().GraphRepresentationList,false);
                            });
                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;


                case 4:
                    MaxFlow maxFlow = new MaxFlow(s1.getDisconnected().GraphRepresentationList);
                    break;

                case 5:
                    s1.getDisconnected().convertToConnected();
                    break;

                case 6:s1.getDisconnected().GraphDetails();
                    break;

                case 7:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }




    public static void OperationComplete(Scanner scanner,Graph s1)
    {
        System.out.println("How many edges do you want to add?");
        int edge_num = scanner.nextInt();
        for(int i=0; i<edge_num;i++)
        {
            System.out.print("Enter the source, destination and weight of node: ");
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            int w = scanner.nextInt();
            s1.getComplete().addWeightedEdge(s,d,w);
        }

        while (true)
        {
            System.out.println("\n Which operation do you want to perform?");
            System.out.println("1. Graph Modifications");
            System.out.println("2. Graph Traversal");
            System.out.println("3. Finding Shortest Path");
            System.out.println("4. Graph Representation");
            System.out.println("5. Minimum Spanning");
            System.out.println("6. Max flow");
            System.out.println("7. Graph Details");
            System.out.println("8. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int dest;
            int weight;
            int start_node;
            int node_num;
            switch (task)
            {
                case 1:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Add edge");
                    System.out.println("2. Add node");
                    System.out.println("3. Remove edge");
                    System.out.println("4. Remove node");
                    System.out.println("5. Exit");
                    int taskCC1 = scanner.nextInt();
                    switch(taskCC1)
                    {
                        case 1:
                            System.out.print("Enter the source, destination and weight of node: ");
                            int s = scanner.nextInt();
                            int d = scanner.nextInt();
                            int w = scanner.nextInt();
                            s1.getComplete().addWeightedEdge(s,d,w);
                            break;
                        case 2:
                            System.out.print("Enter the no. of node to be added: ");
                            node_num = scanner.nextInt();
                            s1.getComplete().addNode(node_num);
                            break;
                        case 3:
                            System.out.print("Enter the source, destination and weight of node: ");
                            source = scanner.nextInt();
                            dest = scanner.nextInt();
                            weight = scanner.nextInt();
                            s1.getComplete().removeWeightedEdge(source,dest,weight);
                            break;
                        case 4:
                            System.out.print("Enter the node number: ");
                            node_num = scanner.nextInt();
                            s1.getComplete().removeNode(node_num);
                            break;

                        case 5:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");

                    }
                    break;
                case 2:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Breadth-First Traversal");
                    System.out.println("2. Depth-First Traversal");
                    System.out.println("3. Exit");
                    int taskCC2 = scanner.nextInt();
                    switch(taskCC2)
                    {
                        case 1:
                            System.out.print("Enter the start node of the Breadth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                            s1.getComplete().bfs(start_node);
                            break;
                        case 2:
                            System.out.print("Enter the start node of the Depth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                            s1.getComplete().dfs(start_node);
                            break;
                        case 3:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Which algorithm do you want to follow?");
                    System.out.println("1. Dijkstra Algorithm");
                    System.out.println("2. Exit");
                    int taskCC3 = scanner.nextInt();
                    switch(taskCC3)
                    {
                        case 1:DijkstraShortestPath dijkstra =new DijkstraShortestPath(s1.getComplete().GraphRepresentationList);
                        break;
                        case 2:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 4:
                    System.out.println("How do you want to view the graph?");
                    System.out.println("1. In Adjacency List");
                    System.out.println("2. Visual Representation");
                    System.out.println("3. Exit");
                    int taskCC4 = scanner.nextInt();
                    switch(taskCC4)
                    {
                        case 1:
                            s1.getComplete().GraphRepresentation();
                            break;
                        case 2:
                            SwingUtilities.invokeLater(() -> {
                                GraphVisualization visualRep = new GraphVisualization(s1.getComplete().GraphRepresentationList,false);
                            });
                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 5:
                    System.out.println("Which algorithm do you want to follow?");
                    System.out.println("1.Kruskals Algorithm");
                    System.out.println("2.Prims Algorithm");
                    System.out.println("3. Exit");
                    int taskW5 = scanner.nextInt();
                    switch(taskW5)
                    {
                        case 1:
                            KruskalMST kruskalmst =new KruskalMST(s1.getComplete().GraphRepresentationList);

                            break;
                        case 2:
                            PrimsMST prims =new PrimsMST(s1.getComplete().GraphRepresentationList);
                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 6:
                    MaxFlow maxFlow = new MaxFlow(s1.getComplete().GraphRepresentationList);

                case 7:s1.getComplete().GraphDetails();
                    break;

                case 8:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }


    public static void OperationWeighted(Scanner scanner,Graph s1)
    {

        System.out.println("How many edges do you want to add?");
        int edge_num = scanner.nextInt();
        for(int i=0; i<edge_num;i++)
        {
            System.out.print("Enter the source, destination and weight of node: ");
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            int w = scanner.nextInt();
            s1.getWeighted().addWeightedEdge(s,d,w);
        }

        while (true)
        {
            System.out.println("\n Which operation do you want to perform?");
            System.out.println("1. Graph Modifications");
            System.out.println("2. Graph Traversal");
            System.out.println("3. Finding Shortest Path");
            System.out.println("4. Graph Representation");
            System.out.println("5. Minimum Spanning");
            System.out.println("6. Max flow");
            System.out.println("7.Graph Details");
            System.out.println("8. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int dest;
            int node_num;
            int weight;
            int start_node;
            switch (task)
            {
                case 1:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Add edge");
                    System.out.println("2. Add node");
                    System.out.println("3. Remove edge");
                    System.out.println("4. Remove node");
                    System.out.println("5. Exit");
                    int taskW1 = scanner.nextInt();
                    switch(taskW1)
                    {
                        case 1:
                            System.out.print("Enter the source, destination & weight: ");
                            int s = scanner.nextInt();
                            int d = scanner.nextInt();
                            int w = scanner.nextInt();
                            s1.getWeighted().addWeightedEdge(s,d,w);
                            break;
                        case 2:
                            System.out.print("Enter the no. of node to be added: ");
                            node_num = scanner.nextInt();
                            s1.getWeighted().addNode(node_num);
                            break;
                        case 3:
                            System.out.print("Enter the source, destination & weight: ");
                            source = scanner.nextInt();
                            dest = scanner.nextInt();
                            weight =scanner.nextInt();
                            s1.getWeighted().removeWeightedEdge(source,dest,weight);
                            break;
                        case 4:
                            System.out.print("Enter the node number: ");
                            node_num = scanner.nextInt();
                            s1.getWeighted().removeNode(node_num);
                            break;

                        case 5:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");

                    }
                    break;
                case 2:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Breadth-First Traversal");
                    System.out.println("2. Depth-First Traversal");
                    System.out.println("3. Exit");
                    int taskW2 = scanner.nextInt();
                    switch(taskW2)
                    {
                        case 1:
                            System.out.print("Enter the start node of the Breadth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                            s1.getWeighted().bfs(start_node);
                            break;
                        case 2:
                            System.out.print("Enter the start node of the Depth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                            s1.getWeighted().dfs(start_node);
                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Which algorithm do you want to follow?");
                    System.out.println("1. Dijkstra Algorithm");
                    System.out.println("2. Exit");
                    int taskW3 = scanner.nextInt();
                    switch(taskW3)
                    {
                        case 1:

                            DijkstraShortestPath dijkstra =new DijkstraShortestPath(s1.getWeighted().GraphRepresentationList);
                            break;

                        case 2:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 4:
                    System.out.println("How do you want to view the graph?");
                    System.out.println("1. In Adjacency List");
                    System.out.println("2. Visual Representation");
                    System.out.println("3. Exit");
                    int taskW4 = scanner.nextInt();
                    switch(taskW4)
                    {
                        case 1:
                            s1.getWeighted().GraphRepresentation();
                            break;
                        case 2:
                            SwingUtilities.invokeLater(() -> {
                                GraphVisualization visualRep = new GraphVisualization(s1.getWeighted().GraphRepresentationList,false);
                            });
                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                case 5:
                    System.out.println("Which algorithm do you want to follow?");
                    System.out.println("1.Kruskals Algorithm");
                    System.out.println("2.Prims Algorithm");
                    System.out.println("3. Exit");
                    int taskW5 = scanner.nextInt();
                    switch(taskW5)
                    {
                        case 1:
                            KruskalMST kruskalmst =new KruskalMST(s1.getWeighted().GraphRepresentationList);

                            break;
                        case 2:
                            PrimsMST prims =new PrimsMST(s1.getWeighted().GraphRepresentationList);

                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                case 6:
                    MaxFlow maxflow =new MaxFlow(s1.getWeighted().GraphRepresentationList);
                    break;

                case 7: s1.getWeighted().GraphDetails();
                    break;

                case 8:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }

    }



    public static void OperationAcyclic(Scanner scanner, Graph s1)
    {
        System.out.println("How many edges do you want to add?");
        int edge_num = scanner.nextInt();
        for(int i=0; i<edge_num;i++)
        {
            System.out.print("Enter the source, destination and weight of node: ");
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            int w = scanner.nextInt();
            s1.getAcyclic().addWeightedEdge(s,d,w);
        }

        while (true)
        {
            System.out.println("\n Which operation do you want to perform?");
            System.out.println("1. Graph Modifications");
            System.out.println("2. Graph Traversal");
            System.out.println("3. Finding Shortest Path");
            System.out.println("4. Graph Representation");
            System.out.println("5. Minimum Spanning");
            System.out.println("6. Max flow");
            System.out.println("7. Graph Conversion");
            System.out.println("8. Graph Details");
            System.out.println("9. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int dest;
            int weight;
            int start_node;
            int node_num;
            switch (task)
            {
                case 1:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Add edge");
                    System.out.println("2. Add node");
                    System.out.println("3. Remove edge");
                    System.out.println("4. Remove node");
                    System.out.println("5. Exit");
                    int taskA1 = scanner.nextInt();
                    switch(taskA1)
                    {
                        case 1:
                            System.out.print("Enter the source, destination and weight of node: ");
                            int s = scanner.nextInt();
                            int d = scanner.nextInt();
                            int w = scanner.nextInt();
                            s1.getAcyclic().addWeightedEdge(s,d,w);
                            break;
                        case 2:
                            System.out.print("Enter the no. of node to be added: ");
                            node_num = scanner.nextInt();
                            s1.getAcyclic().addNode(node_num);
                            break;
                        case 3:
                            System.out.print("Enter the source, destination and weight of node: ");
                            source = scanner.nextInt();
                            dest = scanner.nextInt();
                            weight = scanner.nextInt();
                            s1.getAcyclic().removeWeightedEdge(source,dest,weight);
                            break;
                        case 4:
                            System.out.print("Enter the node number: ");
                            node_num = scanner.nextInt();
                            s1.getAcyclic().removeNode(node_num);
                            break;

                        case 5:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");

                    }
                    break;
                case 2:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Breadth-First Traversal");
                    System.out.println("2. Depth-First Traversal");
                    System.out.println("3. Exit");
                    int taskA2 = scanner.nextInt();
                    switch(taskA2)
                    {
                        case 1:
                            System.out.print("Enter the start node of the Breadth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                            s1.getAcyclic().bfs(start_node);
                            break;
                        case 2:
                            System.out.print("Enter the start node of the Depth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                            s1.getAcyclic().dfs(start_node);
                            break;
                        case 3:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Which algorithm do you want to follow?");
                    System.out.println("1. Dijkstra Algorithm");
                    System.out.println("2. Exit");
                    int taskA3 = scanner.nextInt();
                    switch(taskA3)
                    {
                        case 1:
                            DijkstraShortestPath dijkstra =new DijkstraShortestPath(s1.getAcyclic().GraphRepresentationList);
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 4:
                    System.out.println("How do you want to view the graph?");
                    System.out.println("1. In Adjacency List");
                    System.out.println("2. Visual Representation");
                    System.out.println("3. Exit");
                    int taskA4 = scanner.nextInt();
                    switch(taskA4)
                    {
                        case 1:
                            s1.getAcyclic().GraphRepresentation();
                            break;
                        case 2:
                            SwingUtilities.invokeLater(() -> {
                                GraphVisualization visualRep = new GraphVisualization(s1.getAcyclic().GraphRepresentationList,false);
                            });
                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                    break;

                case 5:
                    System.out.println("Which algorithm do you want to follow?");
                    System.out.println("1.Kruskals Algorithm");
                    System.out.println("2.Prims Algorithm");
                    System.out.println("3. Exit");
                    int taskW5 = scanner.nextInt();
                    switch(taskW5)
                    {
                        case 1:
                            KruskalMST kruskalmst =new KruskalMST(s1.getAcyclic().GraphRepresentationList);

                            break;
                        case 2:
                            PrimsMST prims =new PrimsMST(s1.getAcyclic().GraphRepresentationList);

                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }


                    break;
                case 6:
                    MaxFlow maxFlow = new MaxFlow(s1.getAcyclic().GraphRepresentationList);
                    break;

                case 7:
                    s1.getAcyclic().convertToCyclic();
                    break;
                case 8: s1.getAcyclic().GraphDetails();
                    break;

                case 9:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }


    public static void OperationCyclic(Scanner scanner,Graph s1) {
        System.out.println("How many edges do you want to add?");
        int edge_num = scanner.nextInt();
        for (int i = 0; i < edge_num; i++) {
            System.out.print("Enter the source, destination and weight of node: ");
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            int w = scanner.nextInt();
            s1.getCyclic().addWeightedEdge(s, d, w);
        }

        while (true) {
            System.out.println("\n Which operation do you want to perform?");
            System.out.println("1. Graph Modifications");
            System.out.println("2. Graph Traversal");
            System.out.println("3. Finding Shortest Path");
            System.out.println("4. Graph Representation");
            System.out.println("5. Minimum Spanning");
            System.out.println("6. Max flow");
            System.out.println("7. Graph Conversion");
            System.out.println("8. Graph Details");
            System.out.println("9. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int dest;
            int weight;
            int start_node;
            int node_num;
            switch (task) {
                case 1:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Add edge");
                    System.out.println("2. Add node");
                    System.out.println("3. Remove edge");
                    System.out.println("4. Remove node");
                    System.out.println("5. Exit");
                    int taskCC1 = scanner.nextInt();
                    switch (taskCC1) {
                        case 1:
                            System.out.print("Enter the source, destination and weight of node: ");
                            int s = scanner.nextInt();
                            int d = scanner.nextInt();
                            int w = scanner.nextInt();
                            s1.getCyclic().addWeightedEdge(s, d, w);
                            break;
                        case 2:
                            System.out.print("Enter the no. of node to be added: ");
                            node_num = scanner.nextInt();
                            s1.getCyclic().addNode(node_num);
                            break;
                        case 3:
                            System.out.print("Enter the source, destination and weight of node: ");
                            source = scanner.nextInt();
                            dest = scanner.nextInt();
                            weight = scanner.nextInt();
                            s1.getCyclic().removeWeightedEdge(source, dest, weight);
                            break;
                        case 4:
                            System.out.print("Enter the node number: ");
                            node_num = scanner.nextInt();
                            s1.getCyclic().removeNode(node_num);
                            break;

                        case 5:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");

                    }
                    break;
                case 2:
                    System.out.println("Which operation do you want to perform?");
                    System.out.println("1. Breadth-First Traversal");
                    System.out.println("2. Depth-First Traversal");
                    System.out.println("3. Exit");
                    int taskCC2 = scanner.nextInt();
                    switch (taskCC2) {
                        case 1:
                            System.out.print("Enter the start node of the Breadth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Breadth First Traversal for the " + start_node + " is: ");
                            s1.getCyclic().bfs(start_node);
                            break;
                        case 2:
                            System.out.print("Enter the start node of the Depth First Traversal: ");
                            start_node = scanner.nextInt();
                            System.out.println("The Depth First Traversal for the " + start_node + " is: ");
                            s1.getCyclic().dfs(start_node);
                            break;
                        case 3:
                            return;
                        default:
                            System.out.println("Invalid operation choice. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Which algorithm do you want to follow?");
                    System.out.println("1. Dijkstra Algorithm");
                    System.out.println("2. Exit");
                    int taskCC3 = scanner.nextInt();
                    switch (taskCC3) {
                        case 1:DijkstraShortestPath dijkstra =new DijkstraShortestPath(s1.getCyclic().GraphRepresentationList);
                        break;
                        case 2:

                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 4:
                    System.out.println("How do you want to view the graph?");
                    System.out.println("1. In Adjacency List");
                    System.out.println("2. Visual Representation");
                    System.out.println("3. Exit");
                    int taskCC4 = scanner.nextInt();
                    switch (taskCC4) {
                        case 1:
                            s1.getCyclic().GraphRepresentation();
                            break;
                        case 2:
                            SwingUtilities.invokeLater(() -> {
                                GraphVisualization visualRep = new GraphVisualization(s1.getCyclic().GraphRepresentationList,false);
                            });
                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 5:
                    System.out.println("Which algorithm do you want to follow?");
                    System.out.println("1.Kruskals Algorithm");
                    System.out.println("2.Prims Algorithm");
                    System.out.println("3. Exit");
                    int taskW5 = scanner.nextInt();
                    switch(taskW5)
                    {
                        case 1:
                            KruskalMST kruskalmst =new KruskalMST(s1.getCyclic().GraphRepresentationList);

                            break;
                        case 2:
                            PrimsMST prims =new PrimsMST(s1.getCyclic().GraphRepresentationList);

                            break;

                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;


                case 6:
                    MaxFlow maxFlow = new MaxFlow(s1.getCyclic().GraphRepresentationList);
                    break;

                case 7:
                    s1.getCyclic().convertToAcyclic();
                    break;
                case 8:
                    s1.getCyclic().GraphDetails();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }

    }

}





