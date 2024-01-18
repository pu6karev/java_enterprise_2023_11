package contracts.bank.manager
import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        def invalidId = 999 // ID that doesn't exist
        urlPath("/api/accounts/${invalidId}")
        method 'GET'
    }
    response {
        status NOT_FOUND()
        body("Account not found, accountId=999")
        headers {
            header 'Content-Type': 'text/plain;charset=UTF-8'
        }
    }
}