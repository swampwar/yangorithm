import java.util.HashSet;
import java.util.Iterator;

public class TEST {

	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		
		set1.add(1);
		set1.add(3);
	
		// Set addAll()
		set2.addAll(set1);
		
		System.out.println(set2.toString());
	}
	
	
    public static int getSum(HashSet<Integer> iSet){
    	int rslt = 0;
    	Iterator<Integer> itr = iSet.iterator();
    	while(itr.hasNext()){
    		rslt += itr.next();
    	}
    	return rslt;
    }

}
