package com.k001.SpringBootAuth;

import com.k001.SpringBootAuth.repository.UserRepository;
import com.k001.SpringBootAuth.user.User;
import com.k001.SpringBootAuth.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
