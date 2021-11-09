package com.taimei.service;

import com.dump.model.remote.Duration;
import com.dump.model.remote.GraphQLQuery;
import com.dump.model.remote.GraphQLResp;
import com.dump.model.remote.ServiceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class ApmAlarmService {

    private static final Logger log = LoggerFactory.getLogger(ApmAlarmService.class);

    @Resource
    private RestTemplate restTemplate;

    @Value("${graphqlPath}")
    private String graphqlPath;

    public List<String> getAllServiceName(){
        String query = "query queryServices($duration: Duration!,$keyword: String!) {\n    data: searchServices(duration: $duration, keyword: $keyword) {\n      id\n      name\n    }\n  }";
        // GraphQL variables
        LocalDateTime end = LocalDateTime.now();
        LocalDateTime start = end.minusMinutes(15);
        Duration duration = new Duration(start, end, "MINUTE");
        Map<String, Object> variables = new HashMap<>();
        variables.put("duration", duration);
        variables.put("keyword", "");
        // GraphQL
        GraphQLQuery graphQLQuery = new GraphQLQuery(query, variables);

        try {
            ParameterizedTypeReference<GraphQLResp<ServiceVO>> typeReference = new ParameterizedTypeReference<GraphQLResp<ServiceVO>>() {
            };
            HttpEntity<GraphQLQuery> requestEntity = new HttpEntity<>(graphQLQuery);
            ResponseEntity<GraphQLResp<ServiceVO>> resp = restTemplate.exchange(graphqlPath, HttpMethod.POST, requestEntity, typeReference);
            if (resp.getStatusCode() == HttpStatus.OK) {
                GraphQLResp<ServiceVO> data = resp.getBody();
                if (data != null && data.getData() != null) {
                    List<ServiceVO> allServicesTemp = data.getData().getData();
                    // 服务去重
                    List<String> allServices = allServicesTemp.stream().map(ServiceVO::getName).distinct()
                            .collect(Collectors.toList());
                    log.info("Get {} services", allServices.size());
                    return allServices;
                }
            }
            log.error("Get service failed, not found service");
        } catch (Exception e) {
            log.error("Get services failed, query {}, duration {}", query, duration, e);
        }
        return null;
    }

}
