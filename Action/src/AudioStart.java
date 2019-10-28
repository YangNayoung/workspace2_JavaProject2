import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AudioStart extends JFrame{
	private JLabel AudioLabel = new JLabel("����� ����");
	private JButton playButton = new JButton("����");
	private JButton stopButton = new JButton("����");
	private Clip clip = null;
	private AudioInputStream audioStream = null;
	
	public AudioStart() {
		super("����� ������ ����/���� ����");
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
				AudioLabel.setText("hiphop.wav"+" �� �����ϰ� �ֽ��ϴ�.");
			}
		});
		stopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(clip != null && clip.isActive()) {
					clip.close();
					AudioLabel.setText("���ָ� �����մϴ�.");
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