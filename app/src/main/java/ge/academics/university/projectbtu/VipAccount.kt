package ge.academics.university.projectbtu

class VipAccount(accountNumber: String, owner: String) : Account(accountNumber, owner) {
    val transactionFee: Double = 2.0

    override fun withdraw(amount: Double) {
        val totalAmount = amount + transactionFee
        val curBalance = getBalance()
        if (curBalance >= totalAmount) {
            changeBalance(totalAmount)
            println("Successfully withdraw $amount dollars")
        } else {
            println("Insufficient funds")
        }
    }
}