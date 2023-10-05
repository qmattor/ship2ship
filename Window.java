package ship2ship;

import javax.swing.*;

public class Window extends JFrame{

	public Window()
	{
		super("Ship2Ship");
		pannel p = new pannel();
		this.setSize(750, 750);
		this.setLayout(null);
		this.setResizable(false);
		this.setContentPane(p);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String args[])
	{
		Window w = new Window();
	}
}
