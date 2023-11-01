package com.web.SpringWeb.repository;

import com.web.SpringWeb.models.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AdministradoresRepository extends CrudRepository<Administrador, Integer> {

}
