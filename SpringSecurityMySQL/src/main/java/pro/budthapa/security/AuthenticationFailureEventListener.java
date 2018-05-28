package pro.budthapa.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureEventListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent>{

	private Logger log = LoggerFactory.getLogger(AuthenticationFailureEventListener.class);
	
	@Override
	public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
		WebAuthenticationDetails wad = (WebAuthenticationDetails)event.getAuthentication().getDetails();
		log.info("Login failed request from " + event.getAuthentication().getDetails());
	}
}
