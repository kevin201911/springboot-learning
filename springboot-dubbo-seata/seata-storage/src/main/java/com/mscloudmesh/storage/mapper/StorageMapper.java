package com.mscloudmesh.storage.mapper;


import com.mscloudmesh.storage.entity.Storage;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageMapper {

    int decreaseStorage(Storage storage);
}
