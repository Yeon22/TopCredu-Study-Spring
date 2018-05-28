package pro.budthapa.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pro.budthapa.domain.AppUser;
import pro.budthapa.domain.Role;
import pro.budthapa.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> user = userRepository.findByUsername(username);
		
		if(user.isPresent()) {
			return new User(user.get().getUsername(), 
					user.get().getPassword(), 
					getAuthorities(user.get()));
		} else {
			throw new UsernameNotFoundException("Invalid user tried to login. User not found exception");
		}
	}

	private List<GrantedAuthority> getAuthorities(AppUser appUser) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(Role role : appUser.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
			authorities.add(grantedAuthority);
		}
		
		return authorities;
	}

}
