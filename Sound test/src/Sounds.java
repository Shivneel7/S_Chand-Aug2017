
import javax.sound.sampled.AudioInputStream;//Only needed for Mixer
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;	//Only needed for Mixer
import javax.sound.sampled.Mixer;

public class Sounds {

	private static Mixer mixer; //unnecessary
	private static Clip c;

	public static void main(String[] args) {

//		//Using Mixers
//		Mixer.Info[] m = AudioSystem.getMixerInfo();
//		for(Mixer.Info i : m) {
//			System.out.println(i.getName() + "---" +  i.getDescription());
//		}
//		mixer = AudioSystem.getMixer(null);
//		
//		try {
//			AudioInputStream audio = AudioSystem.getAudioInputStream(Sounds.class.getResource("/test.wav"));
//			c = (Clip) mixer.getLine(new DataLine.Info(Clip.class, null));
//			c.open(audio);
//////////////////////////////////////////////////////////////////////////////////////////////////
		
		//without Mixer
		try {	
			c = AudioSystem.getClip();
			c.open(AudioSystem.getAudioInputStream(Sounds.class.getResource("/test.wav")));
			
		} catch (Exception e) {
			System.err.println("Cannot find Audio File");
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////
		c.start();
		//to keep thread running after the audio starts
		do {
			try {
				Thread.sleep(50);
			} catch (Exception e) { e.printStackTrace(); }
		}while(c.isActive());
	}
}
