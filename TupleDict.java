import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class TupleDict extends HashMap {
	private String text;
	private String raw_text[];
	static public HashMap<Tuple,List<String>> dict = new HashMap<Tuple,List<String>>();

	// Initialize with a list of the supplied text and an empty hashmap for the dictionary
	TupleDict(String text) {
		String raw_text[] = text.split("\\s+");
		HashMap<Tuple,List<String>> dict = new HashMap<Tuple,List<String>>();
	}
	
	TupleDict() {
		HashMap<Tuple,List<String>> dict = new HashMap<Tuple,List<String>>();
	}
	
	// Create Markov Dictionary to select from
	
	HashMap<Tuple,List<String>> createMarkovDict(List<String> text){	
		try {
			String concat_text = "";
			for (String book : text ) {
				concat_text += book;
			}
			String[] raw_text = concat_text.split("\\s+");
			int i = 0;
			System.out.println(raw_text.length);
			while (i < raw_text.length-2) {
				String a = raw_text[i];
				String b = raw_text[i+1];	
				Tuple key = new Tuple(a,b);
				String value_to_add = raw_text[i+2];				
				putValue(dict, key,value_to_add);
				i++;
		}
			return dict;
		} catch (Exception exp){
			System.out.println(exp);
			return null;
		}
	}
	Object getRandomKey(TupleDict td){
		try {
			HashMap<Tuple,List<String>> dict = TupleDict.dict;
			// return random key
			//Random rand = new Random();
			Object keys[] = dict.keySet().toArray();
			
			//rand.setSeed((System.currentTimeMillis() * System.currentTimeMillis()) % 12345678);
			Object random_key = keys[ThreadLocalRandom.current().nextInt((keys.length))];
			Tuple r_key = (Tuple) random_key;
			return r_key;
		} catch (Exception exp) {
			System.out.println(exp);
			return null;
		}
	}
	
	String getRandomValue(Tuple key) {
		// Return random value based on key
		try {
			//Random rand = new Random();
			//rand.setSeed((System.currentTimeMillis() * System.currentTimeMillis()) % 12345678);
			List<String> list_values = dict.get(key);
			Object[] values = list_values.toArray();
			Object got_value = values[ThreadLocalRandom.current().nextInt(values.length)];
			return (String) got_value;
		} catch (Exception exp) {
			return null;}
			
		}
	
	
	// Method for putting a value into the markov dictionary
	void putValue(HashMap<Tuple,List<String>> dict, Tuple key, String value) {
		if (!dict.containsKey(key)) {
			ArrayList<String> temp_array = new ArrayList<String>();
			temp_array.add(value);		
			dict.put(key, temp_array);
		}
		else {
			dict.put(key,Arrays.asList(value));
		}
	}
}
