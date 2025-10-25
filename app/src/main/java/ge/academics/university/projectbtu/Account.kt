package ge.academics.university.projectbtu

open class Account(val accountNumber: String, val owner: String) {
    private var balance: Double = 0.0

    fun getBalance(): Double {
        return balance
    }

    protected fun changeBalance(amount: Double) {
        balance -= amount
    }

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Successfully added $amount dollars")
        }
    }

    open fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("Successfully withdraw $amount dollars")
        } else {
            println("Insufficient funds")
        }
    }

    fun printInfo() {
        println("Account Number: $accountNumber")
        println("Owner: $owner")
        println("Balance: $balance")
    }


}