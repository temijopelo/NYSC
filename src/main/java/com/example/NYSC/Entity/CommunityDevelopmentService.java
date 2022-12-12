package com.example.NYSC.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityDevelopmentService {
    @Id
    @SequenceGenerator(
            name = "community_development_service_sequence",
            sequenceName = "community_development_service_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "community_development_service_sequence"
    )
    private Long cdsId;
    @Column(name = "Cds_Group")
    private String cdsGroup;
    @Column(name = "Cds_Day")
    private String cdsDay;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "id",
            referencedColumnName = "Id"
    )
    private Corper corpers;


}
