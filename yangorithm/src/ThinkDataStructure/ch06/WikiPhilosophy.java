package ThinkDataStructure.ch06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class WikiPhilosophy {
    final static List<String> visited = new ArrayList<String>();
    final static WikiFetcher wf = WikiFetcher.getInstance();

    /**
     * Tests a conjecture about Wikipedia and Philosophy.
     *
     * https://en.wikipedia.org/wiki/Wikipedia:Getting_to_Philosophy
     *
     * 1. Clicking on the first non-parenthesized, non-italicized link
     * 2. Ignoring external links, links to the current page, or red links
     * 3. Stopping when reaching "Philosophy", a page with no links or a page
     *    that does not exist, or when a loop occurs
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String destination = "https://en.wikipedia.org/wiki/Philosophy";
        String source = "https://en.wikipedia.org/wiki/Java_(programming_language)";
//        String source = "https://en.wikipedia.org//wiki/Programming_language";

        testConjecture(destination, source, 10);
    }

    /**
     * Starts from given URL and follows first link until it finds the destination or exceeds the limit.
     *
     * @param destination
     * @param source
     * @throws IOException
     */
    public static void testConjecture(String destination, String source, int limit) throws IOException {
    	//--------------------------------------------------------------//
    	// 규칙 1. 링크는 사이드바 또는 박스아웃이 아닌 페이지 본문 > WikiFetcher.java O
    	// 규칙 2. 링크는 이탤릭체나 괄호 안에 없어야 함 > 부모체인에 <i> 또는 <em> 태그가 있으면 이탤릭체 > O
    	// 규칙 3. 외부링크와 현재 페이지에 대한 링크, 레드 링크는 건너 뛴다. > O
    	//--------------------------------------------------------------//
    	
    	if(limit == 0) {
    		System.out.println("limit : 0, return...");
    		return;
    	}else if(destination.equals(source)) {
    		System.out.println("find : " + source);
    		return;
    	}
    	
    	WikiFetcher wikiFetcher = WikiFetcher.getInstance();
    	Elements paras = wikiFetcher.fetchWikipedia(source);
    	
    	for(Element node : paras) {
    		Iterable<Node> iterable = new WikiNodeIterable(node);
    		for(Node subNode : iterable) {
    			if (subNode instanceof Element) {
//    				System.out.println("Element : " + subNode.toString());
    				
    				Element subElement = (Element)subNode; // 태그 정보를 조회하기 위한 형변환 
    				if("a".equals(subElement.tagName())) {
    					if(!"i".equals(subElement.parent().tagName()) && !"em".equals(subElement.parent().tagName())){
	    					if(subElement.attr("href").startsWith("/wiki/")) {
	    						if(!Character.isUpperCase(subElement.text().charAt(0))) {
	    							System.out.println("**"+subElement.text()+"**");
	    							testConjecture(destination, "https://en.wikipedia.org"+subElement.attr("href"),--limit);
	    						}
	    					}
    					}
    				}
    			}
    		}
    	}
    }
}
