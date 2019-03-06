package com.intflag.springboot.controller.app;

import com.intflag.springboot.entity.admin.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intflag.springboot.common.entity.PageBean;
import com.intflag.springboot.common.entity.StatusResult;
import com.intflag.springboot.entity.app.PmsBlog;
import com.intflag.springboot.service.app.PmsBlogService;

import javax.servlet.http.HttpSession;

/**
 * @author 刘国鑫QQ1598749808
 * @version V1.0
 * @date 2019-02-24 15:01:23
 * @Description 公告管理管理
 */
@RestController
public class PmsBlogController {

    @Autowired
    private PmsBlogService pmsBlogService;

    /**
     * 分页
     */
    @GetMapping("/app/pmsBlogs")
    public PageBean pageQuery(PageBean pageBean) {
        try {
            //SecurityUtils.getSubject().checkPermission("pmsBlog-list");//权限校验，配置菜单后去掉注释即可
            return pmsBlogService.pageQuery(pageBean);
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return PageBean.noAuthority(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
            return PageBean.error(pageBean);
        }
    }

    /**
     * 前台分页
     */
    @GetMapping("/v1/app/pmsBlogs")
    public PageBean v1PageQuery(PageBean pageBean) {
        try {
            //SecurityUtils.getSubject().checkPermission("pmsBlog-list");//权限校验，配置菜单后去掉注释即可
            return pmsBlogService.pageQuery(pageBean);
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return PageBean.noAuthority(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
            return PageBean.error(pageBean);
        }
    }

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("/app/pmsBlog")
    public StatusResult add(PmsBlog pmsBlog, HttpSession session,String[] appendixIds) {
        try {
            //SecurityUtils.getSubject().checkPermission("pmsBlog-add");//权限校验，配置菜单后去掉注释即可
            //设置人员信息
            SysUser loginUser = (SysUser) session.getAttribute("loginUser");
            if (loginUser != null) {
                pmsBlog.setPublisher(loginUser.getNickname());
                pmsBlog.setUserId(loginUser.getUserId());
            }
            return pmsBlogService.add(pmsBlog,appendixIds);
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return StatusResult.error(StatusResult.NO_AUTHORITY);
        } catch (Exception e) {
            e.printStackTrace();
            return StatusResult.error(StatusResult.ADD_FAIL);
        }
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @GetMapping("/app/pmsBlog/{id}")
    public StatusResult findById(@PathVariable String id) {
        try {
            //SecurityUtils.getSubject().checkPermission("pmsBlog-find");//权限校验，配置菜单后去掉注释即可
            return pmsBlogService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return StatusResult.error(StatusResult.FIND_FAIL);
        }
    }
    /**
     * app根据ID查询
     *
     * @param id
     * @return
     */
    @GetMapping("/v1/app/pmsBlog/{id}")
    public StatusResult v1FindById(@PathVariable String id) {
        try {
            //SecurityUtils.getSubject().checkPermission("pmsBlog-find");//权限校验，配置菜单后去掉注释即可
            return pmsBlogService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return StatusResult.error(StatusResult.FIND_FAIL);
        }
    }

    /**
     * 修改
     *
     * @param pmsBlog
     * @return
     */
    @PutMapping("/app/pmsBlog")
    public StatusResult update(PmsBlog pmsBlog, HttpSession session) {
        try {
            //SecurityUtils.getSubject().checkPermission("pmsBlog-update");//权限校验，配置菜单后去掉注释即可
            //设置人员信息
            SysUser loginUser = (SysUser) session.getAttribute("loginUser");
            if (loginUser != null) {
                pmsBlog.setPublisher(loginUser.getNickname());
                pmsBlog.setUserId(loginUser.getUserId());
            }
            return pmsBlogService.update(pmsBlog);
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return StatusResult.error(StatusResult.NO_AUTHORITY);
        } catch (Exception e) {
            e.printStackTrace();
            return StatusResult.error(StatusResult.UPDATE_FAIL);
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/app/pmsBlog/{ids}")
    public StatusResult deleteBatch(@PathVariable("ids") String ids) {
        try {
            //SecurityUtils.getSubject().checkPermission("pmsBlog-delete");//权限校验，配置菜单后去掉注释即可
            return pmsBlogService.delete(ids);
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return StatusResult.error(StatusResult.NO_AUTHORITY);
        } catch (Exception e) {
            e.printStackTrace();
            return StatusResult.error(StatusResult.DELETE_FAIL);
        }
    }
}
