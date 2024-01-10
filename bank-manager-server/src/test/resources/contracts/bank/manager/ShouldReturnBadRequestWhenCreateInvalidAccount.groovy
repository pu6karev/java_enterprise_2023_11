package contracts.bank.manager
import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        urlPath("/api/accounts")
        method 'POST'
        body(
            "name": "John Doe",
            "balance": -100
        )
    }
    response {
        status BAD_REQUEST()
        body("error": "Invalid account data")
    }
}