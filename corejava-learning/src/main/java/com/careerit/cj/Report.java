package com.careerit.cj;

import java.util.List;


public class Report {
  private Long id;
  private String name;
  private List<Object> data;
  public Report(Long id,String name,List<Object> data){
      this.id = id;
      this.name = name;
      this.data = data;
  }

  public void showReport(){

    System.out.println("Id :"+id);
    System.out.println("Name :"+name);
    System.out.println("-".repeat(100));
    for(Object obj:data){
      String value ="";
      if(obj instanceof Number){
        Number num = (Number)obj;
        value = String.format("%.2f",num.floatValue());
      }else{
        value = obj.toString();
      }
      System.out.println(value);
    }
    System.out.println("-".repeat(100));
  }

  public static void main(String[] args) {
      Report report = new Report(1001L,"Sample",List.of(123,"Dummy Value",4570.987));
      report.showReport();
  }
}
