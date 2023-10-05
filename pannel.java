package ship2ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class pannel extends JPanel implements ActionListener {
	Timer t;
	Action upPressedAction;
	Action upReleasedAction;
	Action leftPressedAction;
	Action leftReleasedAction;
	Action rightPressedAction;
	Action rightReleasedAction;
	Action downPressedAction;
	Action downReleasedAction;
	boolean forward, left, right, slow;
	Action shootAction;
	ArrayList<drawable> draw;
	ArrayList<updatable> update;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (drawable d : draw) {
			d.draw(g);
		}
	}

	public void actionPerformed(ActionEvent e) {
		for (updatable u : update)
			u.update();
		repaint();
	}
	public pannel() {
		t = new Timer(35, this);

		//adding key bindings
		upPressedAction = new upPressedAction();
		upReleasedAction = new upReleasedAction();
		shootAction = new shootAction();
		leftPressedAction = new leftPressedAction();
		leftReleasedAction = new leftReleasedAction();
		rightPressedAction = new rightPressedAction();
		rightReleasedAction = new rightReleasedAction();
		downPressedAction = new downPressedAction();
		downReleasedAction = new downReleasedAction();
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed W"), "forward");
		this.getInputMap().put(KeyStroke.getKeyStroke("released W"), "StopF");
		this.getActionMap().put("forward", upPressedAction);
		this.getActionMap().put("StopF", upReleasedAction);
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed A"), "left");;
		this.getInputMap().put(KeyStroke.getKeyStroke("released A"), "StopL");
		this.getActionMap().put("left", leftPressedAction);
		this.getActionMap().put("StopL", leftReleasedAction);
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed D"), "right");
		this.getInputMap().put(KeyStroke.getKeyStroke("released D"), "StopR");
		this.getActionMap().put("right", rightPressedAction);
		this.getActionMap().put("StopR", rightReleasedAction);
		this.getInputMap().put(KeyStroke.getKeyStroke(' '), "shoot");
		this.getActionMap().put("shoot", shootAction);
	}



	public class upPressedAction extends AbstractAction
	{
		public void actionPerformed(ActionEvent e)
		{
			forward = true;
		}
	}
	public class downPressedAction extends AbstractAction
	{
		public void actionPerformed(ActionEvent e)
		{
			slow = true;
		}
	}
	public class downReleasedAction extends AbstractAction
	{
		public void actionPerformed(ActionEvent e)
		{
			slow = false;
		}
	}
	public class upReleasedAction extends AbstractAction
	{
		public void actionPerformed(ActionEvent e)
		{
			forward = false;
		}
	}
	public class leftPressedAction extends AbstractAction
	{
		public void actionPerformed(ActionEvent e)
		{
			left = true;
		}
	}
	public class leftReleasedAction extends AbstractAction
	{
		public void actionPerformed(ActionEvent e)
		{
			left = false;
		}
	}
	public class rightPressedAction extends AbstractAction
	{
		public void actionPerformed(ActionEvent e)
		{
			right = true;
		}
	}
	public class rightReleasedAction extends AbstractAction
	{
		public void actionPerformed(ActionEvent e)
		{
			right = false;
		}
	}
	public class shootAction extends AbstractAction
	{
		public void actionPerformed(ActionEvent e)
		{
//			m.addBullet(p.shoot());
		}
	}
}
