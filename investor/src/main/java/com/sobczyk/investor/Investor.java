package com.sobczyk.investor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "investor_account")
public class Investor {

    @Id
    @SequenceGenerator(name = "investor_id_sequence", sequenceName = "investor_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "investor_id_sequence")
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
