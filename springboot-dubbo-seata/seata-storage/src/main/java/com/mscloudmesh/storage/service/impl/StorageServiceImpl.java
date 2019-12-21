package com.mscloudmesh.storage.service.impl;


import com.mscloudmesh.common.dto.StorageDTO;
import com.mscloudmesh.storage.entity.Storage;
import com.mscloudmesh.storage.mapper.StorageMapper;
import com.mscloudmesh.storage.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageMapper storageMapper;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int decreaseStorage(StorageDTO storageDTO) {

        logger.info("开始扣减库存。商品编号:{}",storageDTO.getCommodityCode());
        //异常回滚
       // int n=1/0;
        Storage storage = new Storage();
        BeanUtils.copyProperties(storageDTO,storage);
        return storageMapper.decreaseStorage(storage);
    }
}
