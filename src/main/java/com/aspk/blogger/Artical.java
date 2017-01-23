package com.aspk.blogger;

import java.util.Map;

/**
 * Represent an artical to be pushed to a server.
 */
public interface Artical {
    /* {src_lang=Java}*/


    /**
     *  @return String  artical content as html string. Media files are in img's src property, relative path.
     */
    public String getContent();
    public String getTitle();
    /**
     * @return String  media files's root dir.
     */
    public String getMediaRootDir();


    // public Map getMedia();

}