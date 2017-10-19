package gui;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
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
	Listener listener = new Listener();
	final JFileChooser fc = new JFileChooser();
	JPanel mainPanel;
	JPanel panelControlButtons;

	JButton btnBackward;
	JButton btnStartPause;
	JButton btnForward;
	JButton btnStop;
	JButton btnShuffle;
	JButton btnRepeatLoop;

	JMenuBar menuBar;
	JMenu mnFileMenu;
	JMenuItem menuItemOpen;
	JMenu mnTitelMenu;

	JLabel lblTrackProgress;
	JLabel lblTrackDuration;

	DefaultListModel<String> listModel;
	JList<File> mediaList;

	FileHandler fileHandler;
	private JPanel panelSouth;
	private JProgressBar progressBar;

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
		mainPanel.setBounds(0, 21, 984, 800);
		mainPanel.setOpaque(false);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);

		panelControlButtons = new JPanel();
		panelControlButtons.setForeground(Color.LIGHT_GRAY);
		panelControlButtons.setBackground(Color.LIGHT_GRAY);
		panelControlButtons.setBounds(0, 619, 985, 39);
		mainPanel.add(panelControlButtons);
		panelControlButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panelSouth = new JPanel();
		panelSouth.setBackground(Color.LIGHT_GRAY);
		panelSouth.setBounds(0, 658, 985, 39);
		mainPanel.add(panelSouth);

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
// Miscellaneous:
		setLblTrackProgress(new JLabel("--:--"));

		progressBar = new JProgressBar();

		setLblTrackDuration(new JLabel("--:--"));
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelSouth.add(lblTrackProgress);
		panelSouth.add(progressBar);
		panelSouth.add(lblTrackDuration);

// ---------------------------------------------------
// End of constructor
		setVisible(true);
	}
	
// ---------------------------------------------------
// Add MediaList:
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addMediaList(List<File> filesListed)
	{
		DefaultListModel listModel = new DefaultListModel();
		setMediaList(new JList(listModel));
		for (int i = 0; i < filesListed.size(); i++)
		{
			listModel.addElement(filesListed.get(i));
		}
		getMediaList().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane scrollPane = new JScrollPane(getMediaList());
		scrollPane.setBounds(10, 10, 937, 583);
		getMainPanel().add(scrollPane);
		scrollPane.setViewportView(getMediaList());

		getMediaList().repaint();
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
	}

// ---------------------------------------------------
	public JLabel getLblTrackDuration()
	{
		return lblTrackDuration;
	}
	public void setLblTrackDuration(JLabel lblTrackDuration)
	{
		this.lblTrackDuration = lblTrackDuration;
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
