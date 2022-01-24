package ex02;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex03JSoup {
	
	public Ex03JSoup() throws IOException {
		String urlPath = "https://www.w3schools.com/css/css_selectors.asp";
		Document doc = Jsoup.connect(urlPath).get();
		System.out.println(doc.title());
		System.out.println();
		
		Elements lis = doc.select("#main ul li");
		for(Element el : lis) {
//			System.out.println(el.text());
			System.out.printf("%s, %s\n", el.select("a[href]").attr("href"), el.text());
		}
	}

	public static void main(String[] args) throws IOException {
		new Ex03JSoup();
	}

}
