package com.example.demo;


import com.example.demo.repository.UserRepository;
import com.example.demo.user.User;
import com.example.demo.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
public class AuthUserController {

	@Autowired
	private UserRepository mUserRepository;

	@RequestMapping("/me")
	@ResponseBody
	public UserDto getCurrentLoggedInUser(Principal user) {
		return convertToDto(mUserRepository.findByUsername(user.getName()));
	}

	private UserDto convertToDto(User user){
		UserDto userDto = new UserDto();
		userDto.setUsername(user.getUsername());
		userDto.setClientId(user.getClientId());
		userDto.setClientSecret(user.getClientSecret());
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		return userDto;
	}

}
