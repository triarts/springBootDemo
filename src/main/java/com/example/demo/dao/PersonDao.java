package com.example.demo.dao;

import com.example.demo.model.Member;

import java.util.List;

public interface PersonDao {

    int insertPerson(int id, Member person);
    default int insertPerson(Member person)
    {
        int id = 0;
        return insertPerson(id,person);
    }

    List<Member> selectAllPeople();

//    Optional<Person> selectPersonById(int id);
//
//    int deletePersonById(UUID id);
//    int updatePersonById(UUID id, Person person);


}
