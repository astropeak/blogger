package com.aspk.blogger;

/**
 * wordpress's xmlrpc account
 */

public class WordpressAccount implements Account{
    // String file;
    AccountData ad;

    WordpressAccount(String file){
        ad = AccountData.newInstance(file);
        System.out.println("ad: "+ad);
    }

    public String getUsername() {
        return ad.getAccount().get("username");
    }
    public String getPassword() {
        return ad.getAccount().get("password");
    }
    public String getXmlRpcUrl(){
        return ad.getAccount().get("xmlRpcUrl");
    }
}