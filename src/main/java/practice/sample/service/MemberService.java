package practice.sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice.sample.domain.Member;
import practice.sample.repository.MemberRepository;

@Service
public class MemberService {
    
    @Autowired
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Optional<Member> findById(String id) {
        Optional<Member> member = memberRepository.findById(id);
        return member;
    }

    public void signUp(Member member){
        memberRepository.signUp(member.getName());
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }


}
