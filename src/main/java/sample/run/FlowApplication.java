/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.hateoas.UriTemplate;
import org.springframework.hateoas.hal.CurieProvider;
import org.springframework.hateoas.hal.DefaultCurieProvider;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Configuration
@EnableAutoConfiguration
public class FlowApplication extends SpringBootServletInitializer {
	
	public static String CURIE_NAMESPACE = "flow";
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(FlowApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FlowApplication.class);
	}
	
	@Configuration
	@EnableAsync
	@EnableAutoConfiguration
	@ComponentScan(includeFilters = @Filter(Service.class), useDefaultFilters = false)
	static class ApplicationConfiguration {

	}

	/**
	 * Web specific configuration.
	 * 
	 * @author Oliver Gierke
	 */
	@Configuration
	@Import({ ApplicationConfiguration.class, RepositoryRestMvcConfiguration.class })
	@ComponentScan(excludeFilters = @Filter({ Service.class, Configuration.class }))
	static class WebConfiguration {

		@Bean
		public CurieProvider curieProvider() {
			return new DefaultCurieProvider(CURIE_NAMESPACE, new UriTemplate("http://localhost:8080/rels/{rel}"));
		}
	}
}
