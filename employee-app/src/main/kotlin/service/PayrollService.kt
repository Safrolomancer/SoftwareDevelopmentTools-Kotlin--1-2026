package service
import model.Employee

class PayrollService {

    fun money(value: Double) = "€%.2f".format(value)

    fun calculateNormalPay(employee: Employee)
            = employee.hourlyPay * employee.hoursWorked

    fun calculateOvertimePay(employee: Employee)
            = employee.overtimeHoursWorked * (employee.hourlyPay * 1.5)

    fun calculateGrossPay(employee: Employee)
            = calculateNormalPay(employee) + calculateOvertimePay(employee)

    fun calculateBonus(employee: Employee)
            = calculateGrossPay(employee) * (employee.bonusPercentage / 100)

    fun calculateTax(employee: Employee)
            = calculateGrossPay(employee) * (employee.taxRatePercentage / 100)

    fun calculatePension(employee: Employee)
            = calculateGrossPay(employee) * (employee.pensionContributionPercentage / 100)

    fun calculateNetPay(employee: Employee)
            = calculateGrossPay(employee) + calculateBonus(employee) - calculateTax(employee) - calculatePension(employee)

    fun getFullName(employee: Employee) = "${employee.firstName.uppercase()} ${employee.surname.uppercase()}"

    fun getPayslip(employee: Employee): String {

        return """
        |==================================================
        |               PAYSLIP                 
        |==================================================
        |
        |Employee ID       : ${employee.employeeID}
        |Employee          : ${getFullName(employee)} (${employee.employeeID})
        |Job / Dept        : ${employee.jobTitle} (${employee.department})
        |--------------------------------------------------
        |Hourly Rate       : €${employee.hourlyPay}
        |Hours Worked      : ${employee.hoursWorked}
        |Overtime Hours    : ${employee.overtimeHoursWorked}
        |--------------------------------------------------
        |Normal Pay        : ${money(calculateNormalPay(employee))}
        |Overtime Pay      : ${money(calculateOvertimePay(employee))}
        |Gross Pay         : ${money(calculateGrossPay(employee))}
        |Bonus             : ${money(calculateBonus(employee))}
        |Tax Deduction     : ${money(calculateTax(employee))}
        |Pension Deduction : ${money(calculatePension(employee))}
        |--------------------------------------------------
        |Net Pay           : ${money(calculateNetPay(employee))}
        |==================================================
    """.trimMargin()
    }

}
