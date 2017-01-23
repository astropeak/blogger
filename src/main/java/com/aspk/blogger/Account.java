package com.aspk.blogger;

public interface Account {
    /**
     *  return artical content as html string.
     */

    String getUsername();
    String getPassword();
    String getXmlRpcUrl();
}