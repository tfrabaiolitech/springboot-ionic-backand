package tech.tfrabaioli.SpringApp.services;

import org.springframework.security.core.context.SecurityContextHolder;

import tech.tfrabaioli.SpringApp.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}