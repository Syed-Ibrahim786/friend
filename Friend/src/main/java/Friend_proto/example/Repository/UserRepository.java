package Friend_proto.example.Repository;

import Friend_proto.example.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByuserName(String userName);
}
