package org.ada.school.user.repository;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ada.school.user.entity.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.PersistenceConstructor;
import org.ada.school.user.controller.dto.UserDto;
import java.util.Date;
import java.util.UUID;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class UserDocument {
    @Id
    String id;

    String name;
    String lastName;

    @Indexed( unique = true )
    String email;
    Date createdAt;

    public UserDocument(@NotNull UserDto userDto) {
        this(UUID.randomUUID().toString(), userDto.getName(), userDto.getLastName(), userDto.getEmail(), new Date());
    }
}
