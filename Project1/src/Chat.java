import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.TextField;
import javax.swing.JButton;

public class Chat extends JFrame {
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Chat() {
		setTitle("채팅프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 336, 377);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane textPaneChat = new JTextPane();
		textPaneChat.setEditable(false);
		textPaneChat.setBounds(0, 0, 336, 377);
		panel.add(textPaneChat);
		
		TextField Write = new TextField();
		Write.setBounds(10, 383, 235, 29);
		contentPane.add(Write);
		
		JButton Button = new JButton("보내기");
		Button.setBounds(251, 387, 85, 23);
		contentPane.add(Button);
	}
}
