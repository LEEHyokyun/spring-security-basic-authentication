package spring.security.basic.authentication.auth.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.basic.authentication.auth.users.domain.entity.Account;

@Repository
public interface UserRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);
}
