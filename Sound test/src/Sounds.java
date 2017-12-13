
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Mixer;

public class Sounds {

	private static Mixer mixer;
	private static Clip c;

	public static void main(String[] args) {
		mixer = AudioSystem.getMixer(null);

		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(Sounds.class.getResource("/test.wav"));
			c = (Clip) mixer.getLine(new DataLine.Info(Clip.class, null));
			c.open(audio);
		} catch (Exception e) {
			System.err.println("Cannot find Audio File");
		}
		c.start();
		do {
			try {
				Thread.sleep(50);
			} catch (Exception e) { e.printStackTrace(); }
		}while(c.isActive());
	}
}
