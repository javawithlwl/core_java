package com.careerit.cj.collections.map;

import java.io.IOException;
import java.util.Properties;

class ResourceLoader {
  static Properties properties = new Properties();
  static {
    try {
      properties.load(ReadingProperties.class.getResourceAsStream("/db.properties"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  public static Object getValue(String property) {
    return properties.get(property);
  }
}

public class ReadingProperties {

  public static void main(String[] args) throws IOException {

    Object banner = ResourceLoader.getValue("banner");
    System.out.println(banner);
  }
}
