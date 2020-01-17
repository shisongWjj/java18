package com.autoyol.api.service;

import com.autoyol.api.entity.MemViewEntity;

/**
 * 检查token是否是合法的token
 */
public interface TokenService {

    /**
     * 如果token合法返回true，否则返回false
     * @param token
     * @return
     */
    boolean isValid(String token);

    Integer getMemNo(String token);


    MemViewEntity getMemInfo(String token);


}
