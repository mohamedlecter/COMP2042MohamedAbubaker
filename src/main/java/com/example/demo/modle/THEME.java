package com.example.demo.modle;

public enum THEME {
//    BLUE("test"),

    // change this to buttons 
    GREEN("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAQMAAADCCAMAAAB6zFdcAAAAA1BMVEUksk7fqXNLAAAASElEQVR4nO3BMQEAAADCoPVPbQwfoAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAIC3AcUIAAFkqh/QAAAAAElFTkSuQmCC"),
    ORANGE("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ87qxCZjstb8mHpJCRT7r3yfWYC5sSf50Mqw&usqp=CAU");

    private final String url;

    private THEME(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }


}