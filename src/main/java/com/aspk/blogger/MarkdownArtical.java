package com.aspk.blogger;

import java.nio.file.*;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;


public class MarkdownArtical implements Artical {
    /* {src_lang=Java}*/


    String content;
    String title;
    String mediaRootDir;
    public MarkdownArtical(String content) {
        this(content, ".", "No title");
    }

    public MarkdownArtical(String content, String mediaRootDir) {
        this(content,  mediaRootDir, "No title");
    }
    // content is in markdonw format
    public MarkdownArtical(String content, String mediaRootDir, String title) {
        this.content = renderToHtml(content);
        this.title = title;
        this.mediaRootDir = mediaRootDir;
    }
    private String renderToHtml(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }
    public String getContent() {
        // String content = new String(Files.readAllBytes(Paths.get(file)));
        return content;
    }


    public String getTitle(){
        return title;
    }

    public String getMediaRootDir(){
        return mediaRootDir;
    }
}