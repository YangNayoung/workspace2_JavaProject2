import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JCheckBox;
import java.awt.Panel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;

public class Server extends JFrame {
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menu_file;
	private JCheckBoxMenuItem mntmOpen;
	private JCheckBoxMenuItem mntmStop;
	private JSeparator separator;
	private JTextField txtIp;
	private TextField ip1;
	private TextField ip2;
	private TextField ip3;
	private TextField ip4;
	private TextField port;
	private JTextField txtPort;
	private JButton btnOpen;
	private JButton btnStop;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtInputMember;
	private JTextField txtRegMember;
	private JButton btnRefesh;
	private JTextField txtOpenTime;
	private JTextField txtOpentime;
	private JTextField txtWooriserver;
	private JSeparator separator_1;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField textField_2;
	private JTextField txtSearchID;
	private JButton btnSearch;
	private JPanel panel_2;
	private JTextField textField_3;
	private JTextField txtMemberID;
	private JTextField textField_4;
	private JTextField txtName;
	private JTextField textField_6;
	private JTextField txtNick;
	private JTextField textField_8;
	private JTextField txtEmail_1;
	private JTextField txtEmail;
	private JTextField txtHP;
	private JTextField txtHp;
	private JTextField txtSex;
	private JTextField textField_18;
	private JTextField txtRegDate;
	private JTextField textField_20;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 675);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menu_file = new JMenu("");
		menuBar.add(menu_file);
		mntmOpen = new JCheckBoxMenuItem("Open");
		menu_file.add(mntmOpen);
		separator = new JSeparator();
		menu_file.add(separator);
		mntmStop = new JCheckBoxMenuItem("Stop");
		menu_file.add(mntmStop);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 56, 686, 31);
		contentPane.add(panel);
		txtOpentime = new JTextField();
		panel.add(txtOpentime);
		
		txtOpentime.setText("");
		txtOpentime.setEnabled(false);
		txtOpentime.setEditable(false);
		txtOpentime.setColumns(10);
		txtOpenTime = new JTextField();
		txtOpenTime.setEditable(false);
		panel.add(txtOpenTime);
		
		txtOpenTime.setColumns(10);
		txtIp = new JTextField();
		txtIp.setEnabled(false);
		txtIp.setEditable(false);
		txtIp.setFont(new Font("±º∏≤", Font.BOLD, 12));
		txtIp.setText("IP");
		txtIp.setBounds(82, 97, 18, 23);
		contentPane.add(txtIp);
		txtIp.setColumns(10);
		ip1 = new TextField();
		ip1.setBounds(114, 97, 39, 23);
		contentPane.add(ip1);
		ip2 = new TextField();
		ip2.setBounds(159, 97, 39, 23);
		contentPane.add(ip2);
		ip3 = new TextField();
		ip3.setBounds(207, 97, 39, 23);
		contentPane.add(ip3);
		ip4 = new TextField();
		ip4.setBounds(252, 97, 39, 23);
		contentPane.add(ip4);
		txtPort = new JTextField();
		txtPort.setText("PORT");
		txtPort.setFont(new Font("±º∏≤", Font.BOLD, 12));
		txtPort.setEnabled(false);
		txtPort.setEditable(false);
		txtPort.setColumns(10);
		txtPort.setBounds(298, 97, 45, 23);
		contentPane.add(txtPort);
		port = new TextField();
		port.setBounds(349, 97, 53, 23);
		contentPane.add(port);
		btnOpen = new JButton("OPEN");
		btnOpen.setBounds(425, 97, 67, 23);
		contentPane.add(btnOpen);
		btnStop = new JButton("STOP");
		btnStop.setBounds(504, 97, 77, 23);
		contentPane.add(btnStop);
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setText("");
		textField.setBounds(48, 140, 58, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setText("");
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(315, 140, 45, 21);
		contentPane.add(textField_1);
		txtInputMember = new JTextField();
		txtInputMember.setBounds(141, 140, 116, 21);
		contentPane.add(txtInputMember);
		txtInputMember.setColumns(10);
		txtRegMember = new JTextField();
		txtRegMember.setColumns(10);
		txtRegMember.setBounds(389, 140, 116, 21);
		contentPane.add(txtRegMember);
		btnRefesh = new JButton("REFRESH");
		btnRefesh.setBounds(517, 139, 94, 23);
		contentPane.add(btnRefesh);
		txtWooriserver = new JTextField();
		txtWooriserver.setForeground(Color.LIGHT_GRAY);
		txtWooriserver.setEditable(false);
		txtWooriserver.setEnabled(false);
		txtWooriserver.setFont(new Font("HY∞ﬂ∏Ì¡∂", Font.BOLD, 35));
		txtWooriserver.setText("WooRiServer");
		txtWooriserver.setBounds(170, 10, 281, 37);
		contentPane.add(txtWooriserver);
		txtWooriserver.setColumns(10);
		separator_1 = new JSeparator();
		separator_1.setBounds(198, 365, 1, 2);
		contentPane.add(separator_1);
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(0, 177, 686, 439);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setText("");
		textField_2.setBounds(174, 11, 60, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		txtSearchID = new JTextField();
		txtSearchID.setBounds(259, 11, 116, 21);
		panel_1.add(txtSearchID);
		txtSearchID.setColumns(10);
		btnSearch = new JButton("");
		btnSearch.setBounds(393, 10, 97, 23);
		panel_1.add(btnSearch);
		panel_2 = new JPanel();
		panel_2.setBounds(12, 42, 662, 387);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setText("");
		textField_3.setBounds(52, 61, 47, 21);
		panel_2.add(textField_3);
		
		textField_3.setColumns(10);
		txtMemberID = new JTextField();
		txtMemberID.setBounds(131, 61, 116, 21);
		panel_2.add(txtMemberID);
		
		txtMemberID.setColumns(10);
		textField_4 = new JTextField();
		textField_4.setFont(new Font("±º∏≤", Font.PLAIN, 25));
		textField_4.setText("");
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(274, 10, 133, 36);
		panel_2.add(textField_4);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(415, 61, 116, 21);
		panel_2.add(txtName);
		
		textField_6 = new JTextField();
		textField_6.setText("");
		textField_6.setEnabled(false);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(336, 61, 47, 21);
		panel_2.add(textField_6);
		
		txtNick = new JTextField();
		txtNick.setColumns(10);
		txtNick.setBounds(131, 104, 116, 21);
		panel_2.add(txtNick);
		
		textField_8 = new JTextField();
		textField_8.setText("");
		textField_8.setEnabled(false);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(52, 104, 47, 21);
		panel_2.add(textField_8);
		
		txtEmail_1 = new JTextField();
		txtEmail_1.setColumns(10);
		txtEmail_1.setBounds(131, 151, 116, 21);
		panel_2.add(txtEmail_1);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setEnabled(false);
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(52, 151, 47, 21);
		panel_2.add(txtEmail);
		
		txtHP = new JTextField();
		txtHP.setColumns(10);
		txtHP.setBounds(131, 193, 116, 21);
		panel_2.add(txtHP);
		
		txtHp = new JTextField();
		txtHp.setText("HP");
		txtHp.setEnabled(false);
		txtHp.setEditable(false);
		txtHp.setColumns(10);
		txtHp.setBounds(52, 193, 47, 21);
		panel_2.add(txtHp);
		
		txtSex = new JTextField();
		txtSex.setColumns(10);
		txtSex.setBounds(415, 104, 116, 21);
		panel_2.add(txtSex);
		
		textField_18 = new JTextField();
		textField_18.setText("");
		textField_18.setEnabled(false);
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		textField_18.setBounds(336, 104, 47, 21);
		panel_2.add(textField_18);
		
		txtRegDate = new JTextField();
		txtRegDate.setColumns(10);
		txtRegDate.setBounds(415, 145, 116, 21);
		panel_2.add(txtRegDate);
		
		textField_20 = new JTextField();
		textField_20.setText("");
		textField_20.setEnabled(false);
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		textField_20.setBounds(336, 145, 47, 21);
		panel_2.add(textField_20);
	}
}

