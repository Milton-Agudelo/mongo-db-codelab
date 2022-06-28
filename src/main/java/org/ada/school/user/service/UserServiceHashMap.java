package org.ada.school.user.service;

import org.ada.school.user.controller.dto.UserDto;
import org.ada.school.user.repository.UserDocument;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class UserServiceHashMap implements IUserService {

    private final HashMap<String, UserDocument> usersMap = new HashMap<>();


    @Override
    public UserDocument create(UserDocument userDocument) {
        usersMap.put( userDocument.getId(), userDocument);
        return userDocument;
    }

    @Override
    public UserDocument findById(String id ) {
        if ( usersMap.containsKey( id ) ) {
            return usersMap.get( id );
        }
        return null;
    }

    @Override
    public List<UserDocument> all() {
        return new ArrayList<>( usersMap.values() );
    }

    @Override
    public boolean deleteById( String id ) {
        return usersMap.remove( id ) != null;
    }

    @Override
    public boolean update(String id, UserDto userDto) {
        return false;
    }

}