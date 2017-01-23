package com.aspk.blogger;

import java.io.File;

import java.util.*;
import java.io.*;
import java.net.*;
import redstone.xmlrpc.*;

// import wp.xmlrpc.mwa.bean.*;
// import wp.xmlrpc.mwa.client.*;
// import wp.xmlrpc.mwa.enums.*;
// import wp.xmlrpc.mwa.exception.*;

import org.apache.xmlrpc.XmlRpcException;
// import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import org.apache.commons.io.IOUtils;
// import org.apache.commons.codec.binary.Base64;
import java.util.Base64;

/**
 * Metaweblog xmlrpc client. Now works for wordpress and cnblogs.
 */

public class MetaweblogXmlRpcClient  implements XmlRpcClient {
    /* {src_lang=Java}*/
    // MetaWeblog metaweblog;
    String xmlRpcUrl;
    String username;
    String password;
    XmlRpcClientConfigImpl xmlRpcConfig;
    public MetaweblogXmlRpcClient (Account account) throws MalformedURLException{
        this(account.getUsername(), account.getPassword(), account.getXmlRpcUrl());
    }


    public MetaweblogXmlRpcClient (String username, String password, String xmlRpcUrl) throws MalformedURLException{
        // this.wordpress = new Wordpress(username, password, xmlRpcUrl);
        // MetaWeblogConfig mwc = new MetaWeblogConfig(xmlRpcUrl, username, password);
        // this.metaweblog = new MetaWeblogClient(mwc);
        this.xmlRpcUrl= xmlRpcUrl;
        this.username = username;
        this.password = password;
        xmlRpcConfig  = new XmlRpcClientConfigImpl();
        xmlRpcConfig.setServerURL(new URL(xmlRpcUrl));
    }

    public int uploadContent (String content)
    // throws InsufficientRightsException, net.bican.wordpress.exceptions.InvalidArgumentsException, net.bican.wordpress.exceptions.ObjectNotFoundException, redstone.xmlrpc.XmlRpcFault
    {
        // String postId = "-1";
        // Post recentPost = new Post();
        // recentPost.setDescription(content);
        // recentPost.setTitle("No title");
        // recentPost.setPostId(1234);
        // // recentPost.setPost_content(content);

        // //TODO: convert the content, so that all local media are all first be uploaded, and the url be replaced.

        // try {
        //     System.out.println("upload content...");
        //     postId = metaweblog.newPost(recentPost, Publish.TRUE);
        //     System.out.println("new post page id: " + postId);
        // } catch (Exception ex) {
        //     System.out.println("Error: post failed. ex: " + ex);
        // }


        org.apache.xmlrpc.client.XmlRpcClient client = new org.apache.xmlrpc.client.XmlRpcClient();
        client.setConfig(xmlRpcConfig);
 
        // Params needed: blogid, username, password, struct, publish
        // First create the fourth parameter, struct:
        Map<String, String> m = new HashMap<String, String>();
        m.put("title", "Hello World ");
        // m.put("link", "http://www.indiwiz.com/");
        m.put("description", content);
 
        Object[] params = new Object[]{"default", username, password, m, true};
 
        try {
            System.out.println("upload content...");
            // String ret = "TODO: should be modified.";
            String ret = (String) client.execute("metaWeblog.newPost", params);
            System.out.println("new post: "+ret);
            // System.out.println("new post page id: " + postId);
        } catch (Exception ex) {
            System.out.println("Error: post failed. ex: " + ex);
        }
        return 100;
    }

    public String uploadFile(String file){
        // return "No-link";
        org.apache.xmlrpc.client.XmlRpcClient client = new org.apache.xmlrpc.client.XmlRpcClient();
        client.setConfig(xmlRpcConfig);

        try {
            // Params needed: blogid, username, password, struct, publish
            // First create the fourth parameter, struct:
            Map<String, Object> m = new HashMap<String, Object>();
            m.put("name", file.replaceAll("/", "-"));
            m.put("type", "image/png");
            // m.put("link", "http://www.indiwiz.com/");

            InputStream in = new FileInputStream(file);
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            final byte[] buffer = new byte[1024];
            InputStream mediaTemp = new FileInputStream(file);
            int len = mediaTemp.read(buffer);
            while (len != -1) {
                out.write(buffer, 0, len);
                len = mediaTemp.read(buffer);
            }

            // m.put("bits", Base64.getEncoder().encode(IOUtils.toByteArray(in)));
            m.put("bits",out.toByteArray());

            Object[] params = new Object[]{"astropeak", username, password, m};

            System.out.println("upload file..." + file);

            Map<String, Object> rst = (Map<String, Object>) client.execute("metaWeblog.newMediaObject", params);
            System.out.println("upload result: "+rst.get("url"));
            return (String)rst.get("url");
        } catch (Exception ex) {

            System.out.println("Error: upload file failed. ex: " + ex);
            return "No-link";
        }
    }
}