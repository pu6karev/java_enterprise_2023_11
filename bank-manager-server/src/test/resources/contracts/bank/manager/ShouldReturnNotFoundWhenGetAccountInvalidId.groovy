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
        body("error": "Account not found")
    }
}