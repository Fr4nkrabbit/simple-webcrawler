package com.eugene.webcrawler.simple_webcrawler;

import com.eugene.webcrawler.simple_webcrawler.crawler.WebCrawler;
import com.eugene.webcrawler.simple_webcrawler.url.WebPageURL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WebCrawler crawly = new WebCrawler();
        WebPageURL whereTo = new WebPageURL();
        
        whereTo.setWebPageURL("https://www.reddit.com");
        
        //playing around with the selector for JSOUP
        crawly.getURLLinks(whereTo, 0,  "link[href]");
        crawly.getURLLinks(whereTo, 0,  "a[href]");
        crawly.getURLLinks(whereTo, 0,  "img[src$=.png]");
    }
}
