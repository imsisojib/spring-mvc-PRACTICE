package spring_jdbc_crud.initialization;

import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(MyRootConfig.class);
		rootContext.refresh();
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		AnnotationConfigWebApplicationContext myServletContext = new AnnotationConfigWebApplicationContext();
		myServletContext.register(MyServletConfig.class);
		
		ServletRegistration.Dynamic registerer = servletContext.addServlet("servlet",
				new DispatcherServlet(myServletContext));
		registerer.setLoadOnStartup(1);
		registerer.addMapping("/");
		
	}
	
	
}
