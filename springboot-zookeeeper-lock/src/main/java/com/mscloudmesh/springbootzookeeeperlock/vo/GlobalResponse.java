package com.mscloudmesh.springbootzookeeeperlock.vo;


import com.mscloudmesh.springbootzookeeeperlock.enums.RetCode;

/**
 *
 * @author kevin
 * @date 2019/12/10
 */
public class GlobalResponse {
 
   private final static String SUCCESS = "success";
 
   public static <T> ResultVo<T> makeOKRsp() {
      return (ResultVo<T>) new ResultVo<>().setCode(RetCode.SUCCESS).setMsg(SUCCESS);
   }
 
   public static <T> ResultVo<T> makeOKRsp(T data) {
      return (ResultVo<T>) new ResultVo<>().setCode(RetCode.SUCCESS).setMsg(SUCCESS).setData(data);
   }
 
   public static <T> ResultVo<T> makeErrRsp(String message) {
      return (ResultVo<T>) new ResultVo<>().setCode(RetCode.FAIL).setMsg(SUCCESS);
   }
 
   public static <T> ResultVo<T> makeRsp(int code, String msg) {
      return (ResultVo<T>) new ResultVo<>().setCode(code).setMsg(msg);
   }
    
   public static <T> ResultVo<T> makeRsp(int code, String msg, T data) {
      return (ResultVo<T>) new ResultVo<>().setCode(code).setMsg(msg).setData(data);
   }
}