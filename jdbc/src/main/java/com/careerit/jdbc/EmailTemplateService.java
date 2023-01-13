package com.careerit.jdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmailTemplateService {


      public void createTemplate(EmailTemplate template){
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = ConnectionUtil.getConnection();
            st = con.prepareStatement(DbQueries.ADD_TEMPLATE);
            st.setString(1,template.getName());
            st.setString(2,template.getBody());
            int count = st.executeUpdate();
            System.out.println("Email template added :"+count);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(st,con);
        }
      }
      public void updateTemplateBody(Long id,String body){

      }
      public void deleteTemplate(Long id){

      }
      public List<EmailTemplate> getTemplates(){
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        List<EmailTemplate> list = new ArrayList<>();
        try{
          con = ConnectionUtil.getConnection();
          st = con.createStatement();
          rs = st.executeQuery("select id,name,body from email_templates");
          if(rs.next()){
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            String body = rs.getString("body");
            list.add(EmailTemplate.builder().id(id).name(name).body(body).build());
          }
        }catch (SQLException e){
          e.printStackTrace();
        }finally {
          ConnectionUtil.close(st,con);
        }
        return list;
      }

      public EmailTemplate getTemplateByName(String name){
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        try{
          con = ConnectionUtil.getConnection();
          st = con.prepareStatement("select id,name,body from email_templates where name=?");
          st.setString(1,name);
          rs = st.executeQuery();
          if(rs.next()){
              Long id = rs.getLong("id");
              String tname = rs.getString("name");
              String body = rs.getString("body");
              return EmailTemplate.builder().id(id).name(tname).body(body).build();
          }
        }catch (SQLException e){
          e.printStackTrace();
        }finally {
          ConnectionUtil.close(st,con);
        }
        throw new IllegalArgumentException("For the given name, there are no templates");
      }

}
