package contracts.bank.manager
import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        def id = 2
        urlPath("/api/accounts/${id}")
        method 'GET'
    }
    response {
        status INTERNAL_SERVER_ERROR()  // 500
        body(file("invalid_account.json"))
        description 'Simulate database access error'
    }
}