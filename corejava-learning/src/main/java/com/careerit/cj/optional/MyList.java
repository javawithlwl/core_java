package com.careerit.cj.optional;

public class MyList<T> {

  private Object[] obj;
  private int count = 0;

  public MyList() {
    obj = new Object[3];
  }

  public void add(T ele) {
    ensureCapacity();
    obj[count++] = ele;
  }
  public T get(int index){
      if(index >= 0 && index < count){
          return (T)obj[index];
      }
      throw new IndexOutOfBoundsException("Invalid index");
  }

  private void ensureCapacity() {
    if (count >= obj.length -1) {
      Object[] temp = new Object[obj.length + 3];
      System.arraycopy(obj, 0, temp, 0, obj.length);
      obj = temp;
    }
  }

  public int size() {
    return count;
  }

}
