package com.mscloudmesh.common.dubbo;


import com.mscloudmesh.common.dto.StorageDTO;

public interface StorageDubboService {

    int decreaseStorage(StorageDTO storage);
}
