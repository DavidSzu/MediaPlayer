package gui;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import controller.Listener;
import main.Main;
import model.FileHandler;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class Mainframe extends JFrame
{
	// ---------------------------------------------------
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Listener listener = new Listener();
	private JPanel mainPanel;
	private JPanel panelControlButtons;

	private JButton btnBackward;
	private JButton btnStartPause;
	private JButton btnForward;
	private JButton btnStop;
	private JButton btnShuffle;
	private JButton btnRepeatLoop;

	private JMenuBar menuBar;
	private JMenu mnFileMenu;
	private JMenuItem menuItemOpen;
	private JMenu mnTitelMenu;

	private JLabel lblTrackProgress;
	private JLabel lblTrackDuration;

	private DefaultListModel<String> listModel;
	private JList<File> mediaList;

	private JPanel panelSouth;
	private JProgressBar progressBar;
	
    private static String[] intervList = 
	{
		"0: r. Prime/v. Sekunde", 
		"1: ü. Prime/kl. Sekunde", 
		"2: gr. Sekunde/v. Terz",
		"3: ü. Sekunde/kl. Terz",
		"4: gr. Terz/v. Quart",
		"5: ü. Terz/r. Quart",
		"6: ü. Quart/v. Quinte",
		"7: r. Quinte/v. Sexte",
		"8: ü. Quinte/kl. Sexte",
		"9: gr. Sexte/v. Septime",
		"10: ü. Sexte/kl. Septime",
		"11: gr. Septime/v. Oktave",
		"12: ü. Septime/r.Oktave"
	};
    private static ArrayList<String> arrList = new ArrayList<String>();

	// ---------------------------------------------------
	public void run()
	{
		try
		{
			Main.setMf(Main.getMf());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// ---------------------------------------------------
	// ---------------------------------------------------
	// Constructor:
	public Mainframe() throws IOException {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 740);
		setTitle("Media Player");
		setResizable(true);

		// ---------------------------------------------------
		// Panels:
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setBounds(0, 21, 984, 697);
		mainPanel.setOpaque(false);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);

		panelSouth = new JPanel();
		panelSouth.setBounds(0, 649, 984, 49);
		mainPanel.add(panelSouth);
		panelSouth.setBackground(Color.LIGHT_GRAY);
		panelSouth.setLayout(null);
		// mainPanel.setLayout();

		panelControlButtons = new JPanel();
		panelSouth.add(panelControlButtons);
		panelControlButtons.setBounds(0, 5, 984, 39);
		panelControlButtons.setForeground(Color.LIGHT_GRAY);
		panelControlButtons.setBackground(Color.LIGHT_GRAY);
		panelControlButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// ---------------------------------------------------
		// Buttons:
		setBtnBackward(new JButton("Backward"));
		getBtnBackward().addActionListener(listener);

		setBtnShuffle(new JButton("Enable Shuffle"));
		getBtnShuffle().addActionListener(listener);
		panelControlButtons.add(getBtnShuffle());
		panelControlButtons.add(getBtnBackward());

		setBtnForward(new JButton("Forward"));
		getBtnForward().addActionListener(listener);

		setBtnStartPause(new JButton("Start"));
		getBtnStartPause().addActionListener(listener);
		panelControlButtons.add(getBtnStartPause());
		panelControlButtons.add(getBtnForward());

		setBtnStop(new JButton("Stop"));
		getBtnStop().addActionListener(listener);
		panelControlButtons.add(getBtnStop());

		setBtnRepeatloop(new JButton("Loop off"));
		getBtnRepeatloop().addActionListener(listener);
		panelControlButtons.add(btnRepeatLoop);

		// ---------------------------------------------------
		// Miscellaneous:
		setLblTrackProgress(new JLabel("--:--"));

		progressBar = new JProgressBar();
		panelControlButtons.add(progressBar);

		setLblTrackDuration(new JLabel("--:--"));

		// ---------------------------------------------------
		// Menus:
		menuBar = new JMenuBar();
		getJMenuBar().setBounds(0, 0, 985, 21);
		contentPane.add(menuBar);

		setMnFileMenu(new JMenu("File"));
		getJMenuBar().add(getMenuFileMenu());

		setMntmOpen(new JMenuItem("Open"));
		getMenuFileMenu().add(getMenuItemOpen());
		getMenuItemOpen().addActionListener(listener);

		setMnTitelMenu(new JMenu("Titel"));
		getJMenuBar().add(getMenuTitelMenu());
		getJMenuBar().setVisible(true);

		// ---------------------------------------------------
		// End of constructor
//		addMediaList();
		setVisible(true);
	}

	// ---------------------------------------------------
	// Add MediaList:
	@SuppressWarnings(
	{ "unchecked", "rawtypes" })
	public void addMediaList(ArrayList<File> filesListed)
//	public void addMediaList()
	{
//		arrList.add("Test1");
//		arrList.add("Test2");
//		arrList.add("Test3");
//		arrList.add("Test4");
		
//		setMediaList(new JList(intervList));
//		setMediaList(new JList(arrList.toArray()));
		setMediaList(new JList(filesListed.toArray()));
		getMediaList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(getMediaList());
		scrollPane.setBounds(0, 0, 200, 500);
		getMainPanel().add(scrollPane);
		scrollPane.setViewportView(getMediaList());

		

//		DefaultListModel listModel = new DefaultListModel();
//		mediaList = new JList(listModel);
//		for (int i = 0; i < filesListed.size(); i++)
//		{
//			listModel.addElement(filesListed.get(i));
//		}
//		mediaList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		JScrollPane scrollPane = new JScrollPane(getMediaList());
//		scrollPane.setBounds(10, 10, 937, 583);
//		getMainPanel().add(scrollPane);
	}

	// ---------------------------------------------------
	// Getters and Setters:

	public JPanel getMainPanel()
	{
		return mainPanel;
	}

	// ---------------------------------------------------
	public JButton getBtnShuffle()
	{
		return btnShuffle;
	}

	public void setBtnShuffle(JButton btnShuffle)
	{
		this.btnShuffle = btnShuffle;
	}

	// ---------------------------------------------------
	public JButton getBtnStop()
	{
		return btnStop;
	}

	public void setBtnStop(JButton btnStop)
	{
		this.btnStop = btnStop;
	}

	// ---------------------------------------------------
	public JButton getBtnBackward()
	{
		return btnBackward;
	}

	public void setBtnBackward(JButton btnBackward)
	{
		this.btnBackward = btnBackward;
	}

	// ---------------------------------------------------
	public JButton getBtnStartPause()
	{
		return btnStartPause;
	}

	public void setBtnStartPause(JButton btnStartPause)
	{
		this.btnStartPause = btnStartPause;
	}

	// ---------------------------------------------------
	public JButton getBtnForward()
	{
		return btnForward;
	}

	public void setBtnForward(JButton btnForward)
	{
		this.btnForward = btnForward;
		// btnForward.setIcon(new
		// ImageIcon(Mainframe.class.getResource("/resources/forward.jpg")));
	}

	// ---------------------------------------------------
	public JButton getBtnRepeatloop()
	{
		return btnRepeatLoop;
	}

	public void setBtnRepeatloop(JButton btnRepeatloop)
	{
		this.btnRepeatLoop = btnRepeatloop;
	}

	// ---------------------------------------------------
	public JMenuBar getJMenuBar()
	{
		return menuBar;
	}

	public void setJMenuBar(JMenuBar menuBar)
	{
		this.menuBar = menuBar;
	}

	// ---------------------------------------------------
	public JMenu getMenuFileMenu()
	{
		return mnFileMenu;
	}

	public void setMnFileMenu(JMenu mnFileMenu)
	{
		this.mnFileMenu = mnFileMenu;
	}

	// ---------------------------------------------------
	public JMenuItem getMenuItemOpen()
	{
		return menuItemOpen;
	}

	public void setMntmOpen(JMenuItem mntmOpen)
	{
		this.menuItemOpen = mntmOpen;
	}

	// ---------------------------------------------------
	public JMenu getMenuTitelMenu()
	{
		return mnTitelMenu;
	}

	public void setMnTitelMenu(JMenu mnTitelMenu)
	{
		this.mnTitelMenu = mnTitelMenu;
	}

	// ---------------------------------------------------
	public JLabel getLblTrackProgress()
	{
		return lblTrackProgress;
	}

	public void setLblTrackProgress(JLabel lblTrackProgress)
	{
		this.lblTrackProgress = lblTrackProgress;
		panelControlButtons.add(lblTrackProgress);
	}

	// ---------------------------------------------------
	public JLabel getLblTrackDuration()
	{
		return lblTrackDuration;
	}

	public void setLblTrackDuration(JLabel lblTrackDuration)
	{
		this.lblTrackDuration = lblTrackDuration;
		panelControlButtons.add(lblTrackDuration);
	}

	// ---------------------------------------------------
	public DefaultListModel<String> getListModel()
	{
		return listModel;
	}

	// ---------------------------------------------------
	public JList<File> getMediaList()
	{
		return mediaList;
	}

	public void setMediaList(JList<File> mediaList)
	{
		this.mediaList = mediaList;
	}

	// ---------------------------------------------------
}
