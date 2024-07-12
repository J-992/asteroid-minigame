
//imports libraries
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

//imports libraries for part 2

//creates a new window
@SuppressWarnings("serial")
public class AsteroidFramePart1 extends JFrame implements ActionListener, MouseMotionListener {

	// creates variables to hold images
	JLabel background = new JLabel(new ImageIcon("images/space.jpg"));
	JLabel asteroid = new JLabel(new ImageIcon("images/asteroid.gif"));
	JLabel saucer = new JLabel(new ImageIcon("images/saucer.gif"));

	// creates a timer
	Timer gameTimer = new Timer(10, this);

	//
	int dx = -5;
	int dy = -2;

	// constructor method
	public AsteroidFramePart1() {

		// makes sure the window can't be resized
		setResizable(false);

		// sets size
		setSize(500, 500);
		setTitle("Asteroid Game - Jaffer");

		// makes sure there is no layout applied
		background.setLayout(null);

		// sets boundary of asteroid (x, y, width, height)
		asteroid.setBounds(200, 100, 40, 40);

		// adds the asteroid to the background
		background.add(asteroid);

		// adds the saucer to the background (x, y, width, height)
		saucer.setBounds(300, 420, 20, 10);
		background.add(saucer);

		// sets the background
		add(background);

		// starts the game timer
		gameTimer.start();

		// tracks mouse movement
		addMouseMotionListener(this);

		// makes it visible
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		//
		asteroid.setBounds(asteroid.getX() + dx, asteroid.getY() + dy, 50, 50);

		// left wall
		if (asteroid.getX() < 0)
			dx = -dx;

		// top wall
		if (asteroid.getY() < 10)
			dy = -dy;

		// right wall
		if (asteroid.getX() > this.getWidth() - asteroid.getWidth())
			dx = -dx;

		// bottom wall
		if (asteroid.getY() > this.getHeight() - asteroid.getHeight())
			dy = -dy;

		if (asteroid.getBounds().intersects(saucer.getBounds()))
			dy = -5;
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(e -> System.exit(0));
		
		


	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent mouse) {
		// x, y, width, height
		saucer.setBounds(mouse.getX(), 400, 60, 55);

	}
	
        
    

}
