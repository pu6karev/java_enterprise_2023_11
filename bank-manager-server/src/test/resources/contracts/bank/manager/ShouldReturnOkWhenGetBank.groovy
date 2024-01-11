package contracts.bank.manager

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    request {
        def id = 1
        urlPath("/api/accounts/${id}")
        method 'GET'
    }

    response {
        status OK()
        body(file("valid_account.json"))
    }
}