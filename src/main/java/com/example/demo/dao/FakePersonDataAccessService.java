package com.example.demo.dao;

import com.example.demo.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("fakedao")
public class FakePersonDataAccessService {
    private static List<Member> DB = new ArrayList<>();

//    @Override
//    public int insertPerson(int id, Contact person) {
//        DB.add(new Contact(id,person.getName()));
//        return 1;
//    }
//
//    @Override
//    public List<Contact> selectAllPeople() {
//        return DB;
//    }

//    @Override
//    public Optional<Person> selectPersonById(UUID id) {
//        return DB.stream()
//                .filter(person -> person.getId().equals(id))
//                .findFirst();
//    }

//    @Override
//    public int deletePersonById(UUID id) {
//        Optional<Person> selectedPerson = selectPersonById(id);
//        if(!selectedPerson.isPresent())
//        {
//            return 0;
//        }
//        DB.remove(selectedPerson.get());
//        return 1;
//    }
//
//    @Override
//    public int updatePersonById(UUID id, Person newPerson) {
//        return selectPersonById(id)
//                .map(foundPerson -> {
//                    int indexOfPersonToUpdate = DB.indexOf(foundPerson);
//                    if(indexOfPersonToUpdate >= 0)
//                    {
//                        DB.set(indexOfPersonToUpdate, new Person(id, newPerson.getName()));
//                        return 1;
//                    }
//                    return 0;
//                }).orElse(0);
//    }
}
