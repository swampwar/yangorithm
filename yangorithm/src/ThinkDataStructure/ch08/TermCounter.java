package ThinkDataStructure.ch08;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
		map = new HashMap<String, Integer>();
	}
	
	public String getLabel() {
		return this.label;
	}
	
	/**
	 * Returns the total of all counts. 
	 * 
	 * @return
	 */
	public int size() {
		int rsltCountSum = 0;
		
		Set<String> keySet = keySet();
		for(String term : keySet) {
			rsltCountSum += get(term);
		}
		
		return rsltCountSum;
	}
	
	public Integer get(String term) {
		return map.get(term) == null ? 0 : map.get(term);
	}
	
	public void put(String term, Integer count) {
		map.put(term, count);
	}
	
	public void incrementTermCount(String term) {
		map.put(term, get(term)+1);
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
	
	public Set<String> keySet(){
		return map.keySet();
	}

	public void printCounts() {
		for(String key : keySet()) {
			Integer count = get(key);
			System.out.println(key + ", " + count);
		}
		System.out.println("Total of all counts = " + size());
	}
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";

		WikiFetcher wf = WikiFetcher.getInstance();
		Elements paragraphs = wf.fetchWikipedia(url);

		TermCounter counter = new TermCounter(url.toString());
		counter.processElements(paragraphs);
		counter.printCounts();
	}
}
