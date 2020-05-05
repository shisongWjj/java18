package com.autoyol.api.dao;

import com.autoyol.api.entity.MemViewEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TokenMapper {
    /**
     * 获取会员的memNo
     * @param token
     * @return
     */
    Integer getMemNo(String token);

    MemViewEntity getMemInfo(String token);
}
