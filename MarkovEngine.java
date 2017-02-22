import java.util.*;

public class MarkovEngine {
	TupleDict markovDict;
	Tuple starter_key;
	int loops;
	String generated_text;
	
	
	MarkovEngine (TupleDict dict, int loops) {
		markovDict = dict;
		loops = loops;
	}
	
	MarkovEngine(){
		loops = 15;
	}
	
	//Randomly select a key to start with
	Object starterKey(TupleDict dict) {
		// select random key
		// return random key
		return dict.getRandomKey(dict);
	}
	
	// Generate text from a starter key
	Object[] generateText(TupleDict dict, int loop) {
		// Initialize the generated text string and random object
		List<String> generated_text = new ArrayList<String>();
				
		// Grab first tuple
		Object o_key = starterKey(dict);
		Tuple key = (Tuple) o_key;
		
		
		while (!(Character.isUpperCase(key.ob_x.codePointAt(0)))) {
			o_key = starterKey(dict);
			key = (Tuple) o_key;
		}
		
		
		String value = dict.getRandomValue(key);

		
		// Loop over the keys and values moving the second key value
		// to first position and the returned value to the second position
		int i = 0;
		do {
			try {
				if (key.ob_x.codePointAt(key.ob_x.length()-1) == '.') {
					i++;
				}
			} catch (Exception exp) {}
			// Create a new key to pull the markov list
			generated_text.add(key.ob_x);
			Tuple new_key = new Tuple(key.ob_y,value);
			String new_value = dict.getRandomValue(new_key);
			if (new_value == null) {
				Object o_new_key = starterKey(dict);
				new_key = (Tuple) o_new_key;
				new_value = dict.getRandomValue(new_key);
		}
			
			key = new_key;
			value = new_value;

		} while (i < loop);
		
		Object[] gen_text =  generated_text.toArray();
		return gen_text;
	}
}
