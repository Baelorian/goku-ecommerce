package goku.ecommerce.gokuecommerce.repository;

import goku.ecommerce.gokuecommerce.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Users,Integer> {
}
