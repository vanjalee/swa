package at.ac.tuwien.swa.client.fingerprinting;

import javax.sound.sampled.AudioInputStream;
import javax.swing.SwingWorker;

import ac.at.tuwien.infosys.swa.audio.Fingerprint;

public class FingerprintTask extends SwingWorker<Fingerprint, Object> {
    
	private AudioInputStream inputStream;
    private Fingerprint fingerprint;

    public FingerprintTask(AudioInputStream inputStream){
        this.inputStream = inputStream;
    }

    @Override
    protected Fingerprint doInBackground() throws Exception {
        setProgress(0);
        fingerprint = FingerprintUtility.extractFingerPrint(inputStream);
        setProgress(100);
        return fingerprint;
    }

    public Fingerprint getResult(){
        return fingerprint;
    }
}
