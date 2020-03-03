package com.autoyol.api;

import com.autoyol.api.filter.JwtTFilter;
import com.autoyol.api.filter.PublicFilter;
import com.autoyol.api.filter.TokenFilter;
import com.autoyol.api.service.impl.DBTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


//@EnableZuulProxy
@SpringBootApplication
public class ApiWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiWebServiceApplication.class, args);
	}

	@Autowired
    @Bean
	public TokenFilter tokenFilter(DBTokenService dbTokenService){
		TokenFilter filter = new TokenFilter(dbTokenService);
		return filter;
	}

	@Bean
	public JwtTFilter jwtTFilter(){
		JwtTFilter filter = new JwtTFilter();
		return filter;
	}

	@Bean
	public PublicFilter publicFilter(DBTokenService dbTokenService){
		return new PublicFilter(dbTokenService);
	}

//	@Bean
//	public CustomErrorFilter errorFilter(){
//		return new CustomErrorFilter();
//	}

}
