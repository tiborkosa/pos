package pos;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ui.BackgroundImagePane;
import ui.LogInPanel;
import ui.POSPanel;
import ui.StartPanel;
import util.ConstantsUtil;
import util.ReadDataCreateModels;

public class App implements LogInPanel.LogInListener {

	private static JPanel loginPanel;
	private static JFrame frame;
	private CardLayout cl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new App();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		try {
			new ReadDataCreateModels();
			frame = new JFrame("Point of Sales");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			/*
			 * Icons made by <a href="https://www.flaticon.com/authors/flat-icons" title="Flat Icons">Flat Icons</a> from 
			 * <a href="https://www.flaticon.com/" title="Flaticon"> www.flaticon.com</a>
			 */
			ImageIcon img = new ImageIcon(ConstantsUtil.APP_ICON);
			frame.setIconImage(img.getImage());
			
			BackgroundImagePane background = new BackgroundImagePane();
			background.setBackground(ImageIO.read(new File(ConstantsUtil.BACKGROUND_IMAGE)));

			frame.setContentPane(background);
			cl = new CardLayout();
			loginPanel = new StartPanel(this);
			frame.getContentPane().setLayout(cl);
			frame.add("loginPanel", loginPanel);
			frame.add("POSPanel", new POSPanel());
			frame.setLocationRelativeTo(null);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setUndecorated(true);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// do something cool
		// check db info when added
		cl.show(frame.getContentPane(), "POSPanel");
	}
}
