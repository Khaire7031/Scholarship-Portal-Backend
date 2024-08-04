package com.pdk.scolarship.ServiceImplementation;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pdk.scolarship.Dto.UserDto;
import com.pdk.scolarship.Entity.User;
import com.pdk.scolarship.Repository.UserRepository;
import com.pdk.scolarship.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<UserDto> updateUserProfile(Integer id, UserDto userDto) {
        Optional<User> oldUserOpt = userRepository.findById(id);

        if (oldUserOpt.isPresent()) {
            User oldUser = oldUserOpt.get();

            // Update user details
            oldUser.setFirstName(userDto.getFirstName());
            oldUser.setLastName(userDto.getLastName());
            oldUser.setGender(userDto.getGender());
            oldUser.setLocation(userDto.getLocation());
            oldUser.setDateOfBirth(userDto.getDateOfBirth());
            oldUser.setContactNumber(userDto.getContactNumber());

            // Save updated user
            User updatedUser = userRepository.save(oldUser);

            // Convert updated user to DTO and return
            return ResponseEntity.ok(modelMapper.map(updatedUser, UserDto.class));
        } else {
            // Return a not found response
            return ResponseEntity.notFound().build();
        }
    }

}
