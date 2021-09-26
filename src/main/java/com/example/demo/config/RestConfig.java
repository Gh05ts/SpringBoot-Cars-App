package com.example.demo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;
import org.glassfish.jersey.servlet.ServletProperties;
//import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;
//import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.glassfish.jersey.servlet.WebServletConfig;
import org.glassfish.jersey.servlet.WebFilterConfig;
import org.glassfish.jersey.servlet.WebComponent;
import com.example.demo.resource.CarsResource;

//@Configuration
@Component
public class RestConfig extends ResourceConfig {

	public RestConfig(Class<?>...classes) {
//		packages();
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
		register(JspMvcFeature.class);
		register(CarsResource.class);
		property(JspMvcFeature.TEMPLATE_BASE_PATH, "//WEB-INF/jsp");
	}
}
