package com.aspk.blogger;

import java.io.File;

/**
 * Represent a client part to a xmlrpc server.
 */
public interface XmlRpcClient  {
    /* {src_lang=Java}*/
    /**
     * upload content to a xmlrpc server. metaweblog.newPost. TODO: add more parameters, such as title
     * @param content  this is the html text that will be uploaded. It is the description field in the API
     * @return int the post id
     */
    int uploadContent(String content);
    /**
     * Upload a file. metaweblog.newMediaObject
     * @param file  the file path to be uploaded.
     * @return String the url where the file is saved in the server.
     */
    String uploadFile(String file);
}