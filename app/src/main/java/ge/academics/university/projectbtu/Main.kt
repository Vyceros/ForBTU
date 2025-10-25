package ge.academics.university.projectbtu

fun main() {
    val savings = SavingsAccount("S101", "George G.")
    val vip = VipAccount("V202", "Mariam A.")

    savings.deposit(1000.0)
    vip.deposit(1000.0)

    savings.withdraw(600.0)
    savings.withdraw(400.0)

    vip.withdraw(300.0)

    savings.printInfo()
    vip.printInfo()
}

