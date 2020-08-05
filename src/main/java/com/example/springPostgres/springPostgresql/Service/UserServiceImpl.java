package com.example.springPostgres.springPostgresql.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.example.springPostgres.springPostgresql.DataAccess.AddressRepository;
import com.example.springPostgres.springPostgresql.DataAccess.UserRepository;
import com.example.springPostgres.springPostgresql.Dto.UserDto;
import com.example.springPostgres.springPostgresql.Entity.Address;
import com.example.springPostgres.springPostgresql.Entity.User;


@Service
public class UserServiceImpl implements UserService {

	
	private final UserRepository userRepo;
	private final AddressRepository addressRepo;
	
	
	

	public UserServiceImpl(UserRepository userRepo, AddressRepository addressRepo) {
		
		this.userRepo = userRepo;
		this.addressRepo = addressRepo;
	}

	@Override
	@Transactional
	public UserDto save(UserDto userDto) {
		//busıness logic
		//Assert.isNull(userDto.getAdi(),"Adi alanı zorunludur");
		
		User user = new User();
		user.setAdi(userDto.getAdi());
		user.setSoyadi(userDto.getSoyadi());
		final User userdb = userRepo.save(user);
		List<Address> liste = new ArrayList<Address>();
		
		userDto.getAdresler().forEach(item ->
		{
			Address address = new Address();
			address.setAddress(item);
			address.setAdrestip(Address.AdresTip.diger);
			address.setAktif(true);
			address.setUser(userdb);
			liste.add(address);
		});
		addressRepo.saveAll(liste);
		userDto.setId(user.getId());
		return userDto;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public List<UserDto> getAll() {
		
		List<User> users =  userRepo.findAll();
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		users.forEach(item->{
			UserDto userDto = new UserDto();
			userDto.setId(item.getId());
			userDto.setAdi(item.getAdi());
			userDto.setSoyadi(item.getSoyadi());
			userDto.setAdresler(item.getAdresleri().stream().map(Address::getAddress).collect(Collectors.toList()));
			
			userDtos.add(userDto);
		});
		
		return userDtos;
	}

	@Override
	public Page<UserDto> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
