package com.mian.tacocloud.repository.jpa;

import com.mian.tacocloud.domain.CustomUser;
import org.springframework.data.repository.CrudRepository;

public interface JpaUserRepository extends CrudRepository<CustomUser, Long> {

    CustomUser findByUsername(String username);

}
