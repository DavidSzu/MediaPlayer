package gui;

import main.Main;

import java.awt.Color;
import java.awt.MenuBar;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import controller.Listener;
import model.FileHandler;

import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Mainframe extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 1000;
	private final int HEIGHT = 800;
	private JPanel contentPane;
	Listener listener = new Listener();
	final JFileChooser fc = new JFileChooser();
	JPanel mainPanel;
	JPanel panelNorth;
	
	JButton btnBackward;
	JButton btnStartStop;
	JButton btnForward;
	
	JMenuBar menuBar;
	JMenu mnFileMenu;
	JMenuItem mntmOpen;
	JMenu mnTitelMenu;
	
	
//	private ArrayList<Object> fileList;
//	private String path = "/Users/David/Music/iTunes/iTunes Media/Music/AC:DC/AC_DC Live_ Collector's Edition [Disc 1]";
//	

	public void run()
	{
		try
		{
			Main.setMf(Main.getMf());
			//Mainframe frame = Main.getMf();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Mainframe() throws IOException
	{
		
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WIDTH, HEIGHT);
		setTitle("Media Player");
		setResizable(true);
		setVisible(true);
		
//		Panels:
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
//		contentPane.setSize(getMaximumSize());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 100, 984, 661);
		mainPanel.setOpaque(false);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		panelNorth = new JPanel();
		panelNorth.setBounds(0, 0, 984, 100);
		panelNorth.setOpaque(false);
		contentPane.add(panelNorth);
		panelNorth.setLayout(null);

		
		Listener listener = new Listener();
		
		//Buttons:
		setBtnBackward(new JButton("Backward"));
		getBtnBackward().setBounds(250, 39, 95, 40);
		getBtnBackward().addActionListener(listener);
		panelNorth.add(getBtnBackward());
		
		setBtnStartStop(new JButton("Start"));
		getBtnStartStop().setBounds(450, 39, 95, 40);
		getBtnStartStop().addActionListener(listener);
		panelNorth.add(getBtnStartStop());
		
		setBtnForward(new JButton("Forward"));
		getBtnForward().setBounds(650, 39, 95, 40);
		getBtnForward().addActionListener(listener);
		panelNorth.add(getBtnForward());
		
		
		//Menus:
		menuBar = new JMenuBar();
		getJMenuBar().setBounds(0, 0, 984, 21);
		
		setMnFileMenu(new JMenu("File"));
		getJMenuBar().add(getMnFileMenu());
		
		setMntmOpen(new JMenuItem("Open"));
		getMnFileMenu().add(getMntmOpen());
		getMntmOpen().addActionListener(listener);
		
		setMnTitelMenu(new JMenu("Titel"));
		getJMenuBar().add(getMnTitelMenu());
		
		panelNorth.add(getJMenuBar());
		panelNorth.repaint();


		
		
//		JList<Object> mediaList = new JList<Object>(FileHandler.readFile(path, StandardCharsets.UTF_8).toArray());
//		mediaList.setBackground(Color.DARK_GRAY);
//		mediaList.setBounds(0, 0, 984, 661);
//		mediaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		mainPanel.add(mediaList);
//		
//		
	}


	public JButton getBtnBackward()
	{
		return btnBackward;
	}
	public void setBtnBackward(JButton btnBackward)
	{
		this.btnBackward = btnBackward;
	}


	public JButton getBtnStartStop()
	{
		return btnStartStop;
	}
	public void setBtnStartStop(JButton btnStartStop)
	{
		this.btnStartStop = btnStartStop;
	}


	public JButton getBtnForward()
	{
		return btnForward;
	}
	public void setBtnForward(JButton btnForward)
	{
		this.btnForward = btnForward;
	}


	public JMenuBar getJMenuBar()
	{
		return menuBar;
	}
	public void setJMenuBar(JMenuBar menuBar)
	{
		this.menuBar = menuBar;
	}


	public JMenu getMnFileMenu()
	{
		return mnFileMenu;
	}
	public void setMnFileMenu(JMenu mnFileMenu)
	{
		this.mnFileMenu = mnFileMenu;
	}


	public JMenuItem getMntmOpen()
	{
		return mntmOpen;
	}
	public void setMntmOpen(JMenuItem mntmOpen)
	{
		this.mntmOpen = mntmOpen;
	}


	public JMenu getMnTitelMenu()
	{
		return mnTitelMenu;
	}
	public void setMnTitelMenu(JMenu mnTitelMenu)
	{
		this.mnTitelMenu = mnTitelMenu;
	}
}
