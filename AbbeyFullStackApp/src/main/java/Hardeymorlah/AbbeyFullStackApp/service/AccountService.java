package Hardeymorlah.AbbeyFullStackApp.service;

import Hardeymorlah.AbbeyFullStackApp.model.Account;
import Hardeymorlah.AbbeyFullStackApp.model.Enum.AccountType;
import Hardeymorlah.AbbeyFullStackApp.repository.AccountRepository;
import Hardeymorlah.AbbeyFullStackApp.repository.UserRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }
    public ResponseEntity<List<Account>> getAllAccounts() {
        return new ResponseEntity<>(accountRepository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<Account> getAccountById(long id) {
        return new ResponseEntity<>(accountRepository.findById(id).orElseThrow(), HttpStatus.OK);
    }
    public ResponseEntity<List<Account>> getAccountByAccountType(AccountType accountType) {
        return new ResponseEntity<>(accountRepository.findByAccountType(accountType), HttpStatus.OK);
    }
    public ResponseEntity<Account> findAccountByName(String name) {
        return new ResponseEntity<>(accountRepository.findByName(name), HttpStatus.OK);
    }
    public ResponseEntity<Account> createAccount(Account account) {
        account.setUser(account.getUser());
        account.setAccountType(AccountType.BASIC);
        account.setName(account.getName());
        account.setBio(account.getBio());
        account.setLocation(account.getLocation());
        account.setInterests(account.getInterests());
        account.setProfilePicture(account.getProfilePicture());

        return new ResponseEntity<>(accountRepository.save(account),HttpStatus.CREATED);
    }

    public ResponseEntity<Account> updateAccount(long id, Account updatedAccount) {
        Account existingAccount = accountRepository.findById(id).orElseThrow();
       existingAccount.setAccountType(updatedAccount.getAccountType());
       existingAccount.setBio(updatedAccount.getBio());
       existingAccount.setName(updatedAccount.getName());
       existingAccount.setLocation(updatedAccount.getLocation());
       existingAccount.setInterests(updatedAccount.getInterests());
       existingAccount.setProfilePicture(updatedAccount.getProfilePicture());
       return new ResponseEntity<>(accountRepository.save(existingAccount), HttpStatus.ACCEPTED);
    }
     public ResponseEntity<Account> deleteAccount(long id) {
        Account deletedAccount = accountRepository.findById(id).orElseThrow();
        accountRepository.deleteById(id);
        return new ResponseEntity<>(deletedAccount, HttpStatus.OK);
     }
}
