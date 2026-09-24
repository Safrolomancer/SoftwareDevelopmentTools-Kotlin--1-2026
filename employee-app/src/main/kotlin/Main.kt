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
    println("Pay Slip Printer")
    println(getPayslip())
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