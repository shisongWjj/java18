package com.autoyol.api.service.impl;

import com.autoyol.api.entity.MemViewEntity;
import com.autoyol.api.service.TokenService;
import org.springframework.stereotype.Service;

@Service
public class CachedTokenService implements TokenService{


    @Override
    public boolean isValid(String token) {
        return false;
    }

    @Override
    public Integer getMemNo(String token) {
        return null;
    }

    @Override
    public MemViewEntity getMemInfo(String token) {
        return null;
    }
}
