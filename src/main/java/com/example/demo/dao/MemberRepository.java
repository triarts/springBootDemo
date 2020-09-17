package com.example.demo.dao;

import com.example.demo.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("mysql")
//@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    // pindah ke interface contact service
    @Query(value = "SELECT * FROM member tbm WHERE tbm.status = 1",
            nativeQuery = true)
    List<Member> getAllActiveMember();

    @Query(value = "SELECT * FROM member tbm WHERE tbm.status = 1 order by name asc",
            nativeQuery = true)
    List<Member> getAllActiveMemberSorted();

    // can create the custom function to access
    // table field as long as it specified in the @entity
    // should be start with "findby{field name}" prefix
    Optional<Member> findByName(String name);
}
