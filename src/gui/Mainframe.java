package gui;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Listener;
import main.Main;
import model.PlayerFunctions;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JList;

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
	JPanel panelSouth;
	
	JButton btnBackward;
	JButton btnStartPause;
	JButton btnForward;
	JButton btnStop;
	JButton btnShuffle;
	
	JMenuBar menuBar;
	JMenu mnFileMenu;
	JMenuItem mntmOpen;
	JMenu mnTitelMenu;
	PlayerFunctions pf;
	
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
		mainPanel.setBounds(0, 21, 984, 740);
		mainPanel.setOpaque(false);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		panelSouth = new JPanel();
		panelSouth.setBounds(0, 640, 984, 100);
		mainPanel.add(panelSouth);
		panelSouth.setOpaque(false);
		panelSouth.setLayout(null);
		
		//Buttons:
		setBtnBackward(new JButton("Backward"));
		getBtnBackward().setBounds(110, 39, 95, 40);
		getBtnBackward().addActionListener(listener);
		panelSouth.add(getBtnBackward());
		
		setBtnStartPause(new JButton("Start"));
		getBtnStartPause().setBounds(450, 39, 95, 40);
		getBtnStartPause().addActionListener(listener);
		panelSouth.add(getBtnStartPause());
		
		setBtnForward(new JButton("Forward"));
		getBtnForward().setBounds(610, 39, 95, 40);
		getBtnForward().addActionListener(listener);
		panelSouth.add(getBtnForward());
		
		setBtnStop(new JButton("Stop"));
		getBtnStop().setBounds(279, 39, 95, 40);
		getBtnStop().addActionListener(listener);
		panelSouth.add(getBtnStop());
		
		setBtnShuffle(new JButton("Shuffle"));
		getBtnShuffle().setBounds(770, 39, 95, 40);
		getBtnShuffle().addActionListener(listener);
		panelSouth.add(getBtnShuffle());
		
		//Miscellaneous:
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 615, 964, 14);
		mainPanel.add(progressBar);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(967, 11, 17, 593);
		mainPanel.add(scrollBar);
		
		JList mediaList = new JList();
		mediaList.setBounds(10, 595, 937, -583);
		mainPanel.add(mediaList);
		
		
		//Menus:
		setJMenuBar(new JMenuBar());
		getJMenuBar().setBounds(0, 0, 984, 21);
		contentPane.add(menuBar);
		
		setMnFileMenu(new JMenu("File"));
		getJMenuBar().add(getMnFileMenu());
		
		setMntmOpen(new JMenuItem("Open"));
		getMnFileMenu().add(getMntmOpen());
		getMntmOpen().addActionListener(listener);
		
		setMnTitelMenu(new JMenu("Titel"));
		getJMenuBar().add(getMnTitelMenu());
		
		getJMenuBar().repaint();
	}


	private JButton getBtnShuffle()
	{
		return btnShuffle;
	}
	private void setBtnShuffle(JButton btnShuffle)
	{
		this.btnShuffle = btnShuffle;
	}
	

	private JButton getBtnStop()
	{
		return btnStop;
	}
	private void setBtnStop(JButton btnStop)
	{
		this.btnStop = btnStop;
	}

	
	public JButton getBtnBackward()
	{
		return btnBackward;
	}
	public void setBtnBackward(JButton btnBackward)
	{
		this.btnBackward = btnBackward;
	}


	public JButton getBtnStartPause()
	{
		return btnStartPause;
	}
	public void setBtnStartPause(JButton btnStartPause)
	{
		this.btnStartPause = btnStartPause;
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
