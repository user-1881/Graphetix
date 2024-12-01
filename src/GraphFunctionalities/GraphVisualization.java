package GraphFunctionalities;

import javax.swing.*;
import java.awt.*;
import CustomUtilityFunctions.CustomLinkedList;

public class GraphVisualization extends JFrame {
    private final int radius = 20;  // Radius of the vertex circle
    private final int vertexDiameter = 2 * radius;
    public CustomLinkedList<int[]>[] graph;
    public boolean isDirected;

    public GraphVisualization(CustomLinkedList<int[]>[] GraphRepresentationList, boolean isDirected) {

        this.graph = GraphRepresentationList;
        this.isDirected = isDirected;

        // Set up JFrame
        setTitle("GraphDelegator.Graph Visual Representation");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add GraphPanel to JFrame
        GraphPanel graphPanel = new GraphPanel();
        add(graphPanel);

        // Set the JFrame to be visible
        setVisible(true);
    }



    private class GraphPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawVertices(g);
            drawEdges(g);
        }

        private void drawVertices(Graphics g) {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int panelRadius = Math.min(centerX, centerY) - vertexDiameter;

            Font labelFont = new Font("Arial", Font.BOLD, 16);  // Change "Default" to your preferred font
            g.setFont(labelFont);

            for (int i = 0; i < graph.length; i++) {
                double angle = 2 * Math.PI * i / graph.length;
                int x = centerX + (int) (panelRadius * Math.cos(angle)) - radius;
                int y = centerY + (int) (panelRadius * Math.sin(angle)) - radius;

                // Draw vertex
                g.setColor(Color.GREEN);
                g.fillOval(x, y, vertexDiameter, vertexDiameter);

                // Draw vertex label
                g.setColor(Color.BLACK);
                g.drawString(Integer.toString(i), x + radius, y + radius);
            }
        }

        private void drawEdges(Graphics g) {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int panelRadius = Math.min(centerX, centerY) - vertexDiameter;

            for (int i = 0; i < graph.length; i++) {
                double angle1 = 2 * Math.PI * i / graph.length;
                int x1 = centerX + (int) (panelRadius * Math.cos(angle1));
                int y1 = centerY + (int) (panelRadius * Math.sin(angle1));

                CustomLinkedList<int[]> neighbors = graph[i];
                for (int j = 0; j < neighbors.length(); j++) {
                    int[] edge = neighbors.get(j);

                    if (i == edge[0]) { // Self-loop
                        g.setColor(Color.BLUE);
                        int loopDiameter = 3 * radius;
                        int loopX = x1 - loopDiameter / 2;
                        int loopY = y1 - loopDiameter / 2;
                        g.drawOval(loopX, loopY, loopDiameter, loopDiameter);
                    }
                    else
                    {
                        double angle2 = 2 * Math.PI * edge[0] / graph.length;
                        int x2 = centerX + (int) (panelRadius * Math.cos(angle2));
                        int y2 = centerY + (int) (panelRadius * Math.sin(angle2));

                        // Draw edge
                        g.setColor(Color.BLUE);
                        g.drawLine(x1, y1, x2, y2);

                        // Draw weight
                        if (edge.length > 1  && edge[1] !=0) {
                            g.setColor(Color.BLACK);
                            int labelX = (int) (x1 + 0.3 * (x2 - x1));
                            int labelY = (int) (y1 + 0.3 * (y2 - y1));
                            if (i < edge[0]) {
                                g.drawString(Integer.toString(edge[1]), labelX, labelY);
                            }
                        }

                        if (isDirected)
                        {
                            drawArrowHead(g, x1, y1, x2, y2);
                        }
                    }
                }
            }
        }


        private void drawArrowHead(Graphics g, int x1, int y1, int x2, int y2) {
            g.setColor(Color.BLUE);
            int arrowSize = 8;
            int dx = x2 - x1, dy = y2 - y1;
            double D = Math.sqrt(dx * dx + dy * dy);
            double sin = dy / D, cos = dx / D;
            double xd = x2 - cos * radius;
            double yd = y2 - sin * radius;


            drawArrow(g, xd, yd, x2, y2, arrowSize);
        }

        private void drawArrow(Graphics g, double x0, double y0, double x1, double y1, int size) {
            double dx = x1 - x0, dy = y1 - y0;
            double D = Math.sqrt(dx * dx + dy * dy);
            double xm = D - size, xn = xm, ym = size, yn = -size, x;
            double sin = dy / D, cos = dx / D;

            x = xm * cos - ym * sin + x0;
            ym = xm * sin + ym * cos + y0;
            xm = x;

            x = xn * cos - yn * sin + x0;
            yn = xn * sin + yn * cos + y0;
            xn = x;

            int[] xPoints = {(int) x1, (int) xm, (int) xn};
            int[] yPoints = {(int) y1, (int) ym, (int) yn};

            g.drawPolygon(xPoints, yPoints, 3);
        }

    }
}

