package com.autoyol.api.vo;

public class ResourceVo {
	
	/**
	 * 资源ID
	 */
	private Integer id;
	/**
	 * 方法名
	 */
    private String method;
	/** 
	 * URL地址
	 */
    private String url;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
