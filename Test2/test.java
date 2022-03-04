
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.xml.transform.Templates;

public class test extends JComponent{
    
    private double[] points = new double[6];
	private int index = 0;
	private int movepointX = -1;
	private int movepointY = -1;
    private JButton[] colors;

    public static void main(String args[])
	{
		JFrame window = new JFrame("GUI App");
		window.setBounds(200, 200, 500, 750);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setLayout(null);
		
		JButton red = new JButton("");
		red.setBounds(200, 30, 50, 30);
        red.setBackground(Color.RED);
		window.add(red);

        window.repaint();
    }


    public test(){
       
		setBackground(Color.WHITE);
		addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				if(movepointX != -1 && movepointY != -1) {
					points[movepointX] = e.getX();
					points[movepointY] = e.getY();	
					repaint();
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				
			}
			
		});
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(index <points.length)
				{
					points[index] = e.getX();
					points[index+1] = e.getY();
					index += 2;
					repaint();
				}
			}

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
}

    public void paint(Graphics g)
	{
        
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(getBackground());
		g2d.fillRect(getBounds().x, getBounds().y, getBounds().width,
				getBounds().height);
        if(index > 0)
		{
            for(int i = 0; i<index; i+=2)
			{
				g2d.setColor(Color.RED);
				Ellipse2D ellipse = new Ellipse2D.Double(points[i]-5, points[i+1]-5, 5, 5);
				g2d.draw(ellipse);
				g2d.fill(ellipse);
				
				
			}
			for(int i = 0;  i <index-2; i+=2){
				g2d.setColor(Color.BLACK);
				Line2D line1 = new Line2D.Double(points[i], points[i+1], points[i+2], points[i+3]);
                Line2D line2 = new Line2D.Double(points[i], points[i+1], points[i+2], points[i+3]);
                Line2D line3 = new Line2D.Double(points[i], points[i+1], points[i+2], points[i+3]);
				g2d.draw(line1);
                g2d.draw(line2);
                g2d.draw(line3);
				}
		}	
	}
    
}
