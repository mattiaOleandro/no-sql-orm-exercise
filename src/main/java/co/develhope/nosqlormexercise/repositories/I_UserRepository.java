package co.develhope.nosqlormexercise.repositories;

import co.develhope.nosqlormexercise.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface I_UserRepository extends MongoRepository<User, String> {
}
