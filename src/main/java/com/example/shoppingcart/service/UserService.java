package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.User;
import com.example.shoppingcart.model.dto.UserDto;
import com.example.shoppingcart.model.request.CreateUserReq;
import com.example.shoppingcart.model.request.UpdateUserReq;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserDto> getListUser();

    Page<User> findUserLikeName(String name, int page);

    UserDto createUser(CreateUserReq req);

    UserDto updateUser(UpdateUserReq req, int id);

    void deleteUser(int id);

    User getUserById(int id);

    UserDto createUser(UserDto userDto);

    Boolean updateUser(User user);

    UserDto removeUser(int id);

    User findByUseremail(@Param("email") String email);
}