package com.eugene.webcrawler.simple_webcrawler.crawler;

import java.util.HashSet;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.eugene.webcrawler.simple_webcrawler.url.WebPageURL;

public class WebCrawler {
	private static final int DEPTH = 2;
	private HashSet<String> pageLinks;
	
	public WebCrawler() {
		pageLinks = new HashSet<String>();
	}

	public void getURLLinks(WebPageURL url, int currentDepth, String currentSelector)
	{
		if (!pageLinks.contains(url.getWebPageURL()) && currentDepth < DEPTH)
		{
			System.out.println("Depth: " + currentDepth + " [" + url.getWebPageURL() + "]");
			
				if(pageLinks.add(url.getWebPageURL()))
				{
					System.out.println(url.getWebPageURL());
				}
				
				JsoupScraper scraper = new JsoupScraper();
				
				Elements linksOnURL = scraper.scrapeElements(url, currentSelector);
				
				for (Element page : linksOnURL)
				{
					WebPageURL nextPage = new WebPageURL();
					nextPage.setWebPageURL(page.attr("abs:href"));
					getURLLinks(nextPage, currentDepth++, currentSelector);
				}
		}
	}
}
