package com.aspk.blogger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

/**
 * Represent a xmlrpc(metaweblog) based blogging server.
 * Use XmlRpcClient to contact to the server
 */

public class XmlRpcBlogger extends Blogger implements Pusher, Fetcher {
    /* {src_lang=Java}*/

    XmlRpcClient xmlRpc;


    public XmlRpcBlogger (){

    }
    public XmlRpcBlogger (XmlRpcClient xmlRpc) {
        this.xmlRpc = xmlRpc;
    }

    // works line a template method
    /**
     * First upload all images of the artical, then upload the content. Image's path is in artical's img tag.
     */
    public void push(Artical art) {
        // HtmlParser parser = new HtmlParser(art.getContent());
        Document doc = Jsoup.parse(art.getContent());
        Elements imgs = doc.getElementsByTag("img");

        // System.out.println("Html content: " + doc.outerHtml());

        for (Element img : imgs) {
            String imgSrc = img.attr("src");
            String url = xmlRpc.uploadFile(art.getMediaRootDir() +"/"+ imgSrc);
            System.out.println("change image src "+imgSrc + " to " + url);
            img.attr("src", url);
        }

        // System.out.println("Html content: " + doc.outerHtml());

        xmlRpc.uploadContent(doc.outerHtml());
    }

    // Sub class should implement below two methods.
    // But maybe we can provide a implementation
    // use composition is much better.
    // abstract String uploadFile(File file);
    // abstract void uploadContent(String content);

    // upload file and replace url
    // private void actionUploadFile(Element e) {
    //     if (e.getTag() == "img" || e.getTag() == "a") {
    //         String url = xmlRpc.uploadFile(e.getSrc());
    //         e.setSrc(url);
    //     }
    // }
}