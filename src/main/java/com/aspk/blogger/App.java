package com.aspk.blogger;

import java.nio.file.*;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main (String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );

        Account account = new WordpressAccount("account-cnblogs.xml");
        // Account account = null;
        // Account account = new CnblogsAccount();
        // XmlRpcClient xmlRpcClient = new WordpressXmlRpcClient(account);
        XmlRpcClient xmlRpcClient = new MetaweblogXmlRpcClient(account);

        // String content = new String(Files.readAllBytes(Paths.get("a-test-artical/index.html")));
        // HtmlRenderer renderer = new HtmlRenderer();
        // Artical  artical= new HtmlArtical(content, "a-test-artical", "A test page", renderer);

        String content = new String(Files.readAllBytes(Paths.get("a-test-markdown-artical/index.md")));
        HtmlRenderer renderer = new Markdown2HtmlRenderer();
        Artical  artical= new HtmlArtical(content, "a-test-markdown-artical", "A test page", renderer);

        Blogger blogger= new XmlRpcBlogger(xmlRpcClient);
        blogger.push(artical);
    }
}
