val employeeId = 6143
val firstName = "joe"
val surname = "soap"
val department = "Computer Services"
val jobTitle = "Technician"
val hourlyRate = 26.87
val hoursWorked = 39
val overtimeHoursWorked = 4
val bonusPercentage = 4.5
val taxRatePercentage = 23.5
val pensionContributionPercentage = 6.7

fun main() {

    var input: Int

    do {
        input = menu()

        when (input) {
            1 -> println("Hourly Rate: ${money(hourlyRate)}")
            2 -> println("Hours Worked: $hoursWorked")
            3 -> println("Overtime Hours: $overtimeHoursWorked")
            4 -> println("Bonus: ${money(calculateBonus())}")
            5 -> println("Tax Rate: %.2f%%".format(taxRatePercentage))
            6 -> println("Pension: ${money(calculatePension())}")
            7 -> println("Gross Pay: ${money(calculateGrossPay())}")
            8 -> println("Net Pay: ${money(calculateNetPay())}")
            9 -> println(getPayslip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }

        println()

    } while (input != -1)
}

fun getFullName(): String {
    return "$firstName $surname".uppercase()
}

fun calculateNormalPay() = hourlyRate * hoursWorked

fun calculateOvertimePay() =
    hourlyRate * overtimeHoursWorked * 1.5

fun calculateGrossPay() =
    calculateNormalPay() + calculateOvertimePay()

fun calculateBonus() =
    calculateGrossPay() * bonusPercentage / 100

fun calculateTax() =
    calculateGrossPay() * taxRatePercentage / 100

fun calculatePension() =
    calculateGrossPay() * pensionContributionPercentage / 100

fun calculateNetPay() =
    calculateGrossPay() +
            calculateBonus() -
            calculateTax() -
            calculatePension()

fun money(value: Double) = "€%.2f".format(value)

fun getPayslip(): String {
    return """
====================================
===========    PAYSLIP   ===========
====================================
Employee ID: $employeeId
Employee Name: ${getFullName()}
Department: $department
Job Title: $jobTitle

---------------------------
Hourly Rate: ${money(hourlyRate)}
Hours Worked: $hoursWorked
Overtime Hours: $overtimeHoursWorked

---------------------------
Normal Pay: ${money(calculateNormalPay())}
Overtime Pay: ${money(calculateOvertimePay())}
Gross Pay: ${money(calculateGrossPay())}
Bonus: ${money(calculateBonus())}
Tax: ${money(calculateTax())}
Pension: ${money(calculatePension())}
Net Pay: ${money(calculateNetPay())}
""".trimIndent()
}

fun menu(): Int {
    print(
        """
        Employee Menu for ${getFullName()}
          1. Hourly Rate
          2. Hours Worked
          3. Overtime Hours
          4. Bonus
          5. Tax Rate
          6. Pension
          7. Gross Pay
          8. Net Pay
          9. Full Payslip
         -1. Exit
        Enter Option : 
        """.trimIndent()
    )
    return readln().toInt()
}