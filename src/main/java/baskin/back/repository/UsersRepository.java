package baskin.back.repository;


import baskin.back.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import javax.transaction.Transactional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    @Transactional
    @Modifying
    @Query(value = "Insert Into users (name, user_id, user_pw, birth, email, phone_number) VALUES (:name, :user_id, :user_pw, :birth, :email, :phone_number)", nativeQuery = true)
    public void signUp(@Param("name")String name, @Param("user_id")String user_id, @Param("user_pw")String user_pw, @Param("birth")Long birth, @Param("email")String email, @Param("phone_number")String phone_number);


    public List<Users> findAll();

    @Query(value = "SELECT * FROM users WHERE user_id = :user_id", nativeQuery = true)
    public Users existUser(@Param("user_id")String user_id);


    @Query(value = "SELECT * FROM users WHERE user_id = :user_id AND user_pw = :user_pw", nativeQuery = true)
    public Users login(@Param("user_id")String user_id, @Param("user_pw")String user_pw);

}
