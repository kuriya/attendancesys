package com.aronext.attendancesys.repository;

/**
 * @author Dilshan Niroda
 * @Date 2019-11-17
 * @Time 9:22 PM
 */

import com.aronext.attendancesys.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
