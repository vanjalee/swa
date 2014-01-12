package at.ac.tuwien.swa.util;

import ac.at.tuwien.infosys.swa.audio.Fingerprint;

import com.google.gson.Gson;

public class FingerprintConvertor {

	public static String convertToGson(Fingerprint fingerprint) {
		return new Gson().toJson(fingerprint);
	}

	public static Fingerprint convertFromJson(String jsonFingerprint) {
		return new Gson().fromJson(jsonFingerprint, Fingerprint.class);
	}

}
