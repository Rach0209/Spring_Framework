package kr.co.greenart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.greenart.controller.MyInterceptor;


@Configuration
@EnableWebMvc // WebMVC를 사용할 수 있게 설정.
@ComponentScan("kr.co.greenart") // Bean으로 등록하기위해 @Component를 달아준 것들을 찾을 수 있게 ComponentScan을 달아주기
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private MyInterceptor interceptor;
	
	// file을 다루기 위해 pom에 의존성을 추가하고, MultipartResolver를 Bean등록 해주어야 한다.
	// Spring에서 type(MultipartResolver) 이 아닌 이름(commonsResolver()로 되어있었음)으로 찾아서 오류가 났었음
	// commonsResolver() ==>>> multipartResolver()로 변경
	// 문서에 정의되어 있음  create a bean with the id "multipartResolver"
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		return resolver;
	}
	
//	2개 Override addResourceHandlers, configureViewResolvers
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

//	forward시킬 view들을 등록하는 것.
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).addPathPatterns("/my/**");
	}
}
