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
    printPaySlip()
}

fun getFullName(): String {
    return "$firstName $surname".uppercase()
}

fun calculateNormalPay() = hourlyRate * hoursWorked

fun calculateOvertimePay() = hourlyRate * overtimeHoursWorked * 1.5

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

fun printPaySlip() {

    println()
    println("====================================")
    println("===========    PAYSLIP   ===========")
    println("====================================")
    println("Employee ID: $employeeId")
    println("Employee Name: ${getFullName()}")
    println("Department: $department")
    println("Job Title: $jobTitle")
    println()

    println("---------------------------")
    println("Hourly Rate: $hourlyRate")
    println("Hours Worked: $hoursWorked")
    println("Overtime Hours: $overtimeHoursWorked")
    println()

    println("---------------------------")
    println("Normal Pay: ${calculateNormalPay()}")
    println("Overtime Pay: ${calculateOvertimePay()}")
    println("Gross Pay: ${calculateGrossPay()}")
    println("Bonus: ${calculateBonus()}")
    println("Tax: ${calculateTax()}")
    println("Pension: ${calculatePension()}")
    println("Net Pay: ${calculateNetPay()}")
}