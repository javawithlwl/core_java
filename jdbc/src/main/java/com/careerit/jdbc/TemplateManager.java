package com.careerit.jdbc;

import javax.xml.transform.Templates;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateManager {

  public static void main(String[] args) {

    // Create template
    EmailTemplateService ets = new EmailTemplateService();
//      EmailTemplate templates = new EmailTemplate();
//      templates.setName("Account_Activation");
//      templates.setBody("Dear {{name}},\n\n\nCongratulations your account has been activated on {{activationDate}}.");
//      ets.createTemplate(templates);
    EmailTemplate obj = ets.getTemplateByName("Account_Activation");


    Map<String, String> map = new HashMap<>();
    map.put("name", "Krish");
    map.put("activationDate", LocalDate.now().toString());
    String body = obj.getBody();
    final String regex = "\\{\\{\\w+\\}\\}";
    final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    final Matcher matcher = pattern.matcher(body);
    while (matcher.find()) {
         String token = matcher.group(0);
         String tokenName = token.substring(2,token.length()-2);
         String value = map.get(tokenName);
         body = body.replace(token,value);
    }
    System.out.println(body);

  }
}
