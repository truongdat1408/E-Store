package com.truongdat.estore.service.serviceImpl;

import com.truongdat.estore.dto.LoginDTO;
import com.truongdat.estore.dto.UserDTO;
import com.truongdat.estore.models.User;
import com.truongdat.estore.repositories.UserRepository;
import com.truongdat.estore.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public UserDTO login(LoginDTO loginDTO) {
        User user = userRepository.findUserByUsernameAndPasswordAndIsAdminTrue(loginDTO.getUsername(), loginDTO.getPassword());
        if(user != null){
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(user, UserDTO.class);
        }
        return null;
    }
}
