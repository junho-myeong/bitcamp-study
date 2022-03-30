package com.eomcs.mylist.controller;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResultMap {
  private String status;
  private Object data;
  @Override
  public String toString() {
    return "ResultMap [status=" + status + ", data=" + data + "]";
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public Object getData() {
    return data;
  }
  public void setData(Object data) {
    this.data = data;
  }

}
