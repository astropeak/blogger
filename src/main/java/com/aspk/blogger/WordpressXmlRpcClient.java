package com.aspk.blogger;

import java.io.File;

import net.bican.wordpress.*;
import net.bican.wordpress.configuration.*;
import net.bican.wordpress.example.*;
import net.bican.wordpress.exceptions.*;
import net.bican.wordpress.util.*;
import java.util.*;
import java.io.*;
import java.net.*;
import redstone.xmlrpc.*;

public class WordpressXmlRpcClient  implements XmlRpcClient {
    /* {src_lang=Java}*/
    Wordpress wordpress;
    public WordpressXmlRpcClient (String username, String password, String xmlRpcUrl) throws MalformedURLException{
        this.wordpress = new Wordpress(username, password, xmlRpcUrl);
    }

    public int uploadContent (String content)
    // throws InsufficientRightsException, net.bican.wordpress.exceptions.InvalidArgumentsException, net.bican.wordpress.exceptions.ObjectNotFoundException, redstone.xmlrpc.XmlRpcFault
    {
        int postId = -1;
        Post recentPost = new Post();
        recentPost.setPost_title("No title");
        recentPost.setPost_content(content);
        recentPost.setPost_status("publish");

        //TODO: convert the content, so that all local media are all first be uploaded, and the url be replaced.

        try {
            postId = wordpress.newPost(recentPost);
            System.out.println("new post page id: " + postId);
        } catch (Exception ex) {
            System.out.println("post failed. ex: " + ex);
        }

        return postId;
    }

    public String uploadFile(File file){
        return "aaa";
    }

}