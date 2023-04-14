package lib;

import java.time.LocalDate;

public class Employee {
	private EmployeeData employeedata;
	private LocalDate dateJoined; // Primitive Obsession
	private int monthWorkingInYear;

	private boolean isForeigner;
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;

	public Employee(EmployeeData employeedata, LocalDate dateJoined, boolean isForeigner) {
		this.employeedata = employeedata;
		this.dateJoined = dateJoined;
		this.isForeigner = isForeigner;
	}

	// Long Method
	public void setMonthlySalary(int grade) {
		switch (grade) {
			case 1:
				monthlySalary = 3000000;
				break;
			case 2:
				monthlySalary = 5000000;
				break;
			case 3:
				monthlySalary = 7000000;
				break;
			default:
				monthlySalary = 0;
				break;
		}

		if (isForeigner) {
			monthlySalary *= 1.5;
		}
	}

	public void setAnnualDeductible(int deductible) {
		this.annualDeductible = deductible;
	}

	public void setAdditionalIncome(int income) {
		this.otherMonthlyIncome = income;
	}

	// Long Method
	public int getAnnualIncomeTax() {
		calculateMonthWorkInYear();

		return TaxFunction.calculateTax(
				monthlySalary,
				otherMonthlyIncome,
				monthWorkingInYear,
				annualDeductible,
				employeedata.getspouseIdNumber().equals(""),
				employeedata.getchildIdNumbers().size());
	}

	private void calculateMonthWorkInYear() {
		LocalDate date = LocalDate.now();

		if (date.getYear() == dateJoined.getYear()) {
			monthWorkingInYear = date.getMonthValue() - dateJoined.getMonthValue();
		} else {
			monthWorkingInYear = 12;
		}
	}
}
