package org.ada.school.user.service;

import org.ada.school.user.controller.dto.UserDto;
import org.ada.school.user.repository.IUserRepository;
import org.ada.school.user.repository.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDb implements IUserService {

    private final IUserRepository iUserRepository;

    public UserServiceMongoDb(@Autowired IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public UserDocument create(UserDocument userDocument) {
        return iUserRepository.save(userDocument);
    }

    @Override
    public UserDocument findById(String id) {
        return iUserRepository.findById(id).get();
    }

    @Override
    public List<UserDocument> all() {
        return iUserRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        boolean result = false;
        Optional<UserDocument> user = iUserRepository.findById(id);
        if (!user.equals(Optional.empty())) {
            iUserRepository.deleteById(id);
            result = true;
        }
        return result;
    }

    public boolean update(String id, UserDto userDto) {
        boolean result = false;
        UserDocument userDocument = new UserDocument(userDto);
        Optional<UserDocument> userToUpdate = iUserRepository.findById(id);
        if (!userToUpdate.equals(Optional.empty())) {
            userDocument.setId(id);
            iUserRepository.save(userDocument);
            result = true;
        }
        return result;
    }

}
