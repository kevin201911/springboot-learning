package com.mscloudmesh.springbootzookeeeperlock.vo;


import com.mscloudmesh.springbootzookeeeperlock.enums.RetCode;

/**

 * @author kevin
 * @date 2019/12/10
 */
public class ResultVo<T> {
 
   public int code;
 
   private String msg;
 
   private T data;
 
   public ResultVo<T> setCode(RetCode retCode) {
      this.code = retCode.code;
      return this;
   }
 
   public int getCode() {
      return code;
   }
 
   public ResultVo<T> setCode(int code) {
      this.code = code;
      return this;
   }
 
   public String getMsg() {
      return msg;
   }
 
   public ResultVo<T> setMsg(String msg) {
      this.msg = msg;
      return this;
   }
 
   public T getData() {
      return data;
   }
 
   public ResultVo<T> setData(T data) {
      this.data = data;
      return this;
   }
 
}