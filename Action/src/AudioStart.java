import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AudioStart extends JFrame{
	private JLabel AudioLabel = new JLabel("오디오 파일");
	private JButton playButton = new JButton("연주");
	private JButton stopButton = new JButton("종료");
	private Clip clip = null;
	private AudioInputStream audioStream = null;
	
	public AudioStart() {
		super("오디오 파일을 연주/종료 제어");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		AudioLabel.setFont(new Font("Gothic", Font.PLAIN, 15));
		AudioLabel.setHorizontalAlignment(JLabel.LEFT);
		AudioLabel.setHorizontalAlignment(JButton.RIGHT);
		AudioLabel.setHorizontalAlignment(JButton.CENTER);
		c.add(AudioLabel);
		c.add(playButton);
		c.add(stopButton);
		
		setSize(400, 100);
		setVisible(true);
		
		playButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(clip != null && clip.isActive())
					clip.close();
				
				playAudio("src/swing/hiphop.wav");
				AudioLabel.setText("hiphop.wav"+" 를 연주하고 있습니다.");
			}
		});
		stopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(clip != null && clip.isActive()) {
					clip.close();
					AudioLabel.setText("연주를 종료합니다.");
				}
				try {
					audioStream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	protected void playAudio(String pathName) {
		try {
			File audioFile = new File(pathName);
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		} catch (LineUnavailableException e) { e.printStackTrace(); }
		catch (UnsupportedAudioFileException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }
	}

	public static void main(String[] args) {
		new AudioStart();
	}
}