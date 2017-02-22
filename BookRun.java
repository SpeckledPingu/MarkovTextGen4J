import java.util.*;
import java.io.*;

public class BookRun{
	/*
	 * Establish a read books into an a string list
	 * Be fed more than one book at a time through the CLI
	 * Build a dictionary off of this and then run the MGE
	 * 
	 */
	String text[];
	List<String> text_list = new ArrayList<String>();
	List<HashMap> parsed_list = new ArrayList<HashMap>();
	Object[] generated_tex;
	
	BookRun() {
	}
	
	public TupleDict readText(String[] text){
		// Read from books the file paths
		List books = new ArrayList<String>();
		try {
			for (String file : text ) {
				BufferedReader br = new BufferedReader( new FileReader(file));
				StringBuilder str = new StringBuilder();
				String line = br.readLine();
				
				while (line != null) {
					str.append(line + " ");
					line = br.readLine();
					
				}
				text_list.add(str.toString());
			}
			
			// Strip newlines and split on whitespace
			TupleDict td = new TupleDict();
			 td.createMarkovDict(text_list);
			return td;
			// Return list of lists of the text
		} catch (IOException exp) {
			System.out.println(exp);
			return null;
		}
	}
	
	Object[] generateText(TupleDict td, int loops) {
		MarkovEngine me = new MarkovEngine();
		Object[] generated_text = me.generateText(td,loops);
		return generated_text;
	}
	
	
	public void writeText(Object[] generated_text) {
		Object[] text_array = generated_text;
		for (Object ob : text_array) {
			String str = ob.toString();
			System.out.print(str + " ");
		}
		// Method to write to file
	}
}
