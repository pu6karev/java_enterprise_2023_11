package contracts.bank.manager
import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        urlPath("/api/customers/1/accounts")
        method 'POST'
        headers {
            contentType(applicationJson())
        }
        body(file("valid_account.json"))
    }
    response {
        status CREATED()
        body(file("valid_account.json"))
    }
}