package quiz_pck;

public class Questions {
	private String problem;
	private String o1;
	private String o2;
	private String o3;
	private String o4;
	
	public Questions(String problem,String o1,String o2,String o3,String o4) {
		this.problem = problem;
		this.o1 = o1;
		this.o2 = o2;
		this.o3 = o3;
		this.o4 = o4;
	}
	
	protected String GetQuestion() {
		return problem;
	}
	
	protected String[] GetOptions() {
		return new String[] {o1,o2,o3,o4};
	}
}
