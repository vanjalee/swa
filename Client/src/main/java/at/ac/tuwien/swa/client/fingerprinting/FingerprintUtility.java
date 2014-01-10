package at.ac.tuwien.swa.client.fingerprinting;

import java.io.IOException;
import java.util.logging.Logger;

import javax.sound.sampled.AudioInputStream;

import ac.at.tuwien.infosys.swa.audio.Fingerprint;
import ac.at.tuwien.infosys.swa.audio.FingerprintSystem;

public class FingerprintUtility {

	public static Fingerprint extractFingerPrint(
			AudioInputStream audioInputStream) {

		final Logger logger = Logger.getLogger(Fingerprint.class
				.getName());

		if (audioInputStream != null) {
			try {
				return FingerprintSystem.fingerprint(audioInputStream);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				logger.severe("Audio file you provided is too short.");
			} catch (NegativeArraySizeException e) {
				logger.severe("Audio file you provided is a corrupted file.");
			}
		} else {
			logger.severe("Audio file you provided is a corrupted file.");
		}

		return null;
	}
}
