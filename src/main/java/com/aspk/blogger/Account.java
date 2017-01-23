package com.aspk.blogger;

/**
   * Represent account infomation
   */
public interface Account {
    /**
     *  return artical content as html string.
     */

    String getUsername();
    String getPassword();
    String getXmlRpcUrl();
}