import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class Guess extends JFrame{

	static int num = 0;
	
	public void GUI() {
		setBounds(new Rectangle(0, 0, 600, 200));
		setTitle("Guess Number Game");
		getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(5, 0, 0, 0));
		
		JLabel EmptyLabel = new JLabel("");
		EmptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(EmptyLabel);
		
		JLabel Result = new JLabel("");
		Result.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(Result);
		
		JTextField Number = new JTextField();
		Number.setHorizontalAlignment(SwingConstants.CENTER);
		Number.setToolTipText("\u0427\u0438\u0441\u043B\u043E");
		panel_1.add(Number);
		Number.setColumns(10);
		
		JButton Check = new JButton("\u041F\u0440\u043E\u0432\u0435\u0440\u043A\u0430");
		panel_1.add(Check);
		Check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Integer.valueOf(Number.getText()) == num) {
					Result.setText("Число отгадано");
				}
				else
				if(Integer.valueOf(Number.getText()) < num) {
					Result.setText("Загаданное число больше");
				}
				else
					Result.setText("Загаданное число меньше");
			}
	    });
	}
	
	public Guess() {
		GUI();
	}

	public static void main(String[] args) {
		boolean[] mas = new boolean[10];
		int n = 2;
		for (int i = 0; i <= 9; i++) {
			mas[i] = false;
		}
		for (int i = 0; i < n; i++) {
			int r = (int)(Math.random() * 9) + 1;
			while (mas[r])
				r = (int)(Math.random() * 9) + 1;
			mas[r] = true;
			num = num * 10 + r;
		}
		Guess window = new Guess();
	    window.setVisible(true);
	    
	}

}
