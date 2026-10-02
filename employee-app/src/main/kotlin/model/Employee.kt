package model

data class Employee (
    var employeeID: Int,
    var firstName: String,
    var surname: String,
    var department: String,
    var jobTitle: String,
    var hourlyPay: Double,
    var hoursWorked: Double,
    var overtimeHoursWorked: Double,
    var bonusPercentage: Double,
    var taxRatePercentage: Double,
    var pensionContributionPercentage: Double)
