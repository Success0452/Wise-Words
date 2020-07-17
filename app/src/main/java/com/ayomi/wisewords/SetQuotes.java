package com.ayomi.wisewords;

public class SetQuotes {
    private String Name;
    private String Quotes;

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

    public SetQuotes() {

    }

    public SetQuotes(String name, String quotes) {
        Name = name;
        Quotes = quotes;
    }

}
