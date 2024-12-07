package quiz_pck;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame{

	public GUI() {
		this.setTitle("Quiz");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void addLabel(String text) {
		JLabel label = new JLabel();
		label.setText(text);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.TOP);
		label.setFont(new Font("MV Boli",Font.PLAIN,20));
		
		this.add(label);
		
	}
}
