import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game extends JComponent implements KeyListener, ActionListener{

	public Player p1, p2;
	public static JFrame frame; 
	public int paddle_lenght = 90;
	
	public int ball_size = 25;
	public int ball_x = 500;
	public int ball_y = 250;
	public Timer timer;
	
	public boolean ball_goes_right = true;
	
	public Game() {
		JLabel p1_score = new JLabel("P1 score");
		JLabel p2_score = new JLabel("P2 score");
		
		// PLayer 1
		p1 = new Player(40, frame.getHeight()/2);
		// Player 2
		p2 = new Player(frame.getWidth()-80, frame.getHeight()/2);
		
		frame.addKeyListener(this);
		frame.setFocusable(true);
		
		// Timer
		timer = new Timer(50, this);
		timer.start();
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// paddles
		g.fillRect(p1.getX_pos(), p1.getY_pos(), 20, paddle_lenght);
		g.fillRect(p2.getX_pos(), p2.getY_pos(), 20, paddle_lenght);
		// ball
		g.fillOval(ball_x, ball_y, ball_size, ball_size);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(ball_goes_right == true) {
			ball_x = ball_x + 10;
			//top part
				//ball_y position
			// bottom part 
			// center
			if (ball_x >= p2.getX_pos() && ball_y>= p2.getY_pos() && ball_y <= p2.getY_pos() + paddle_lenght) {
				ball_x = ball_x - 10;
				ball_goes_right = false;
			}
		}
		else {
			ball_x = ball_x - 10;
			
			if (ball_x <= p1.getX_pos() && ball_y>= p1.getY_pos() && ball_y <= p1.getY_pos() + paddle_lenght) {
				ball_x = ball_x + 10;
				ball_goes_right = true;
			}
			
		}
		repaint();
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

	    if (key == KeyEvent.VK_UP) {
	    	if((p1.getY_pos() >= 0)) {
	    		p1.setY_pos(p1.getY_pos() - 10);
	    	}
	    }
	    else if (key == KeyEvent.VK_DOWN) {
	    	if((p1.getY_pos() < getHeight() - paddle_lenght)) {
	    		p1.setY_pos(p1.getY_pos() + 10);
	    	}
	    }
	    else if (key == KeyEvent.VK_W) {
	    	if((p2.getY_pos() >= 0) ) {
	    		p2.setY_pos(p2.getY_pos() - 10);
	    	}
	    	
	    }
	    else if (key == KeyEvent.VK_S) {
	    	if((p2.getY_pos() < getHeight() - paddle_lenght)) {
	    		p2.setY_pos(p2.getY_pos() + 10);
	    	}
	    }
	    
	    repaint();
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public static void main(String[] args) {
		frame = new JFrame("Pong");
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.add(new Game());
		
	}


	

	

	
}


