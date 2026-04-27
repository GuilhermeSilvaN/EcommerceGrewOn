package com.ecommerce.api.service;

import com.ecommerce.api.dto.UserEntityDTO;
import com.ecommerce.api.mapper.MapperUserEntity;
import com.ecommerce.api.model.UserEntity;
import com.ecommerce.api.repository.UserEntityRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private UserEntityRepository userEntityRepository;

    public UserService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public UserEntityDTO findByUsername(String username) {
        UserEntity userEntity = userEntityRepository.findByUsernameAndIsActive(username, true)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        return MapperUserEntity.UserEntityToUserEntityDTO(userEntity);
    }

    public UserEntity findByEmail(String email) {
        UserEntity userEntity = userEntityRepository.findByEmailAndIsActive(email, true)
                .orElseThrow(() -> new RuntimeException("Email not found!"));

        return userEntity;
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
