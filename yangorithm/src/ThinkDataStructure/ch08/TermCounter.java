package ThinkDataStructure.ch08;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import ThinkDataStructure.ch06.WikiFetcher;
import ThinkDataStructure.ch06.WikiNodeIterable;

public class TermCounter {

	private Map<String, Integer> map;
	private String label;
	
	public TermCounter(String label) {
		this.label = label;
		map = new HashMap();
	}
	
	public Integer get(String term) {
		return map.get(term) == null ? 0 : map.get(term);
	}
	
	public void put(String term, Integer count) {
		map.put(term, count);
	}
	
	public void incrementTermCount(String term) {
		map.put(term, map.get(term)+1);
	}
	
	public void processElements(Elements paragraphs) {
		for(Node node : paragraphs) {
			processTree(node);
		}
	}
	
	public void processTree(Node root) {
		for(Node node : new WikiNodeIterable(root)) { // new 구문은 한번만 실행되고 hasNext()와 next()가 반복적으로 실행된다.
			if(node instanceof TextNode) {
				processText(((TextNode) node).text());
			}
		}
	}
	
	public void processText(String text) {
		String[] array = text.replaceAll("\\pP", " ") // TODO 정규식 몰겄다!!
					         .toLowerCase()
					         .split("\\s+"); // '\s' : 공백문자
		
		for(int i=0; i<array.length; i++) {
			incrementTermCount(array[i]);
		}
	}
	
}
