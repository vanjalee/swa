package at.ac.tuwien.swa;

import java.io.IOException;
import javax.swing.UIManager;
import java.util.logging.Logger;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * The client console app.
 * Created by grumpo on 12/7/13.
 */


public class Client extends JFrame {

	private final static Logger logger = Logger.getLogger(Client.class.getName());
	private static ServerConnection server = new ServerConnection();
	
	private static final long serialVersionUID = 1L;

	public Client() {
		
        JFrame frame = new JFrame("SWAzam Desktop Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension frameDimension = new Dimension(984, 800);
        
        frame.setPreferredSize(frameDimension);
        frame.setMinimumSize(frameDimension);
        frame.setMaximumSize(frameDimension);
        
        new LoginPanel(frame, server);
        
    	frame.pack();
        frame.setVisible(true);
        
	}
	
	public static void main(String[] args) {

	    logger.info("Client starting...");

		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
	    } catch (Exception e) {
	            e.printStackTrace();
	    }

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
            	@SuppressWarnings("unused")
				JFrame frame = new Client();
            }
        });
		
		logger.info("Client shutting down...");

	}
}
