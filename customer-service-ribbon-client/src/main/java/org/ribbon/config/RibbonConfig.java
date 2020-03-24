package org.ribbon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RoundRobinRule;

public class RibbonConfig {
	
	@Autowired
    IClientConfig config;
	
  	 @Bean
	    public IRule ribbonRule(IClientConfig config) {
	        
		 //return new BestAvailableRule();
		 
		 IRule rule = new RoundRobinRule();
	               return rule;
	               
	    }
		
		@Bean
		 public IPing ping(IClientConfig config) {
			
			
			 return new PingUrl();
		}
	
	
}
