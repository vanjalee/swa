package at.ac.tuwien.swa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.NumberFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;


public class MainPanel extends JPanel {
	
	private static final long serialVersionUID = -6648944956530280730L;

	private final JMenuBar menuBar = new JMenuBar();
	
	private final JMenu mnLogout = new JMenu("Logout...");
	private final JMenuItem mnItLogout = new JMenuItem("Logout");
	
	private final JMenu  mnAbout = new JMenu("About...");
	private final JMenuItem mnItAbout = new JMenuItem("About");
	
	private File file = null;
	private String[] matchResponse;
		
	private JFormattedTextField nameField = new JFormattedTextField();
	private JFormattedTextField authorField = new JFormattedTextField();
	private JFormattedTextField coinsField = new JFormattedTextField(NumberFormat.getNumberInstance());
	
	private JTable table;
	
	
	public MainPanel(final JFrame frame, final ServerConnection server) {
		
		frame.setMaximumSize(new Dimension(984, 800));
		//MENU
		{
			frame.setJMenuBar(menuBar);
		}
		{
			menuBar.add(mnLogout);
			menuBar.add(mnAbout);
		}
		{
			mnItAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					@SuppressWarnings("unused")
					AboutDialog aDialog = new AboutDialog(frame);
				}
			});
		
			mnItLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					server.logout();
					frame.dispose();
				}	
			});
		}
		{
			mnAbout.add(mnItAbout);
			mnLogout.add(mnItLogout);
		}
		
