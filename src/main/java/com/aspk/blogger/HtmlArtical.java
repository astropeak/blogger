package com.aspk.blogger;

import java.util.Map;
import java.nio.file.*;
public class HtmlArtical implements Artical {
    /* {src_lang=Java}*/


    String content;
    String title;
    public HtmlArtical(String content) {
        this(content, "No title");
    }
    public HtmlArtical(String content, String title) {
        this.content = content;
        this.title = title;
    }
    public String getContent() {
        // String content = new String(Files.readAllBytes(Paths.get(file)));
        return content;
    }

    public String getTitle(){
        return title;
    }

    // public Map<Strin getMedia(){
    //     return new HashMap

    // }



}