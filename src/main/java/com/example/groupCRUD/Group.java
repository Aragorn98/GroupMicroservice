//tag::all[]
//tag::allButValidation[]
package com.example.groupCRUD;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name = "\"group\"")
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotEmpty(message="group name is required")
    private String name;

    @NotEmpty(message="specialty is required")
    private String specialty;
}
