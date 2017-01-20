package com.aspk.blogger;

import java.io.File;

public interface XmlRpcClient  {
  /* {src_lang=Java}*/
    void uploadContent(String content);
    String uploadFile(File file);
}