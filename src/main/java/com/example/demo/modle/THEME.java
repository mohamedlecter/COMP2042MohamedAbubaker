package com.example.demo.modle;

public enum THEME {
//    BLUE("test"),

    // change this to buttons 
    GREEN("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAQMAAADCCAMAAAB6zFdcAAAAA1BMVEUksk7fqXNLAAAASElEQVR4nO3BMQEAAADCoPVPbQwfoAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAIC3AcUIAAFkqh/QAAAAAElFTkSuQmCC"),
    ORANGE("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ87qxCZjstb8mHpJCRT7r3yfWYC5sSf50Mqw&usqp=CAU"),
    RED("https://media.istockphoto.com/photos/red-background-copy-space-picture-id911014882?b=1&k=20&m=911014882&s=612x612&w=0&h=8JNul86t0vbOUdBgQ3s9CXlbS-7LEFZol3rQzpQ6a0s=");

    private final String url;

    private THEME(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }


}