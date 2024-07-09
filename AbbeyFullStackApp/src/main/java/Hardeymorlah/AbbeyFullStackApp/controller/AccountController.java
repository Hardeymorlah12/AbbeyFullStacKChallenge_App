package Hardeymorlah.AbbeyFullStackApp.controller;

import Hardeymorlah.AbbeyFullStackApp.model.Account;
import Hardeymorlah.AbbeyFullStackApp.service.AccountService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@Data
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;

    }
    @GetMapping("/all_accounts")
    public ResponseEntity<List<Account>> allAccounts() {
        return accountService.getAllAccounts();
    }
    @GetMapping("/account_by_id/{id}")
    public ResponseEntity<Account> getAccountBYId(@PathVariable long id) {
        return accountService.getAccountById(id);
    }
    @GetMapping("/user_by_name/{name}")
    public ResponseEntity<Account> getUserByName(@PathVariable String name) {
        return accountService.findAccountByName(name);
    }
    @GetMapping("/account_type")
    public ResponseEntity<Account> getAccountByType(@RequestParam String accountType) {
        return accountService.getAccountByAccountType(accountType);
    }
    @PostMapping("/post_new_account")
    public ResponseEntity<Account> postAccount(@Valid @RequestBody Account newAccount) {
        return accountService.createAccount(newAccount);

    }
    @PutMapping("/update_account/{id}")
    public ResponseEntity<Account> updateAccount(@Valid @PathVariable long id, @RequestBody Account updatedAccount) {
        return accountService.updateAccount(id, updatedAccount);
    }
    @DeleteMapping("/delete_account/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable long id) {
        return accountService.deleteAccount(id);
    }
}
