package com.aspk.blogger;

/** 
 *  Fetch an artical from somewhere, e.g. wordpress.
 */
public interface Fetcher {
    /* {src_lang=Java}*/

    /**
      Fetch articals
    */
    public Artical fetch(int count, int offset);

}