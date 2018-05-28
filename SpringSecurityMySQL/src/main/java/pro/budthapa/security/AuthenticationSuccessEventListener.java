package pro.budthapa.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent>{

	private Logger log = LoggerFactory.getLogger(AuthenticationSuccessEventListener.class);
	
	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		WebAuthenticationDetails wad = (WebAuthenticationDetails)event.getAuthentication().getDetails();
		log.info("Login success from " + event.getAuthentication().getDetails());
	}

}
