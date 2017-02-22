import java.util.*;

public interface ReadWrite {
	/*
	 * Basic usage of this will be that a class
	 * has to get text.
	 * has to generate text.
	 * has to return text.
	 */
	
	List readText (String[] read_text);
	
	List generateText (List parsed_text);
	
	void writeText (List write_text);
	
}
