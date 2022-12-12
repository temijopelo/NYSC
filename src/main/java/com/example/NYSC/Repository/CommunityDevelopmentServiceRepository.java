package com.example.NYSC.Repository;

import com.example.NYSC.Entity.CommunityDevelopmentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityDevelopmentServiceRepository extends JpaRepository <CommunityDevelopmentService, Long> {
}
