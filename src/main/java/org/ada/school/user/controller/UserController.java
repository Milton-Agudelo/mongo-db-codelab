package org.ada.school.user.controller;

import org.ada.school.user.controller.dto.UserDto;
import org.ada.school.user.repository.UserDocument;
import org.ada.school.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1/user/")
public class UserController {
    private final IUserService iUserService;

    public UserController(@Autowired IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping
    public ResponseEntity<List<UserDocument>> all() {
        return ResponseEntity.ok(iUserService.all());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDocument> findById(@PathVariable String id) {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("User with id: '" + id + "' can not be found!");
        try {
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(iUserService.findById(id));
        }  finally {
            return responseEntity;
        }
    }

    @PostMapping
    public ResponseEntity<UserDocument> create(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(iUserService.create(new UserDocument(userDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDocument> update(@PathVariable String id, @RequestBody UserDto userDto) {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("User with id: '" + id + "' can not be found!");
        if (iUserService.update(id, userDto)) {
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(iUserService.findById(id));
        }

        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("User with id: '" + id + "' can not be found!");
        if (iUserService.deleteById(id)) {
            responseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return responseEntity;
    }

}
