package game;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;

public class Sounds {
	
	private Mixer mixer;
	
	public Sounds() {
		Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
		for(Mixer.Info info : mixInfos) {
			System.out.println(info);
		}
	}
}