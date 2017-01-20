package com.aspk.blogger;

import java.util.Map;

public interface Artical {
  /* {src_lang=Java}*/


  /** 
   *  return artical content as html string.
   */
  public String getContent();

  public String getTitle();

  public Map getMedia();

}