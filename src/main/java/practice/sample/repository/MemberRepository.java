package practice.sample.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import practice.sample.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
    public Optional<Member> findById(String id);

    @Query(value = "Insert Into member (name) VALUES (:name)", nativeQuery = true)
    public void signUp(String name);

    public List<Member> findAll();
}
