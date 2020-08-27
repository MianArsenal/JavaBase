package com.mian.tacocloud.repository.jpa;

import com.mian.tacocloud.domain.Taco;
import org.springframework.data.repository.CrudRepository;

public interface JpaTacoRepository extends CrudRepository<Taco, Long> {
}
