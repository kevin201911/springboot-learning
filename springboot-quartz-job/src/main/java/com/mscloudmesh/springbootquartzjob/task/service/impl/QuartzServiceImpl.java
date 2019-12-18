package com.mscloudmesh.springbootquartzjob.task.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mscloudmesh.springbootquartzjob.common.constant.Result;
import com.mscloudmesh.springbootquartzjob.task.entity.Quartz;
import com.mscloudmesh.springbootquartzjob.task.entity.QuartzDTO;
import com.mscloudmesh.springbootquartzjob.task.mapper.QuartzMapper;
import com.mscloudmesh.springbootquartzjob.task.service.IQuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kevin
 * @date 2019/12/18
 */
@Service
public class QuartzServiceImpl extends ServiceImpl<QuartzMapper, Quartz> implements IQuartzService {

    @Autowired
    private QuartzMapper quartzMapper;


    @Override
    public long getQuartCount() throws Exception {
        return quartzMapper.getQuartCount();
    }

    @Override
    public IPage<Quartz> getQuartzPage(QuartzDTO dto) {
        Page<Quartz> page = new Page<>();
        if(!StringUtils.isEmpty(dto.getPageNum())){
            page.setCurrent(dto.getPageNum());
        }
        if(!StringUtils.isEmpty(dto.getPageSize())){
            page.setSize(dto.getPageSize());
        }
        IPage<Quartz> quartzListPage = quartzMapper.getQuartzListPage(page, dto.getKeyword());
        System.out.println("data="+JSON.toJSONString(quartzListPage));
        return quartzListPage;
    }

    @Override
    public Result getDetail(Long id) throws Exception {
        Quartz quartz = this.getOne(new QueryWrapper<Quartz>().lambda().eq(Quartz::getId,id));
        return Result.ok(quartz);
    }
}
