package com.aspk.blogger;

abstract public class XmlRpcBlogger extends Blogger implements Pusher, Fetcher {
    /* {src_lang=Java}*/

    XmlRpcClient xmlRpc;


    public XmlRpcBlogger (){

    }
    public XmlRpcBlogger (XmlRpcClient xmlRpc) {
        this.xmlRpc = xmlRpc;
    }

    // works line a template method
    public void push(Artical art) {
        // HtmlParser parser = new HtmlParser(art.getContent());

        // parser.iterateElement(actionUploadFile);

        // xmlRpc.uploadContent(parser.getText());
        xmlRpc.uploadContent(art.getContent());
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