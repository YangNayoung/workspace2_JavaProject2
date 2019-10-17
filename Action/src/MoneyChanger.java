import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MoneyChangerFrame extends JFrame 
{
    int[] money = {50000, 10000, 1000, 500, 100, 50, 10, 1};
    String[] str = {"만원", "오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원"};
    JLabel label = new JLabel();
    JTextField[] TextField = new JTextField[str.length];
    JButton botton = new JButton("계산");
    MoneyChangerFrame() 
    {
        this.setTitle("Money Changer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.PINK);
        this.setLayout(null);
        
        label = new JLabel(str[0]);
        label.setSize(40, 20);
        label.setLocation(20, 20);
        this.add(label);
        
        TextField[0] = new JTextField(30);
        TextField[0].setSize(100, 20);
        TextField[0].setLocation(100, 20);
        this.add(TextField[0]);
        
        botton.setSize(70, 20);
        botton.setLocation(210, 20);
        botton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String monenycash = TextField[0].getText();
            if(monenycash.length() == 0) 
                return;
            
            int cash = Integer.parseInt(monenycash);
            int m;
            
            for(int i=0; i<money.length; i++) 
            {
                m = cash/money[i];
                TextField[i + 1].setText(Integer.toString(m));
                if(m > 0) 
                	cash = cash % money[i];
            }
            }
        });
        this.add(botton);
        for(int i = 1; i < str.length; i++)
        {
            label = new JLabel(str[i]);
            label.setHorizontalAlignment(JLabel.RIGHT);
            label.setSize(50, 20);
            label.setLocation(50, 50+(i*20));
            
            TextField[i] = new JTextField(30);
            TextField[i].setHorizontalAlignment(JTextField.CENTER);
            TextField[i].setSize(70, 20);
            TextField[i].setLocation(120, 50+(i*20));
            this.add(label);
            this.add(TextField[i]);
        }
        
        setSize(300, 300);
        setVisible(true);
    }
}
public class MoneyChanger {
    public static void main(String[] args) 
    {
        new MoneyChangerFrame();
    }
}
