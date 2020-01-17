package com.autoyol.api.dao;

import com.autoyol.api.entity.ResourceMdl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ResourceMapper {

	/**
	 * 根据用户ID查询资源列表
	 * @param userId
	 * @return
	 */
	public List<ResourceMdl> queryByUserId(@Param("userId") String userId);
}
