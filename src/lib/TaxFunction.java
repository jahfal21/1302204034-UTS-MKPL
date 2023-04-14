package lib;

public class TaxFunction {
	private static final double TAX_RATE = 0.05;
	private static final int MAX_CHILDREN = 3;
	private static final int BASE_DEDUCTIBLE = 54000000;
	private static final int MARRIED_DEDUCTIBLE = 4500000;
	private static final int CHILD_DEDUCTIBLE = 1500000;

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible,
			boolean isMarried, int numberOfChildren) {
		validateInput(numberOfMonthWorking);

		int totalIncome = calculateTotalIncome(monthlySalary, otherMonthlyIncome, numberOfMonthWorking);
		int totalDeductible = calculateTotalDeductible(deductible, isMarried, numberOfChildren);
		int taxableIncome = totalIncome - totalDeductible;

		int tax = (int) Math.round(TAX_RATE * taxableIncome);
		return Math.max(tax, 0);
	}

	private static void validateInput(int numberOfMonthWorking) {
		if (numberOfMonthWorking > 12) {
			throw new IllegalArgumentException("More than 12 month working per year");
		}
	}

	private static int calculateTotalIncome(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking) {
		return (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
	}

	private static int calculateTotalDeductible(int deductible, boolean isMarried, int numberOfChildren) {
		int totalDeductible = deductible + BASE_DEDUCTIBLE;
		if (isMarried) {
			totalDeductible += MARRIED_DEDUCTIBLE;
		}
		totalDeductible += Math.min(numberOfChildren, MAX_CHILDREN) * CHILD_DEDUCTIBLE;
		return totalDeductible;
	}
}
