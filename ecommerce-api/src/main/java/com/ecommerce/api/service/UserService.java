package com.ecommerce.api.service;

import com.ecommerce.api.dto.LoginDTO;
import com.ecommerce.api.dto.LoginResponseDTO;
import com.ecommerce.api.dto.UserEntityDTO;
import com.ecommerce.api.dto.UserEntityDTOCreate;
import com.ecommerce.api.mapper.MapperUserEntity;
import com.ecommerce.api.model.UserEntity;
import com.ecommerce.api.repository.UserEntityRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserEntityRepository userEntityRepository;

    public UserService(
            UserEntityRepository userEntityRepository
    ) {
        this.userEntityRepository = userEntityRepository;
    }

    //Read
    public UserEntityDTO findByUsername(String username) {
        UserEntity userEntity = userEntityRepository.findByUsernameAndIsActive(username, true)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        return MapperUserEntity.UserEntityToUserEntityDTO(userEntity);
    }

    //read
    public UserEntity findByEmail(String email) {
        UserEntity userEntity = userEntityRepository.findByEmailAndIsActive(email, true)
                .orElseThrow(() -> new RuntimeException("Email not found!"));

        return userEntity;
    }

    //update
    public UserEntityDTO update(Long id, UserEntityDTOCreate userEntityDTOCreate) {
        UserEntity userEntity = userEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        MapperUserEntity.userEntityUpdate(userEntity, userEntityDTOCreate);
        userEntityRepository.save(userEntity);

        return MapperUserEntity.UserEntityToUserEntityDTO(userEntity);
    }

    //delete
    public void deleteUserEntity(Long id){
        UserEntity userEntity = userEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        userEntityRepository.delete(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try{
            System.out.println("Buscando email: "+ email);
            UserEntity user = findByEmail(email);

            return User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles("USER")
                    .build();
        } catch(UsernameNotFoundException e){
            throw new  UsernameNotFoundException("email not found : " + email);
        }

    }

}
