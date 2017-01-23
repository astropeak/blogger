package com.aspk.blogger;

/**
   * Represent a blogging server. Wrap as two methods: push an artical to that server, fetch an artical from that server
   */
public class Blogger implements Pusher, Fetcher {
  /* {src_lang=Java}*/


  public void push(Artical art){

  }

  public Artical fetch(int count, int offset){
      return new HtmlArtical("aaa");
  }
}