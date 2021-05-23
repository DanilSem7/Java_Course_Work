package com.website.blog.repo;

import com.website.blog.models.appointment;
import org.springframework.data.repository.CrudRepository;

public interface appointmentRepository extends CrudRepository<appointment, Long> {

}
