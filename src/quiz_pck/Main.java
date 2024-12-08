package quiz_pck;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Files
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Maps
import java.util.Map;
import java.util.LinkedHashMap;

//audio
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;



public class Main {
	public static void main(String[] args)
	{
		GUI newGUI = new GUI("Quiz");
		JButton start_button = newGUI.addButton("Start");
		newGUI.addLabel("Let's start some quizs!");
		
		new Music();
		start_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newGUI.dispose();
				Quiz q = new Quiz();
				q.logic();
			}
		});
	}
}

class Music{
	Music(){
		try {
			File musicPath = new File("BG_Song.wav");
			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

class Quiz {
	public void logic() {
		Questions question1 = new Questions("What is 1+1","1","2","3","4");
		Questions question2 = new Questions("What is 1+2","1","2","3","4");
		Questions question3 = new Questions("What is 1+3","1","2","3","4");
		
		int point = 0;
		
		try {
			FileReader reader = new FileReader("QuizScore.txt");
			int data = reader.read();
			System.out.print("Last time, ");
			while (data != -1) {
				System.out.print((char)data);
				data = reader.read();
			}
			
			reader.close();
			System.out.println("");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		Map<Questions,Character> quizziz = new LinkedHashMap<>();
		quizziz.put(question1, 'B');
		quizziz.put(question2, 'C');
		quizziz.put(question3, 'D');
		
		for (Map.Entry<Questions, Character> set : quizziz.entrySet()) {		
			String[] options = set.getKey().GetOptions();
			Character ans = set.getValue();
			
			Question_GUI question = new Question_GUI("Questions",ans);
			question.addLabel(set.getKey().GetQuestion());
			
			question.addOptions(options);
		}
		
	}
}