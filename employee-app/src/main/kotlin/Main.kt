import model.Employee
import repository.EmployeeRepository
import service.PayrollService
import mu.KotlinLogging

val payrollService = PayrollService()


val employeeRepository = EmployeeRepository()

val logger = KotlinLogging.logger {}   //Should be private?

fun main(){
    logger.info { "Launching Employee App" }
    var input : Int

    do {
        input = menu()
        when(input) {
            1 -> add()
            2 -> list()
            3 -> getEmployeeById()
            4 -> displayPaySlip()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}


fun menu() : Int {
    print(""" 
         |Employee Menu
         |   1. Add Employee
         |   2. List All Employees
         |   3. Search Employees 
         |   4. Print Payslip for Employee
         |  -1. Exit
         |       
         |Enter Option : """.trimMargin())
    return readln().toInt()
}

fun list() = println(employeeRepository.getAll())


fun getEmployeeById(): Employee? {
    print("Enter the employee id to search by: ")
    val employeeID = readln().toInt()
    return employeeRepository.findById(employeeID)
}

fun displayPaySlip(){
    val employee = getEmployeeById()
    if (employee != null){
        val payslip = payrollService.getPayslip(employee)
        println(payslip)
    }
}

fun dummyData() {
    employeeRepository.add(
        Employee(
            0, "Joe", "Soap", "Marketing", "Marketing Intern",
            15.99, 25.0, 5.0, 0.0, 23.5, 0.0
        )
    )
    employeeRepository.add(
        Employee(
            0, "Mark", "Flynn", "Sales", "Sales Manager",
            65.99, 39.0, 9.0, 6.0, 43.5, 6.0
        )
    )
    employeeRepository.add(
        Employee(
            0, "Minnie", "Mouse", "Accounts", "Payroll Manager",
            55.99, 35.0, 3.0, 4.0, 43.5, 5.0
        )
    )
}

fun add() {
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
    val hoursWorked = readln().toDouble()

    print("Enter overtime hours worked: ")
    val overtimeHoursWorked = readln().toDouble()

    print("Enter bonus percentage: ")
    val bonusPercentage = readln().toDouble()

    print("Enter tax rate percentage: ")
    val taxRatePercentage = readln().toDouble()

    print("Enter pension contribution percentage: ")
    val pensionContributionPercentage = readln().toDouble()

    employeeRepository.add(
        Employee(
            0,
            firstName,
            surname,
            department,
            jobTitle,
            hourlyRate,
            hoursWorked,
            overtimeHoursWorked,
            bonusPercentage,
            taxRatePercentage,
            pensionContributionPercentage)
    )
}
