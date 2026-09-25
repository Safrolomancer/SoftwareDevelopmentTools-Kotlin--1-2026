var employee = Employee(
    1,
    "Joe",
    "Soap",
    "Computer Services",
    "Technician",
    32.45,
    38,
    5.0,
    5.0,
    23.0,
    7.5
)

fun main() {

    add()

    var input: Int

    do {
        input = menu()

        when (input) {
            1 -> println("Hourly Rate: ${employee.hourlyPay}")
            2 -> println("Hours Worked: ${employee.hoursWorked}")
            3 -> println("Overtime Hours: ${employee.overtimeHoursWorked}")
            4 -> println("Bonus: ${employee.bonusPercentage}%")
            5 -> println("Tax Rate: ${employee.taxRatePercentage}%")
            6 -> println("Pension: ${employee.pensionContributionPercentage}%")
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
    return "${employee.firstName} ${employee.surname}".uppercase()
}

fun calculateNormalPay() =
    employee.hourlyPay * employee.hoursWorked

fun calculateOvertimePay() =
    employee.hourlyPay * employee.overtimeHoursWorked * 1.5

fun calculateGrossPay() =
    calculateNormalPay() + calculateOvertimePay()

fun calculateBonus() =
    calculateGrossPay() * employee.bonusPercentage / 100

fun calculateTax() =
    calculateGrossPay() * employee.taxRatePercentage / 100

fun calculatePension() =
    calculateGrossPay() * employee.pensionContributionPercentage / 100

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
Employee ID: ${employee.employeeID}
Employee Name: ${getFullName()}
Department: ${employee.department}
Job Title: ${employee.jobTitle}

---------------------------
Hourly Rate: ${money(employee.hourlyPay)}
Hours Worked: ${employee.hoursWorked}
Overtime Hours: ${employee.overtimeHoursWorked}

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

fun add() {

    print("Enter employee ID: ")
    val employeeId = readln().toInt()

    print("Enter first name: ")
    val firstName = readlnOrNull().toString()

    print("Enter surname: ")
    val surname = readlnOrNull().toString()

    print("Enter department: ")
    val department = readlnOrNull().toString()

    print("Enter job title: ")
    val jobTitle = readlnOrNull().toString()

    print("Enter hourly rate: ")
    val hourlyRate = readln().toDouble()

    print("Enter hours worked: ")
    val hoursWorked = readln().toInt()

    print("Enter overtime hours worked: ")
    val overtimeHoursWorked = readln().toDouble()

    print("Enter bonus percentage: ")
    val bonusPercentage = readln().toDouble()

    print("Enter tax rate percentage: ")
    val taxRatePercentage = readln().toDouble()

    print("Enter pension contribution percentage: ")
    val pensionContributionPercentage = readln().toDouble()

    employee = Employee(
        employeeId,
        firstName,
        surname,
        department,
        jobTitle,
        hourlyRate,
        hoursWorked,
        overtimeHoursWorked,
        bonusPercentage,
        taxRatePercentage,
        pensionContributionPercentage
    )
}
