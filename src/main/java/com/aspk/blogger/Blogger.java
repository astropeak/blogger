package com.aspk.blogger;

public class Blogger implements Pusher, Fetcher {
  /* {src_lang=Java}*/


  public void push(Artical art){

  }

  public Artical fetch(int count, int offset){
      return new HtmlArtical("aaa");
  }
}