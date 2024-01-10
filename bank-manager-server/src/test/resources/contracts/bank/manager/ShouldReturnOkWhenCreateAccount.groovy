package contracts.bank.manager
import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        urlPath("/api/accounts")
        method 'POST'
        body(file("new_account.json"))
    }
    response {
        status CREATED()
        body(file("valid_account.json"))
    }
}