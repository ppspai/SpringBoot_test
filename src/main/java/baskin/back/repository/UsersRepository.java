package baskin.back.repository;


import baskin.back.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import javax.transaction.Transactional;

public interface UsersRepository extends JpaRepository<Users, Long> {

//    @Transactional
//    @Modifying
//    @Query(value = "Insert Into users (name, userid, userpw, birth, email, phoneNumber) VALUES (:name, :user_id, :user_pw, :birth, :email, :phaoneNumber)", nativeQuery = true)
//    public void signUp(@Param("name")String name, @Param("userid")String user_id, @Param("userpw")String userpw, @Param("birth")Long birth, @Param("email")String email, @Param("phoneNumber")String phoneNumber);



    public List<Users> findAll();

    @Query(value = "SELECT * FROM users WHERE userid = :userid", nativeQuery = true)
    public Users existUser(@Param("userid")String userid);


    @Query(value = "SELECT * FROM users WHERE userid = :userid AND userpw = :userpw", nativeQuery = true)
    public Users login(@Param("userid")String userid, @Param("userpw")String userpw);

}
