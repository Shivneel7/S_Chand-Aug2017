package derpyBurd;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Audio{
	
	private Clip clip;
	private AudioInputStream stream;
	
	public Audio(String path, float volume){
		try {
			clip = AudioSystem.getClip();
			stream = AudioSystem.getAudioInputStream(getClass().getResource(path));
			clip.open(stream);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(volume);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void play() {
		clip.start();
		if(!clip.isActive()) {
		    clip.setFramePosition(0);
			clip.flush();
		}
	}
}