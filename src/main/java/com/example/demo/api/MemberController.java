package com.example.demo.api;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/member")
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping(path = "/all")
    public List<Member> getAllMembers() {
        return memberService.getMembers();
    }
    @GetMapping(path ="/all/asc")
    public List<Member> getAllMembersSorted() {
        return memberService.getMembersSorted();
    }

    @GetMapping
    public List<Member> getAllActiveMembers() {
        return memberService.getActiveMembers();
    }

    @GetMapping(path = "/asc")
    public List<Member> getAllActiveMembersSorted() {
        return memberService.getActiveMembersSorted();
    }

    @GetMapping(path = "{id}")
    public Member findMemberById(@PathVariable int id)
    {
        return memberService.getMemberById(id);
    }

    @GetMapping(path = "/name/{name}")
    public Member findMemberByName(@PathVariable String name)
    {
        return memberService.getMemberByName(name);
    }

    @PostMapping()
    public Member addMember(@RequestBody Member member)
    {
        return memberService.addMembers(member);
    }

    @PostMapping(path="/addMultiple")
    public List<Member> addMembers(@RequestBody List<Member> member)
    {
        return memberService.addMembers(member);
    }

    @PutMapping
    public Member updateMember(@RequestBody Member member)
    {
        return memberService.updateMember(member);
    }

    @PutMapping(path = "/setToNotActive/{id}")
    public Member updateMemberStatusToNotActive(@PathVariable int id)
    {
        return memberService.updateMemberStatusToNotActive(id);
    }

    @PutMapping(path = "/setToActive/{id}")
    public Member updateMemberStatusToActive(@PathVariable int id)
    {
        return memberService.updateMemberStatusToActive(id);
    }

    @DeleteMapping(path = "{id}")
    public String deleteMember(@PathVariable int id)
    {
        return memberService.deleteMember(id);
    }

}
