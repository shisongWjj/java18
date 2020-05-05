package com.autoyol.api.service;

import com.autoyol.api.dao.ResourceMapper;
import com.autoyol.api.entity.ResourceMdl;
import com.autoyol.api.vo.ResourceResult;
import com.autoyol.api.vo.ResourceVo;
/*import com.google.gson.Gson;*/
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
/*import org.springframework.data.redis.core.StringRedisTemplate;*/
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AuthService {
	
	public static final String CAS_AUTH_RESOURCE = "casAuth:resource:";
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${authUrl}")
	private String authUrl;
	/*@Autowired
    private StringRedisTemplate redisTemplate;
	@Autowired
    private ResourceMapper resourceMapper;
	
	public boolean hasAuth(String method, String path, String loginId) {
    	boolean hasAuth = false;
    	try {
    		logger.info("filter path is {}", path);
            path = path.substring(path.indexOf("/", 2)).trim();
            logger.info("filter path is {}, method: {}, loginId: {}", path, method, loginId);
        	List<ResourceMdl> resources = resourceMapper.queryByUserId(loginId);
        	for (ResourceMdl resource : resources) {
    			String url = resource.getResourceName();
    			if(null == url) {
    				continue;
    			}
    			url = url.trim();
    			if(url.equals(path)) {
    				hasAuth = true;
    				break;
    			}
    			if(url.endsWith("/") && path.startsWith(url)) {
    				String str = path.replace(url, "");
    				if(str.indexOf("/")<=-1) {
    					hasAuth = true;
    					break;
    				}
    			}
    		}
        	if(!hasAuth) {
        		hasAuth = hasAuthNew(method, path, loginId);
        	}
		} catch (Exception e) {
			logger.error("hasAuth error. method: {}, path: {}, loginId: {}", method, path, loginId,e);
		}
    	return hasAuth;
    }*/

	/*private boolean hasAuthNew(String method, String path, String loginId) {
		ResourceResult result = getResourceByCache(loginId);
		if(null == result) {
			result = getResourceByUrl(loginId);
		}
		if(null == result) {
			return false;
		}
		List<ResourceVo> resources = result.getList();
		if(null==resources || resources.size()<1) {
			return false;
		}
		for(ResourceVo resource : resources) {
			String url = resource.getUrl();
			if(null == url) {
				continue;
			}
			String mtd = resource.getMethod();
			url = url.trim();
			boolean flag = false;
			if(StringUtils.isBlank(mtd)) {
				flag = true;
			} else if(mtd.trim().equalsIgnoreCase(method)) {
				flag = true;
			}
			if(flag && url.equals(path)) {
				return true;
			}
			if(flag && url.endsWith("/") && path.startsWith(url)) {
				String str = path.replace(url, "");
				if(str.indexOf("/")<=-1) {
					return true;
				}
			}
		}
		return false;
	}*/
	
	/*private ResourceResult getResourceByCache(String loginId) {
		try {
			String key = CAS_AUTH_RESOURCE + loginId;
			String value = redisTemplate.opsForValue().get(key);
			return new Gson().fromJson(value, ResourceResult.class);
		} catch (Exception e) {
			logger.error("getResourceByCache error. loginId: {}", loginId, e);
		}
		return null;
	}
	
	private ResourceResult getResourceByUrl(String loginId) {
		String url = authUrl+"/console/auth/resource/"+loginId;
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
			logger.info("refreshAuth success. url: {}, response: {}", url, response);
			return new Gson().fromJson(response.getBody(), ResourceResult.class);
		} catch (Exception e) {
			logger.error("refreshAuth error. url: {}", url, e);
		}
		return null;
	}*/

}
