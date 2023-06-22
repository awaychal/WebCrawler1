package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class WebCrawler {

    private HashSet<String> urlLink;

    public WebCrawler(){
        urlLink = new HashSet<String>();
    }

    public void getPageLinks(String url){

        if(!urlLink.contains(url) && url.startsWith("https://monzo.com")){
            try{
                if(urlLink.add(url)){
                    System.out.println(url);
                }

                Document doc = Jsoup.connect(url).get();

                Elements availableLinksOnPage = doc.select("a[href]");

                for(Element element:availableLinksOnPage){
                    getPageLinks(element.attr("abs:href"));
                }
            }catch (IOException e){
                System.out.println("URL :"+e.getMessage());
            }
        }
    }

}
