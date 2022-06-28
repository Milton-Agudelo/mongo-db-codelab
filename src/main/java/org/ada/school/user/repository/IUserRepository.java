package org.ada.school.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<UserDocument, String> {
}
