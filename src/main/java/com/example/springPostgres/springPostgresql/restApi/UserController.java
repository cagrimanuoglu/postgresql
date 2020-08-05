package com.example.springPostgres.springPostgresql.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springPostgres.springPostgresql.DataAccess.UserRepository;
import com.example.springPostgres.springPostgresql.Dto.UserDto;
import com.example.springPostgres.springPostgresql.Service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
@Api(value = "Benim User Api dökümantasyonum")
public class UserController {

	private final UserService userservice;
	
	
	

	@Autowired
	public UserController(UserService userservice) {
		
		this.userservice = userservice;
	} 

	@PostMapping
	@ApiOperation(value = "Yeni User ekleme metodu",notes = "Önemli metod dikkatli ol")
	public ResponseEntity<UserDto> ekle(@RequestBody @ApiParam(value = "insan") UserDto userDto)
	{
		return ResponseEntity.ok(userservice.save(userDto));
	}
	
	
	 @GetMapping
	 @ApiOperation(value = "Yeni User listeleme metodu",notes = "Tümünü getirir")
	 public ResponseEntity<List<UserDto>> listele()
	 {
		 return ResponseEntity.ok(userservice.getAll());
	 }
	
	
	
	
}
