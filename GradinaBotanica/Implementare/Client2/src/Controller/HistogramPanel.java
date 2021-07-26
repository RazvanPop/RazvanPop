package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class HistogramPanel extends JPanel 
{
	public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
                createAndShowGUI1();
                createAndShowGUI2();
            }
        });
    }
	
	
	
    private int histogramHeight = 200;
    private int barWidth = 50;
    private int barGap = 10;

    private JPanel barPanel;
    private JPanel labelPanel;

    private ArrayList<Bar> bars = new ArrayList<Bar>();

    public HistogramPanel()
    {
        setBorder( new EmptyBorder(10, 10, 10, 10) );
        setLayout( new BorderLayout() );

        barPanel = new JPanel( new GridLayout(1, 0, barGap, 0) );
        Border outer = new MatteBorder(1, 1, 1, 1, Color.BLACK);
        Border inner = new EmptyBorder(10, 10, 0, 10);
        Border compound = new CompoundBorder(outer, inner);
        barPanel.setBorder( compound );

        labelPanel = new JPanel( new GridLayout(1, 0, barGap, 0) );
        labelPanel.setBorder( new EmptyBorder(5, 10, 0, 10) );

        add(barPanel, BorderLayout.CENTER);
        add(labelPanel, BorderLayout.PAGE_END);
    }

    public void addHistogramColumn(String label, int value, Color color)
    {
        Bar bar = new Bar(label, value, color);
        bars.add( bar );
    }

    public void layoutHistogram()
    {
        barPanel.removeAll();
        labelPanel.removeAll();

        int maxValue = 0;

        for (Bar bar: bars)
            maxValue = Math.max(maxValue, bar.getValue());

        for (Bar bar: bars)
        {
            JLabel label = new JLabel(bar.getValue() + "");
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.TOP);
            label.setVerticalAlignment(JLabel.BOTTOM);
            int barHeight = (bar.getValue() * histogramHeight) / maxValue;
            Icon icon = new ColorIcon(bar.getColor(), barWidth, barHeight);
            label.setIcon( icon );
            barPanel.add( label );

            JLabel barLabel = new JLabel( bar.getLabel() );
            barLabel.setHorizontalAlignment(JLabel.CENTER);
            labelPanel.add( barLabel );
        }
    }

    private class Bar
    {
        private String label;
        private int value;
        private Color color;

        public Bar(String label, int value, Color color)
        {
            this.label = label;
            this.value = value;
            this.color = color;
        }

        public String getLabel()
        {
            return label;
        }

        public int getValue()
        {
            return value;
        }

        public Color getColor()
        {
            return color;
        }
    }

    private class ColorIcon implements Icon
    {
        private int shadow = 3;

        private Color color;
        private int width;
        private int height;

        public ColorIcon(Color color, int width, int height)
        {
            this.color = color;
            this.width = width;
            this.height = height;
        }

        public int getIconWidth()
        {
            return width;
        }

        public int getIconHeight()
        {
            return height;
        }

        public void paintIcon(Component c, Graphics g, int x, int y)
        {
            g.setColor(color);
            g.fillRect(x, y, width - shadow, height);
            g.setColor(Color.GRAY);
            g.fillRect(x + width - shadow, y + shadow, shadow, height - shadow);
        }
    }

    private static void createAndShowGUI()
    {
        HistogramPanel panel = new HistogramPanel();
        panel.addHistogramColumn("rosaceae", 30, Color.RED);
        panel.addHistogramColumn("liliacee", 10, Color.YELLOW);
        panel.addHistogramColumn("asteraceae", 10, Color.BLUE);
        panel.addHistogramColumn("droseraceae", 10, Color.RED);
        panel.addHistogramColumn("stylidiaceae", 10, Color.YELLOW);
        panel.addHistogramColumn("sarraceniaceae", 10, Color.BLUE);
        panel.addHistogramColumn("nymphaea", 10, Color.RED);
        panel.addHistogramColumn("monocotiledonate", 10, Color.YELLOW);
        panel.addHistogramColumn("caryophyllales", 10, Color.BLUE);
 
        panel.layoutHistogram();

        JFrame frame = new JFrame("Statistici Gradina Botanica-TIP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( panel );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    private static void createAndShowGUI1()
    {
        HistogramPanel panel = new HistogramPanel();
        panel.addHistogramColumn("plantae", 100, Color.GREEN);
        
        panel.layoutHistogram();

        JFrame frame = new JFrame("Statistici Gradina Botanica-SPECIE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( panel );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }
    
    private static void createAndShowGUI2()
    {
        HistogramPanel panel = new HistogramPanel();
        panel.addHistogramColumn("nord", 25, Color.MAGENTA);
        panel.addHistogramColumn("sud", 25, Color.CYAN);
        panel.addHistogramColumn("est", 25, Color.PINK);
        panel.addHistogramColumn("vest", 25, Color.GRAY);
        
        panel.layoutHistogram();

        JFrame frame = new JFrame("Statistici Gradina Botanica-ZONA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( panel );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

}