package com.mscloudmesh.receive.service;


import com.mscloudmesh.receive.model.AccountChangeEvent;

/**
 * Created by Administrator.
 */
public interface AccountInfoService {

    //更新账户，增加金额
    public void addAccountInfoBalance(AccountChangeEvent accountChangeEvent);
}
