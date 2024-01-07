//package com.kiranCapstone.ia.config;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.kiranCapstone.ia.entity.User;
//import com.kiranCapstone.ia.repository.UserRepository;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//	private final UserRepository userRepository;
//
//	public CustomUserDetailsService(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByUserName(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//
//		return buildUserDetails(user);
//	}
//
//	private UserDetails buildUserDetails(User user) {
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
//
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//				user.getIsActive() == 1, // isEnabled
//				true, // isAccountNonExpired
//				true, // isCredentialsNonExpired
//				true, // isAccountNonLocked
//				authorities);
//	}
//}
