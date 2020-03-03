package com.autoyol.api.service.impl;

import com.autoyol.api.dao.TokenMapper;
import com.autoyol.api.entity.MemViewEntity;
import com.autoyol.api.service.TokenService;
import com.autoyol.api.util.JsonMapper;
import com.autoyol.api.vo.VirtualMemInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.data.redis.core.StringRedisTemplate;*/
import org.springframework.stereotype.Service;

@Service
public class DBTokenService implements TokenService {
    private final static Logger logger = LoggerFactory.getLogger(DBTokenService.class);
    

   /* @Autowired
    private TokenMapper tokenMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;*/

    private static final String TOKEN_KEY_PREFIX="user:center:token:";

    private final JsonMapper jsonMapper = JsonMapper.nonDefaultMapper();

    @Override
    public boolean isValid(String token) {
        /*Integer memNo = tokenMapper.getMemNo(token);

        if(memNo!=null){
            return true;
        }*/
        return false;
    }

    @Override
    public Integer getMemNo(String token) {
        /*Integer memNo = tokenMapper.getMemNo(token);
        return memNo;*/
        return 1;
    }

    @Override
    public MemViewEntity getMemInfo(String token) {
        VirtualMemInfo virtualMemInfo = getRedisValue(buildKey(token));
        if(virtualMemInfo!=null){
            logger.info("virtualMemInfo is {}",virtualMemInfo);
            MemViewEntity viewEntity = new MemViewEntity();
            if(StringUtils.trimToNull(virtualMemInfo.getMemNo())!=null){
                viewEntity.setId(virtualMemInfo.getMemNo());
            }else {
                viewEntity.setId(virtualMemInfo.getVirtualNo());
            }
            viewEntity.setNickname(virtualMemInfo.getNickName());
            viewEntity.setRealName(virtualMemInfo.getNickName());
            viewEntity.setImagePath(virtualMemInfo.getHeadUrl());
            return viewEntity;
        }else {
           /* return tokenMapper.getMemInfo(token);*/
            MemViewEntity viewEntity = new MemViewEntity();
            return viewEntity;
        }
    }

    /**
     * 生成redis的key
     * @param token
     * @return
     */
    private String buildKey(String token){
        return TOKEN_KEY_PREFIX+token;
    }


    private VirtualMemInfo getRedisValue(String key){
       /* String value = redisTemplate.opsForValue().get(key);
        if(StringUtils.trimToNull(value)!=null){
            VirtualMemInfo memInfo=null;
            try{
                memInfo = jsonMapper.fromJson(value,VirtualMemInfo.class);
            }catch (Exception e){
                logger.warn("convert json: {} to VirtualMemInfo error",value);
            }
            return memInfo;
        }*/
        return null;
    }
}
