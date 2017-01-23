package com.aspk.blogger;

import java.util.Map;
import java.nio.file.*;

/**
   A simple implementation of html artical. Use HtmlRenderer to render the content to html content
*/
public class HtmlArtical implements Artical {
    /* {src_lang=Java}*/


    String content;
    String title;
    String mediaRootDir;
    HtmlRenderer renderer;
    public HtmlArtical(String content) {
        this(content, ".", "No title", new HtmlRenderer());
    }

    public HtmlArtical(String content, String mediaRootDir) {
        this(content,  mediaRootDir, "No title", new HtmlRenderer());
    }
    public HtmlArtical(String content, String mediaRootDir, String title, HtmlRenderer renderer) {
        this.content =  content;
        this.title = title;
        this.mediaRootDir = mediaRootDir;
        this.renderer = renderer;
    }
    public String getContent() {
        return renderer.render(content);
    }


    public String getTitle(){
        return title;
    }

    public String getMediaRootDir(){
        return mediaRootDir;
    }
}