package com.aspk.blogger;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
// import org.commonmark.renderer.html.HtmlRenderer;


/**
 * Render markdown to html
 */
public class Markdown2HtmlRenderer extends HtmlRenderer {
    /* {src_lang=Java}*/
    String render(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        org.commonmark.renderer.html.HtmlRenderer renderer = org.commonmark.renderer.html.HtmlRenderer.builder().build();
        return renderer.render(document);
    }
}

