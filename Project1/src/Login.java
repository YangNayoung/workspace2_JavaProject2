import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JEditorPane;

public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField Field;
	private JTextField ID;
	private JTextField Field_1;
	private JPasswordField pw;
	private JRadioButton NewRadioButton;
	private JRadioButton radioButton;
	private JButton NewButton;
	private JButton Join;
	private JButton Find;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Login() {
		setTitle("채팅 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 274, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 258, 492);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Field = new JTextField();
		Field.setEnabled(false);
		Field.setEditable(false);
		Field.setText("아이디 :");
		Field.setBounds(32, 118, 56, 21);
		panel.add(Field);
		Field.setColumns(10);
		
		ID = new JTextField();
		ID.setBounds(111, 118, 116, 21);
		panel.add(ID);
		ID.setColumns(10);
		
		Field_1 = new JTextField();
		Field_1.setText("비밀번호 :");
		Field_1.setEnabled(false);
		Field_1.setEditable(false);
		Field_1.setColumns(10);
		Field_1.setBounds(32, 162, 67, 21);
		panel.add(Field_1);
		
		pw = new JPasswordField();
		pw.setBounds(111, 162, 116, 21);
		panel.add(pw);
		
		NewButton = new JButton("로그인");
		NewButton.setBounds(32, 248, 195, 23);
		panel.add(NewButton);
		
		Join = new JButton("회원가입");
		Join.setBounds(32, 303, 195, 23);
		panel.add(Join);
		
		Find = new JButton("아이디/비밀번호 찾기");
		Find.setBounds(32, 369, 195, 23);
		panel.add(Find);
		
	}
}
