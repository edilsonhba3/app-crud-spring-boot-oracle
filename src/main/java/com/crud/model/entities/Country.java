package com.crud.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_country")
public class Country 
{
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_country")
    @GeneratedValue(generator = "gen_sq_tbl_country")
    @SequenceGenerator(name = "gen_sq_tbl_country", sequenceName = "sq_tbl_country", allocationSize = 1)
    private Integer pk;
    
    @Column(name = "name")
    @NotEmpty(message = "*Please provide an email")
    private String name;
}
  