package com.aspk.blogger;

/**
 *  Push an artical to somewhere, e.g. wordpress.
 */
public interface Pusher {
    /* {src_lang=Java}*/


    /**
       Push an artical to somewhere.
       @param art  The artical that should be pushed
    */
    public void push(Artical art);

}