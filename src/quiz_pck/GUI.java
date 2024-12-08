package quiz_pck;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame{
	JButton button;
	JFrame frame;
	public GUI(String title) {
		frame = this;
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void addLabel(String text) {
		JLabel label = new JLabel();
		label.setText(text);
		label.setBounds(100, 100, 800, 50);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.TOP);
		label.setFont(new Font("MV Boli",Font.PLAIN,20));
		
		this.add(label);
	}
	
	public JButton addButton(String text) {
		button = new JButton();
		button.setText(text);
		button.setBounds(350, 300, 300, 100);
	
		this.add(button);
		return button;
	}
	
}
