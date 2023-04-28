package com.example.demo.ValidateRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.ValidateModel.PojoLogin;

public interface RepoLogin extends JpaRepository<PojoLogin,String> {

	PojoLogin findByuname(String uname);

}
