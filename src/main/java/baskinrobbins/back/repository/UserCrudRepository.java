package java.baskinrobins.back.repository;



import java.baskinrobbins.back.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserCrudRepository extends JpaRepository<User, Long> {
    // Select * from users;
    
    public List<Users> findAll();
    
}
