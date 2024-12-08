package quiz_pck;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Question_GUI extends GUI implements ActionListener{
	Question_GUI frame;
	private Character ans;
	public Question_GUI(String title,Character ans) {
		super(title);
		frame = this;
		this.ans = ans;
	}

	public void addOptions(String[] options) {
		JPanel panel = new JPanel();
		panel.setBounds(0, 250, 1000, 400);
		panel.setLayout(new GridLayout(4,1,0,10));
		
		panel.setVisible(true);
	
		Character[] ans_map = {'A','B','C','D'};
		
		for (int i = 0; i < options.length; i++) {
			JButton button = new JButton(ans_map[i] + "." + options[i]);

			button.addActionListener(this);
			
			panel.add(button);
		}
		
		this.setLayout(null);
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		Character chosen = ((JButton) e.getSource()).getText().charAt(0);
		if (chosen == ans) {
			JOptionPane.showMessageDialog(null, "CORRECT!!!","Result",JOptionPane.INFORMATION_MESSAGE);
			Score.score++;
			try {
				FileWriter writer = new FileWriter("QuizScore.txt");
				writer.write("You got: "+ Score.score+" points");
				writer.close();
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "WRONG!!!","Result",JOptionPane.ERROR_MESSAGE);
		}
	}
}
