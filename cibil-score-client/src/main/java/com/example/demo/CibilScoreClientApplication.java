package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.client.FindCibilScore;
import com.example.demo.entity.CibilScore;

@SpringBootApplication
public class CibilScoreClientApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx=	SpringApplication.run(CibilScoreClientApplication.class, args);
	
	
	FindCibilScore scoreFinder = ctx.getBean(FindCibilScore.class);
	
	CibilScore score = ctx.getBean(CibilScore.class);
	
	 score.setPanId("kol2049wxy");
	 score.setCardHolderName("Jaydeep");
	 score.setPinCode(204050);
	 
	
	System.out.println(scoreFinder.getScores());
	
	System.out.println(scoreFinder.addScore(score));
	
	
	
	ctx.close();
	}

}
