package ge.academics.university.projectbtu

class SavingsAccount(accountNumber: String, owner: String) : Account(accountNumber, owner) {

    override fun withdraw(amount: Double) {
        if (amount > 500) {
            println("failed: account limit is 500 per transaction.")
            return
        }
        super.withdraw(amount)
    }
}
