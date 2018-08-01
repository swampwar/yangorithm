package TestWorld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImMainClass {

	public static void main(String[] args) {

		// list - for each 문에서 iterator의 next()와 hasnext()가 호출되는 것일까?
//		List<String> list = new ArrayList(Arrays.asList(new String[] {"A","B","C"}));
//		list.add("D");
//		
//		System.out.println("end");
//		
//		
//		MyList ml = new MyList();
//		for(String each : ml) {
//			System.out.println(each);
//		}
		
		
		String k = "<>~!@#$%^&*()_+-=";
		System.out.println(k.replaceAll("\\pP", " "));
//		for(String p : k.replaceAll("\\pP", " ")) {
//			System.out.println(p);
//		}
		
//		for(String str : new IterableTest()) {
//			System.out.println(str);
//		}
		
		
	}

}
