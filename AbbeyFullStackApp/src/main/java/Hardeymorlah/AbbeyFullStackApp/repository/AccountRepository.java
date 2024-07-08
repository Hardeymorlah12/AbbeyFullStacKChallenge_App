package Hardeymorlah.AbbeyFullStackApp.repository;

import Hardeymorlah.AbbeyFullStackApp.model.Account;
import Hardeymorlah.AbbeyFullStackApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountType(String accountType);
    Account findByName(String name);
}
