package quiz_pck;

//Files
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Maps
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.LinkedHashMap;

public class Main {
	public static void main(String[] args)
	{
		GUI newGUI = new GUI();
		newGUI.addLabel("Let's start some quizs!");
		Quiz q = new Quiz();
		q.logic();	
	}

}

class Quiz{
	public void logic() {
		Scanner scanner = new Scanner(System.in);
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
		
		Map<Questions,String> quizziz = new LinkedHashMap<>();
		quizziz.put(question1, "B");
		quizziz.put(question2, "C");
		quizziz.put(question3, "D");
		
		Character[] ans_map = {'A','B','C','D'};
		
		for (Map.Entry<Questions, String> set : quizziz.entrySet()) {
			System.out.println("Your answer?");
			System.out.println(set.getKey().GetQuestion());
			String[] options = set.getKey().GetOptions();
			
			for (int i = 0; i < options.length; i++) {
				System.out.println(ans_map[i]+"."+options[i]);
			}
			String ans = scanner.next();
			
			if (ans.equals(set.getValue())){
				System.out.println("CORRECT!!!");
				point++;
			}else {
				System.out.println("WRONG!!!");
			}
			
			
			try {
				FileWriter writer = new FileWriter("QuizScore.txt");
				writer.write("You got: "+point+" points");
				writer.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("You completed the quiz!");
		scanner.close();
	}
}