package app.server.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class CloudApplicationContextInitializer implements
		ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
//		CloudEnvironment env = new CloudEnvironment();
//		if (env.getInstanceInfo() != null) {
//			applicationContext.getEnvironment().setActiveProfiles("cloud");
//		} else {
//			applicationContext.getEnvironment().setActiveProfiles("default");
//		}
	}

}
