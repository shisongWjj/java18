package com.autoyol.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 资源菜单（用于URL拦截控制）
 * <p>对应sys_resources表</p>
 */
public class ResourceMdl implements Serializable{

	private static final long serialVersionUID = 5476701037271199925L;

	/** 主键  **/
	private Integer id;
	
	/** 资源名称（URL）  **/
	private String resourceName;
	
	/** 资源描述（中文名）  **/
	private String resourceDesc;
	
	/** 是否有效  **/
	private boolean enabled;
	
	/** 创建时间  **/
	private Date createTime;
	
	private String syscode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceDesc() {
		return resourceDesc;
	}

	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSyscode() {
		return syscode;
	}

	public void setSyscode(String syscode) {
		this.syscode = syscode;
	}

	@Override
	public String toString() {
		return "ResourceMdl [id=" + id + ", resourceName=" + resourceName + ", resourceDesc=" + resourceDesc
				+ ", enabled=" + enabled + ", createTime=" + createTime + ", syscode=" + syscode + "]";
	}
	
	
}
