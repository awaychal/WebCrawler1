package org.example;

public class Main {
    public static void main(String[] args) {

        WebCrawler webCrawler = new WebCrawler();
        webCrawler.getPageLinks("https://monzo.com/");
    }
}