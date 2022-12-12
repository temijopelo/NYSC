package com.example.NYSC.Repository;

import com.example.NYSC.Entity.Corper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NyscRepository extends JpaRepository <Corper, Long> {

    @Query
            ("SELECT s FROM Corper s WHERE " +
                    "s.firstName LIKE CONCAT('%',:query, '%')" +
                    "Or s.lastName LIKE CONCAT('%', :query, '%')" +
                    "Or s.stateCode LIKE CONCAT('%' , :query, '%') ")
    List<Corper> searchCorpMembers(String query);

    Corper findByCallUpNumber (String callUpNumber);

    List<Corper> findByServiceYearBetween(String startingYear, String endingYear);

    Corper findByEmail (String email);
}




