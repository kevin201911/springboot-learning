package com.mscloudmesh.storage.service;


import com.mscloudmesh.common.dto.StorageDTO;

public interface StorageService {

    int decreaseStorage(StorageDTO storage);
}
