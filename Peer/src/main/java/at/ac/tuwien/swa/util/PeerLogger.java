package at.ac.tuwien.swa.util;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class PeerLogger {

	private static final String prefix = "################### P E E R ### L O G G E R ################### ";
	private static PeerLogger instance;
	private final static Logger logger = Logger.getLogger(PeerLogger.class
			.getName());

	private PeerLogger() {
	}

	public static PeerLogger getInstance() {
		if (instance == null) {
			instance = new PeerLogger();
		}
		return instance;
	}

	public void log(int priority, String msg) {
		if (priority == Priority.INFO_INT) {
			logger.info(prefix + msg);
		} else if (priority == Priority.ERROR_INT) {
			logger.info(prefix + msg);
		} else if (priority == Priority.WARN_INT) {
			logger.info(prefix + msg);
		} else {
			logger.debug(prefix + msg);
		}
	}

}
