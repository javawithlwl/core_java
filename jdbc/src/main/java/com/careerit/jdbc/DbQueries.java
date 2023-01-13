package com.careerit.jdbc;

public class DbQueries {
  public static final String UPDATE_TEMPLATE="update email_template set body=? where id=?";
  public static final String ADD_TEMPLATE="insert into email_template(name,body) values(?,?)";
  public static final String GET_MOVIE_DETAILS= "select * from film_report";
  private DbQueries(){

  }
}
