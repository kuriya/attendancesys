package com.aronext.attendancesys.attendancesys.repository;

/**
 * @author Dilshan Niroda
 * @Date 2019-11-17
 * @Time 9:22 PM
 */

import com.aronext.attendancesys.attendancesys.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
