package com.example.demo.service;

import com.example.demo.dao.MemberRepository;
import com.example.demo.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    @Qualifier("mysql")
    private MemberRepository memberrepo;

    // GET method
    public List<Member> getMembers()
    {
        return memberrepo.findAll();
    }

    public List <Member> getMembersSorted()
    {
        return memberrepo.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    // note: its better to have optional return value in get
    // method since it can handle the null value properly
    public Member getMemberById(int id)
    {
        return memberrepo.findById(id).orElse(null);
    }


    public Member getMemberByName(String name)
    {
        return memberrepo.findByName(name).orElse(null);
    }

    public List<Member> getActiveMembers()
    {
        return memberrepo.getAllActiveMember();
    }
    public List<Member> getActiveMembersSorted()
    {
        return memberrepo.getAllActiveMemberSorted();
    }


    // POST method
    public Member addMembers(Member member)
    {
        return memberrepo.save(member);
    }

    // save multiple member
    public List<Member> addMembers(List<Member> members)
    {
        return memberrepo.saveAll(members);
    }

    // DETELE method
    public String deleteMember(int id)
    {
        String messsage = "";
//        if(memberrepo.existsById(id))
//        {
//            memberrepo.deleteById(id);
//        }
//        else
//        {
//            return "Member id not found";
//        }
//        messsage = "Member id= "+id+" is deleted";

        Optional<Member> selectedMember = memberrepo.findById(id);
        if(!selectedMember.isPresent())
        {
            return "Member id not found";
        }
        else
        {
            memberrepo.deleteById(id);
        }

        messsage = "Member id= "+id+" with name="+selectedMember.get().getName()+" is deleted";
        return messsage;
    }

    // Update Member
    public Member updateMember(Member member)
    {
        Optional<Member> existingMember = memberrepo.findById(member.getId());
        if(!existingMember.isPresent())
        {
            return null;
        }
        existingMember.get().setName(member.getName());
        existingMember.get().setEmail(member.getEmail());
        existingMember.get().setPhone(member.getPhone());
        existingMember.get().setStatus(member.getStatus());

        memberrepo.save(existingMember.get());
        return existingMember.get();

    }

    public Member updateMemberStatusToNotActive(int id)
    {
        Optional<Member> existingMember = memberrepo.findById(id);
        if(!existingMember.isPresent())
        {
            return null;
        }
        existingMember.get().setStatus(0);
        memberrepo.save(existingMember.get());
        return existingMember.get();
    }

    public Member updateMemberStatusToActive(int id)
    {
        Optional<Member> existingMember = memberrepo.findById(id);
        if(!existingMember.isPresent())
        {
            return null;
        }
        existingMember.get().setStatus(1);
        memberrepo.save(existingMember.get());
        return existingMember.get();
    }


}
