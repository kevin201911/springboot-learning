package com.mscloudmesh.springbootquartzjob.task.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mscloudmesh.springbootquartzjob.task.entity.Quartz;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kevin
 * @date 2019/12/18
 */
@Component
public interface QuartzMapper extends BaseMapper<Quartz> {
    public long getQuartCount();
    IPage<Quartz> getQuartzListPage(Page page, @Param("keyword") String keyword);
}
