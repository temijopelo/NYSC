package com.example.NYSC.Repository;

import com.example.NYSC.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository <Address, Long> {

}
