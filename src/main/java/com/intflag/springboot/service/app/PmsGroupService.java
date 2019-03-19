package com.intflag.springboot.service.app;

import com.intflag.springboot.common.entity.PageBean;
import com.intflag.springboot.common.entity.StatusResult;
import com.intflag.springboot.entity.app.PmsGroup;

/**
 * @author 刘国鑫QQ1598749808
 * @date 2019-03-18 23:48:29
 * @Description 机构业务层接口
 * @version V1.0
 */
public interface PmsGroupService {

	/**
	 * 添加资源权限
	 * 
	 * @param pmsGroup
	 * @return
	 */
	StatusResult add(PmsGroup pmsGroup) throws Exception;

	/**
	 * 修改资源权限
	 * 
	 * @param pmsGroup
	 * @return
	 */
	StatusResult update(PmsGroup pmsGroup) throws Exception;

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	StatusResult findById(String id) throws Exception;

	/**
	 * 分页
	 * 
	 * @param pageBean
	 * @return
	 */
	PageBean pageQuery(PageBean pageBean) throws Exception;

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	StatusResult delete(String ids);

}