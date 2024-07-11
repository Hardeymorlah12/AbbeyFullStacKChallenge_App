package Hardeymorlah.AbbeyFullStackApp.repository;

import Hardeymorlah.AbbeyFullStackApp.model.Account;
import Hardeymorlah.AbbeyFullStackApp.model.Enum.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByAccountType(AccountType accountType);
    Account findByName(String name);
}
