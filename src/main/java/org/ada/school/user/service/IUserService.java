package org.ada.school.user.service;

import org.ada.school.user.controller.dto.UserDto;
import org.ada.school.user.repository.UserDocument;

import java.util.List;
import java.util.Optional;


public interface IUserService {
    UserDocument create(UserDocument userDocument);

    UserDocument findById(String id );

    List<UserDocument> all();

    boolean deleteById( String id );

    boolean update(String id, UserDto userDto);
}
