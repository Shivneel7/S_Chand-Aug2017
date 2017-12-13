package game;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class Audio {
	
	private Clip clip;
	private AudioInputStream stream;
	
	public Audio(String path){
		try {
			clip = AudioSystem.getClip();
			stream = AudioSystem.getAudioInputStream(getClass().getResource(path));
			clip.open(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void play() {
		//clip.start();
		if(!clip.isActive()) {
			//clip.setFramePosition(0);
			System.out.println("Ready");
		}
	}

	public void stop() {

	}
	
	
}