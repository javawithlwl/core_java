package com.careerit.cj.innerclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Folder{
    int id;
    String name;
    Folder folder;

}
public class FolderStructureExample {
  public static void main(String[] args) {
      Folder f1 = new Folder(1001,"Root",null);
    Folder f2 = new Folder(1002,"Child1",null);
    Folder f3 = new Folder(1021,"SubChild",null);
    Folder f4 = new Folder(1003,"SubChild-child",null);
    f1.setFolder(f2);
    f2.setFolder(f3);
    f3.setFolder(f4);
    // Print all the folder name
    List<String> fname = new ArrayList<>();
    getNames(f1,fname);
    System.out.println(fname);

  }
  private static void getNames(Folder f,List<String> names){
        if(f!=null){
           names.add(f.getName());
           getNames(f.folder,names);
        }
  }
}
