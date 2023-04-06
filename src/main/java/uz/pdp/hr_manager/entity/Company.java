package uz.pdp.hr_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id ;

    @Column(nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String  addManager;



}
