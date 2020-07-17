package com.ayomi.wisewords;

public class Quotes {
    private String Name;
    private String Quotes;


    public Quotes() {
    }

    public Quotes(String Author, String Quote) {
        Name = Author;
        Quotes = Quote;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getQuotes() {
        return Quotes;
    }

    public void setQuotes(String quotes) {
        Quotes = quotes;
    }
}
