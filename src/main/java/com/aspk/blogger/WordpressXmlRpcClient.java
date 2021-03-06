package com.aspk.blogger;

import net.bican.wordpress.*;

import java.io.*;
import java.net.*;

/**
 * wordpress's native xmlrpc client. Only works for wordpress
 */
public class WordpressXmlRpcClient  implements XmlRpcClient {
    /* {src_lang=Java}*/
    Wordpress wordpress;
    public WordpressXmlRpcClient (Account account) throws MalformedURLException{
        this(account.getUsername(), account.getPassword(), account.getXmlRpcUrl());
    }


    public WordpressXmlRpcClient (String username, String password, String xmlRpcUrl) throws MalformedURLException{
        this.wordpress = new Wordpress(username, password, xmlRpcUrl);
    }

    public int uploadContent(String content, String title)
    // throws InsufficientRightsException, net.bican.wordpress.exceptions.InvalidArgumentsException, net.bican.wordpress.exceptions.ObjectNotFoundException, redstone.xmlrpc.XmlRpcFault
    {
        int postId = -1;
        Post recentPost = new Post();


        recentPost.setPost_title(title);
        recentPost.setPost_content(content);
        recentPost.setPost_status("publish");

        //TODO: convert the content, so that all local media are all first be uploaded, and the url be replaced.

        try {
            System.out.println("upload content...");
            postId = wordpress.newPost(recentPost);
            System.out.println("new post page id: " + postId);
        } catch (Exception ex) {
            System.out.println("Error: post failed. ex: " + ex);
        }

        return postId;
    }

    public String uploadFile(String file){
        try {
            MediaItemUploadResult rst;
            InputStream in = new FileInputStream(file);
            System.out.println("upload file..." + file);
            rst = wordpress.uploadFile(in, file.replaceAll("/", "-"));

            // System.out.println("upload result: "+rst.getUrl()+" "+rst.getFile() + " "+rst.getId());
            System.out.println("upload result: "+rst);

            return rst.getUrl();
        } catch (Exception ex) {
            System.out.println("Error: upload file failed. ex: " + ex);
            return "No-link";
        }
    }
}