//		gridBagLayout.columnWidths = new int[] { 0, 0 };
//		gridBagLayout.rowHeights = new int[] { 0, 0 };
//		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
//		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		
		Container pane = frame.getContentPane();
		pane.setLayout(new BorderLayout());
		
		JPanel contentPanel = new JPanel(new GridBagLayout());
		contentPanel.setBorder(new LineBorder(Color.GRAY));

		GridBagConstraints cs = new GridBagConstraints();
		
		JLabel labelSwazam = new JLabel("SWAzam");
		labelSwazam.setFont(new Font("Agency FB", Font.PLAIN, 48));
		labelSwazam.setForeground(Color.BLACK);
		
		JPanel titlePanel = new JPanel(new GridBagLayout());

		titlePanel.add(labelSwazam);
		pane.add(titlePanel, BorderLayout.PAGE_START);
		
		//STATISTICS
		JPanel statisticsPanel = new JPanel();
		statisticsPanel.setLayout(new BorderLayout());
		
		Integer coinStatus = new Integer(2296);
		
		JLabel coinsLabel = new JLabel("Coin status: ");
		coinsLabel.setFont(new Font("Serif", Font.PLAIN, 18));
	    coinsLabel.setForeground(Color.BLACK);
		
		coinsField.setValue(coinStatus);
        coinsField.setColumns(10);
        coinsField.setEditable(false);
        
        coinsLabel.setLabelFor(coinsField);
        
        JPanel labelPane = new JPanel(new GridLayout(0,1));
        labelPane.add(coinsLabel);
        
        JPanel fieldPane = new JPanel(new GridLayout(0,1));
        fieldPane.add(coinsField);
        
        statisticsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        statisticsPanel.add(labelPane, BorderLayout.LINE_START);
        statisticsPanel.add(fieldPane, BorderLayout.CENTER);
		
        cs.fill = GridBagConstraints.NONE;
	    cs.gridy = 1;
	    
        contentPanel.add(statisticsPanel);
		
        //table
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
		
        String[] columnNames = {
        		"Date", 
        		"Coin status before",
        		"Coin status after",
        		"Recognition file",
        		"Recognition result"
        };
        
        Object[][] data = server.getHistory();
        
        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(700, 100));
        table.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        JLabel transactionText = new JLabel("History of transactions for your account");
	    transactionText.setFont(new Font("Serif", Font.PLAIN, 18));
	    transactionText.setForeground(Color.BLACK);
        
	    tablePanel.add(transactionText, BorderLayout.PAGE_START);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        cs.fill = GridBagConstraints.HORIZONTAL;
	    cs.gridy = 2;
        contentPanel.add(tablePanel, cs);
        
		//FILE CHOOSER
		final String newline = "\n";
	    final JButton selectButton;
	    final JButton matchButton;
	    final JTextArea log;
	    final JFileChooser fc;
	    
	    JPanel fileChooser = new JPanel();
	    
	    fileChooser.setLayout(new BorderLayout());
	    
	    //Create the log first, because the action listeners
	    //need to refer to it.
	    log = new JTextArea(3, 20);
	    log.setMargin(new Insets(5, 5, 5, 5));
	    log.setEditable(false);
	    JScrollPane logScrollPane = new JScrollPane(log);
	 
	    //Create a file chooser
	    fc = new JFileChooser();
	  
	    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    
	    selectButton = new JButton("Select a File...");
	    selectButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				 //Handle select button action
		        if (e.getSource() == selectButton) {
		            int returnVal = fc.showOpenDialog(MainPanel.this);
		 
		            if (returnVal == JFileChooser.APPROVE_OPTION) {
		                file = fc.getSelectedFile();
		                log.append("Selected file: " + file.getName() + "." + newline);
		            } else {
		                log.append("Select command cancelled by user." + newline);
		            }
		            log.setCaretPosition(log.getDocument().getLength());
		        } else {

		        }
			}		
	    });
	    
	    matchButton = new JButton("Match the file");
	    matchButton.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e) {
				
				 //Handle select button action
		        if (e.getSource() == matchButton) {
		           
		        	if (file == null) {
		        		JOptionPane.showMessageDialog(null, "No file selected!");
		        	} else {
		        		matchResponse = server.createFingerprint(file);
		        		if (matchResponse.length == 1) {
		        			JOptionPane.showMessageDialog(null, "No match found!");
		        		} else {
		        			
		        			server.update();
		        			
		        			nameField.setValue(matchResponse[0]);
		        			authorField.setValue(matchResponse[1]);
		        			
		        			Integer newRes = server.getCoins();
		        			//coinsField.setValue(something);
		        			
		        			//update table data
		        		}
		        	}
		        }
	    	}
	    });
	    
	 
	    //For layout purposes, put the buttons in a separate panel
	    JPanel buttonPanel = new JPanel(); //use FlowLayout
	    buttonPanel.add(selectButton);
	    buttonPanel.add(matchButton);
	    
	    JLabel fileText = new JLabel("Please select a file to be used for recognition");
	    fileText.setFont(new Font("Serif", Font.PLAIN, 18));
	    fileText.setForeground(Color.BLACK);
	    
	    //Add the buttons and the log to this panel.
	    fileChooser.add(fileText, BorderLayout.PAGE_START);
	    fileChooser.add(buttonPanel, BorderLayout.CENTER);
	    fileChooser.add(logScrollPane, BorderLayout.PAGE_END);
		
	    cs.fill = GridBagConstraints.NONE;
	    //c.anchor = GridBagConstraints.PAGE_END;
	    cs.gridy = 3;
	    
	    contentPanel.add(fileChooser, cs);
	    	    
	    //MATCHING RESULT
	    JPanel matchingPanel = new JPanel();
		matchingPanel.setLayout(new BorderLayout());
				
		JLabel nameLabel = new JLabel("Song name: ");
		JLabel authorLabel = new JLabel("Author: ");
		nameLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		authorLabel.setFont(new Font("Serif", Font.PLAIN, 18));
	    nameLabel.setForeground(Color.BLACK);
		
		//nameField.setValue(matchResponse[0]);
        nameField.setColumns(10);
        nameField.setEditable(false);
        //authorField.setValue(matchResponse[1]);
        authorField.setColumns(10);
        authorField.setEditable(false);
        
        nameLabel.setLabelFor(nameField);
        authorLabel.setLabelFor(authorField);
        
        
        labelPane = new JPanel(new GridLayout(0,1));
        labelPane.add(nameLabel);
        labelPane.add(authorLabel);
        
        fieldPane = new JPanel(new GridLayout(0,1));
        fieldPane.add(nameField);
        fieldPane.add(authorField);

        JLabel matchingLabel = new JLabel("Matching results: ");
        matchingLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        
        matchingPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        matchingPanel.add(matchingLabel, BorderLayout.PAGE_START);
        matchingPanel.add(labelPane, BorderLayout.CENTER);
        matchingPanel.add(fieldPane, BorderLayout.LINE_END);
		
        cs.fill = GridBagConstraints.NONE;
        cs.ipady = 10;
        cs.ipadx = 100;
	    cs.gridy = 4;
        contentPanel.add(matchingPanel, cs);
	    
	    
	    pane.add(contentPanel, BorderLayout.CENTER);
	}

	private class AboutDialog extends JDialog {

		private static final long serialVersionUID = 4759922655327689984L;

		public AboutDialog(Frame parent) {
			super(parent, "About", true);
			initGUI();
			pack();
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setResizable(false);
			setVisible(true);
		}

		private void initGUI() {
			
			JPanel panel = new JPanel(new GridBagLayout());
			
			panel.setPreferredSize(new Dimension(400, 500));

			JLabel labelProject = new JLabel("SWAzam");
			
			labelProject.setFont(new Font("Agency FB", Font.PLAIN, 48));
			labelProject.setForeground(Color.BLACK);
			GridBagConstraints cs = new GridBagConstraints();
			cs.insets = new Insets(20, 20, 20, 20);
			cs.gridx = 0;
			cs.gridy = 0;
			cs.gridwidth = 1;
			panel.add(labelProject, cs);

			JLabel labelDescription = new JLabel(
					"<html><p align=\"center\">"
							+ "SWAzam is a service that...<p align=\"center\">"
							+ "something,<p align=\"center\">"
							+ "something<p align=\"center\">"
							+ "something<p align=\"center\">"
							+ "</html>");
			cs.gridy = 1;
			cs.gridwidth = 1;
			cs.insets = new Insets(0, 20, 0, 20);
			panel.add(labelDescription, cs);

			JLabel labelTeam = new JLabel(
					"<html>Development team:<p align=\"center\">"
							+ "<i>Levent Ak</i><p align=\"center\">"
							+ "<i>Sezer Azgin</i><p align=\"center\">"
							+ "<i>Vanja Bisanovic</i><p align=\"center\">"
							+ "<i>Rainer Schwarzinger</i><p align=\"center\">"
							+ "<i>Ivan Domagoj Skoflic</i><p align=\"center\">");
			cs.gridy = 2;
			cs.insets = new Insets(20, 20, 20, 20);
			panel.add(labelTeam, cs);

			JButton btnOk = new JButton("Close");
			btnOk.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cs.gridy = 3;
			cs.insets = new Insets(0, 20, 20, 20);
			panel.add(btnOk, cs);
			add(panel);
		}
	}
	
}
