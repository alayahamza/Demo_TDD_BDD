package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;

/**
 * @author halaya
 *
 */
@SpringBootApplication
public class Application {

	private static final String PATH = "/errors";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

		return (container -> {
			// route all errors towards /error .
			final ErrorPage errorPage = new ErrorPage(PATH);
			container.addErrorPages(errorPage);
		});
	}
}
