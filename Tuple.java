import java.util.Objects;

public class Tuple {
	public String ob_x;
	public String ob_y;
	
	Tuple(String x, String y) {
		ob_x = x;
		ob_y = y;
	}
	
	public boolean equals(Object ob){
		if (ob == this) {
			return true;
		}
		if (!(ob instanceof Tuple)) {
			return false;
		}
		
		Tuple o = (Tuple) ob;
		
		return ((o.ob_x.equals(ob_x)) && (o.ob_y.equals(ob_y)));
		}
	
	String toString(Tuple ob) {
		return ob.ob_x + ", " + ob.ob_y;
	}
	// Write hashing function
	@Override
	public int hashCode() {
		char[] char_x = ob_x.toCharArray();
		char[] char_y = ob_y.toCharArray();
		int value_x = 0;
		int value_y = 0;
		for (int  i=0; i < char_x.length; i ++) {
			value_x += (int) char_x[i];
		}
		for (int  i=0; i < char_y.length; i ++) {
			value_y += (int) char_y[i];
		}
		int hash =(int) (Math.pow(value_x, 2) + Math.pow(value_y, 3));

		return hash;
	}
}
