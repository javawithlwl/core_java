package com.careerit.cj.reflection;

public class TaskManager {
  private volatile static TaskManager obj;
  private TaskManager() {
  }
  public static TaskManager getInstance() {
    synchronized (TaskManager.class) {
      if (obj == null) {
        obj = new TaskManager();
      }
    }
    return obj;
  }
}
