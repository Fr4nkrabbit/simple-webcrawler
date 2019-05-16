package com.eugene.webcrawler.simple_webcrawler.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.eugene.webcrawler.simple_webcrawler.url.WebPageURL;

public class JsoupScraper {
	
	public Elements scrapeElements(WebPageURL url, String elementRegex)
	{
		Elements elementsOnURL = new Elements();
		try
		{
			Document htmlCode = Jsoup.connect(url.getWebPageURL()).get();
			elementsOnURL = htmlCode.select(elementRegex);
		}
		catch (IOException e) {
			System.err.println("For '" + url.getWebPageURL() + "': " + e.getMessage());
		}
		return elementsOnURL;
	}

}
