package com.mscloudmesh.mybatis.controller;



import com.mscloudmesh.mybatis.domain.entity.MpUser;
import com.mscloudmesh.mybatis.service.MpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @Author: kevin
 * @Date: 2019/12/23
 */
@RestController
@RequestMapping("/mp-user")
public class MpUserController {

    @Autowired
    private MpUserService mpUserService;

    /**
     * 添加一个新用户
     * @Author: kevin
     * @Date: 2019/12/23
     */
    @GetMapping("/add")
    public Object post() {
        MpUser mpUser = new MpUser();
        mpUser.setUsername("yuan");
        mpUser.setAddress("广东深圳");
        mpUser.setOpenid("openid");
        mpUserService.save(mpUser);
        return "add";
    }

    /**
     * 通过id获取用户
     *
     * @Author: kevin
     * @Date: 2019/12/23
     */
    @GetMapping("/{id}")
    public Object get(@PathVariable Long id) {
        return mpUserService.getById(id);
    }

    /**
     * 通过id删除用户
     *
     * @Author: kevin
     * @Date: 2019/12/23
     */
    @GetMapping("/del/{id}")
    public Object del(@PathVariable Long id) {
        mpUserService.removeById(id);
        return "del";
    }

}
