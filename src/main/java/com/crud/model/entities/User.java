package com.crud.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User 
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_user")
    @GeneratedValue(generator = "gen_sq_tbl_user")
    @SequenceGenerator(name = "gen_sq_tbl_user", sequenceName = "sq_tbl_user", allocationSize = 1)
    private Integer pk;
    
    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
    
    @Column(name = "pass")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;
    
    @Column(name = "first_name")
    @NotEmpty(message = "*Please provide your name")
    private String name;
    
    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;
    
    @Column(name = "active")
    private String active;
 
    //@Column(name = "country_pk")
    //private Integer countryPk;
    
    @JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "pk_country", nullable = false)
	private Country countryPk;
	
}
