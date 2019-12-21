package com.mscloudmesh.storage.controller;

import com.mscloudmesh.common.dto.StorageDTO;
import com.mscloudmesh.common.dubbo.StorageDubboService;
import com.mscloudmesh.storage.service.StorageService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin
 * @version
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    StorageService storageService;

    @Reference
    StorageDubboService storageDubboService;

    @PostMapping("dec_storage")
    public int decreaseStorage(@RequestBody StorageDTO storage){
        return storageDubboService.decreaseStorage(storage);
    }
}
