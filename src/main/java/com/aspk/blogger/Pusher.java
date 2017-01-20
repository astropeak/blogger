package com.aspk.blogger;

/** 
 *  Push an artical to somewhere, e.g. wordpress.
 */
public interface Pusher {
  /* {src_lang=Java}*/


  public void push(Artical art);

}