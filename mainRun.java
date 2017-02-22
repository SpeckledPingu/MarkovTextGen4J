import java.util.*;

public class mainRun {
	static public void main(String args[]) {
		String[] files = {
				//"/home/router/Desktop/ROTS.txt",
				//"/home/router/Desktop/ReturnOfTheJedi.txt",
				//"/home/router/Desktop/EmpireStrikesBack.txt",
				//"/home/router/Desktop/ANewHope.txt",
				//"/home/router/Desktop/PhantomMenace.txt",
				"/home/router/Desktop/fiftyshades.txt",
				"/home/router/Desktop/Hitchhikers.txt"
				};
		
		BookRun BR = new BookRun();
		TupleDict text = BR.readText(files);
		for (int i = 0 ; i < 25; i++) {
		Object[] generated_text = BR.generateText(text,3);
		BR.writeText(generated_text);
		System.out.println("\n-----------------------------------------------\n");
		}
	}
}
