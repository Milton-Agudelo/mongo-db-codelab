package org.ada.school.user.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.ada.school.user.repository.UserDocument;

import java.util.Date;

@Getter
@AllArgsConstructor
public class UserDto
{
    private String id;
    private String name;
    private String lastName;
    private int age;
    private String email;
    private Date date;

    public UserDto(UserDocument userDocument) {
        this(userDocument.getId(), userDocument.getName(), userDocument.getLastName(), userDocument.getAge(), userDocument.getEmail(), userDocument.getCreatedAt());
    }
}
