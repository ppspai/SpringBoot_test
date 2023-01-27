package practice.sample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import practice.sample.domain.Member;
import practice.sample.service.MemberService;

@Controller
public class MemberController {
    
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("member")
    @ResponseBody
    public Optional<Member> memberFindById(@RequestParam("id") String id) {
        Optional<Member> member = memberService.findById(id);
        return member;
    }

    @PostMapping("signup")
    public void signUp(@RequestBody Member member) {
        System.out.println("abc");
        memberService.signUp(member);
    }

    @GetMapping("findAll")
    @ResponseBody
    public List<Member> memberFindAll() {
        List<Member> memberList = memberService.findAll();
        return memberList;
    }

}
