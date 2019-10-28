import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MenuAndColorChooser extends JFrame {
	Container contentPane;
	JLabel label = new JLabel("Hello");

	MenuAndColorChooser() {
		setTitle("JColorChooser ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Ravie", Font.ITALIC, 30));
		contentPane.add(label, BorderLayout.CENTER);
		createMenu();
		setSize(250,200);
		setVisible(true);
	}

	void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenuItem colorMenuItem = new JMenuItem("Color");
		JMenu fileMenu = new JMenu("Text");
		colorMenuItem.addActionListener(new MenuActionListener());
		fileMenu.add(colorMenuItem);
		mb.add(fileMenu);
		this.setJMenuBar(mb);
	}


	class MenuActionListener implements ActionListener {
		JColorChooser chooser = new JColorChooser();

		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("Color"))  {
				Color selectedColor = chooser.showDialog(null, 	"Color",  Color.YELLOW);
				if(selectedColor != null)
					label.setForeground(selectedColor);
			}
		}
	}

	public static void main(String [] args) {
		new MenuAndColorChooser();
	}
}