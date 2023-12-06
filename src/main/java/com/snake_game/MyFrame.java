package com.snake_game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serial;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 *
 * @code Load the game and refresh it constantly
 * @author Sigurður Sigurðardóttir
 * @version Not sure
 */ 


public class MyFrame extends JPanel implements KeyListener
{
	@Serial
	private static final long serialVersionUID = -3149926831770554380L;

	public JFrame jFrame = new JFrame();

	public MyFrame()
	{
		jFrame.setIconImage(GameUtil.getImage("snake-logo.png"));
	}

	public void loadFrame()
	{
		/*
		 * Prevent the image from flashing.
		 */
		this.setDoubleBuffered(true);
		jFrame.add(this);
		jFrame.addKeyListener(this);

		jFrame.setTitle("Snake Game");
		jFrame.setSize(870, 560);
		jFrame.setLocationRelativeTo(null);
		jFrame.addWindowListener(new WindowAdapter()// close
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				System.exit(0);
			}
		});
		jFrame.setVisible(true);

		new MyThread().start();
	}
	class MyThread extends Thread
	{
		@Override
		public void run()
		{
			super.run();
			while (true)
			{
				repaint();
				try
				{
					sleep(30);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

}
