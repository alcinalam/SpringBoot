package com.bc2403sb.demo_restful.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bc2403sb.demo_restful.entity.UserEntity;


@Repository // bean
// Spring Framwork: Hibernate (JobsDB)
// Generate the class implementing this JPA interface
public interface UserRepository extends JpaRepository<UserEntity,Long> {

  // JPA + Hibernate, generate corrsponding SQL syntax by method name convention
  // rules
  
  // select * from users where phone = ? 
  Optional<List<UserEntity>> findByPhone(String phone);

  // select * from users where addrLat = ? and addrLong = ?
  Optional<List<UserEntity>> findByAddrLatAndAddrLong(String AddrLat, String AddrLong);
}
