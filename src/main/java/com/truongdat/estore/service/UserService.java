package com.truongdat.estore.service;

import com.truongdat.estore.dto.LoginDTO;
import com.truongdat.estore.dto.UserDTO;

public interface UserService {
    UserDTO login(LoginDTO loginDTO);
}
