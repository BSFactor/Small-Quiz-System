package quiz_pck;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.LinkedHashMap;

public class Main {
	public static void main(String[] args)
	{
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
			}else {
				System.out.println("WRONG!!!");
			}
			
		}
		
		System.out.println("You completed the quiz!");
		scanner.close();
	}
}