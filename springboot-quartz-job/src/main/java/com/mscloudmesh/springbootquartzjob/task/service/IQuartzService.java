package com.mscloudmesh.springbootquartzjob.task.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mscloudmesh.springbootquartzjob.common.constant.Result;
import com.mscloudmesh.springbootquartzjob.task.entity.Quartz;
import com.mscloudmesh.springbootquartzjob.task.entity.QuartzDTO;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kevin
 * @date 2019/12/18
 */
public interface IQuartzService extends IService<Quartz> {
    public long getQuartCount() throws  Exception;
    public IPage<Quartz> getQuartzPage(QuartzDTO dto);
    public Result getDetail(Long id) throws  Exception;
}
