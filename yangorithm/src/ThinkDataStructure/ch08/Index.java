package ThinkDataStructure.ch08;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jsoup.select.Elements;

import ThinkDataStructure.ch06.WikiFetcher;

public class Index {
	private Map<String, Set<TermCounter>> index = new HashMap();
	
	/**
	 * 검색어(term)가 등장하는 웹페이지(tc)를 추가한다.
	 *
	 * @param term
	 * @param tc
	 */
	public void add(String term, TermCounter tc) {
		Set<TermCounter> set = get(term);
		
		if(set == null) { // 해당 검색어에 아무 set도 등록되어 있지 않으면 신규등록
			set = new HashSet<TermCounter>();
			index.put(term, set);
		}
		
		set.add(tc);
	}
	
	public Set<TermCounter> get(String term){
		return index.get(term);
	}
	
	public Set<String> keySet(){
		return index.keySet();
	}
	
	public void indexPage(String url, Elements paragraphs) {
		// TermCounter객체 생성
		TermCounter tc = new TermCounter(url);
		tc.processElements(paragraphs);
		
		// TermCounter의 각 검색어에 대해 TermCounter객체를 인덱스에 추가
		for(String term : tc.keySet()) {
			add(term, tc);
		}
	}
	
	public void printIndex() {
		for(String term : keySet()) {
			System.out.println(term);
			
			Set<TermCounter> tcs = get(term);
			for(TermCounter tc : tcs) {
				Integer count = tc.get(term);
				System.out.println(" " + tc.getLabel() + " " + count);
			}
		}
	}
	
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        WikiFetcher wf = WikiFetcher.getInstance();
        Index indexer = new Index();

        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
        Elements paragraphs = wf.fetchWikipedia(url);
        indexer.indexPage(url, paragraphs);

        url = "https://en.wikipedia.org/wiki/Programming_language";
        paragraphs = wf.fetchWikipedia(url);
        indexer.indexPage(url, paragraphs);

        indexer.printIndex();
    }
}
