package com.components;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ListeningProperties {
  private String url;
  InputStream inputStream;
  public ListeningProperties() throws IOException{
      try{
          Properties properties = new Properties();
          String fileName = "url.properties";
          inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
          if(inputStream!=null){
              properties.load(inputStream);
          } else {
              throw new FileNotFoundException(fileName + " not found!");
          }
          url = properties.getProperty("url");
      } catch (Exception e){
          System.out.println(e);
      } finally {
          inputStream.close();
      }
  }

    public String getUrl() {
        return url;
    }
}
