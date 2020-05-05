package com.autoyol.api;
/*
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.refresh.ContextRefresher;*/
import org.springframework.stereotype.Component;

@Component
public class ApolloRefreshConfig {
   private final static Logger logger = LoggerFactory.getLogger(ApolloRefreshConfig.class);


 /*   @Autowired
    private ContextRefresher refresher;



    @ApolloConfigChangeListener({"application"})
    private void onChange(ConfigChangeEvent changeEvent) {
            logger.info("before refresh ");
            refresher.refresh();
            logger.info("after refresh");

    }*/
}
