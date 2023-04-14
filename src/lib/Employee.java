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

	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya
	 * (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3:
	 * 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */

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

	public int getAnnualIncomeTax() {

		// Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		// bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();

		if (date.getYear() == dateJoined.getYear()) {
			monthWorkingInYear = date.getMonthValue() - dateJoined.getMonthValue();
		} else {
			monthWorkingInYear = 12;
		}

		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible,
				employeedata.getspouseIdNumber().equals(""), employeedata.getchildIdNumbers().size());
	}
}
