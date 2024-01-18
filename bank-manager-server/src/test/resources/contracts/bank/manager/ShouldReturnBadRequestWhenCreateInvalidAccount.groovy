package contracts.bank.manager
//import org.springframework.cloud.contract.spec.Contract
//
//Contract.make {
//    request {
//        urlPath("/api/accounts")
//        method 'POST'
//        body(
//                "iban": "UA12345678901234567890123456",
//                "balance": -100,
//                "currency": "UAH",
//                "customerId": 1
//        )
//    }
//    response {
//        status BAD_REQUEST()
//        body("error": "Invalid account data")
//    }
//}