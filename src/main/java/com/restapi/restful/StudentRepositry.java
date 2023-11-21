package com.restapi.restful;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepositry extends JpaRepository<Students, Long> {

}
