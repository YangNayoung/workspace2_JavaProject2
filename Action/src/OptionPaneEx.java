import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class OptionPaneEx extends JFrame {
	Container contentPane;
	OptionPaneEx() {
		setTitle("�ɼ� �� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		setSize(250,200);
		contentPane.add(new MyPanel(),
				BorderLayout.NORTH);
		setVisible(true);
	}
	class MyPanel extends Panel {
		JButton inputBtn = new JButton("Input Name");
		JTextField tf = new JTextField(10);
		JButton confirmBtn = new JButton("Confirm");
		JButton messageBtn = new JButton("Message");
		MyPanel() {
			setBackground(Color.LIGHT_GRAY);
			add(inputBtn);
			add(confirmBtn);
			add(messageBtn);
			add(tf);
			inputBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name =
							JOptionPane.showInputDialog("�̸��� �Է��ϼ���.");
					if(name != null)
						tf.setText(name);
				}
			});
			confirmBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "����� ���Դϱ�?", "Confirm", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.CLOSED_OPTION)
						tf.setText("Just Closed without Selection");
					else if(result == JOptionPane.YES_OPTION)
						tf.setText("Yes");
					else
						tf.setText("No");
				}
			});
			messageBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "�����ϼ���", "Message", JOptionPane.ERROR_MESSAGE);
				}
			});
		}
	}
	public static void main(String [] args) {
		new OptionPaneEx();
	}
}