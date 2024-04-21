package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	private static final int BASE_INCOME = 54000000;
	private static final int MARRIED_INCREMENT = 4500000;
	private static final int CHILD_INCREMENT = 4500000;
	private static final int MAX_CHILDREN = 3;
	private static final double TAX_RATE = 0.05;

	private static int calculateTaxableIncome(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int annualDeductible, boolean isMarried, int numberOfChildren) {
		int untaxedIncome = BASE_INCOME + (isMarried ? MARRIED_INCREMENT : 0) + (numberOfChildren * CHILD_INCREMENT);
		return (int) Math.round(((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - annualDeductible) - untaxedIncome;
	}

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int annualDeductible, boolean isMarried, int numberOfChildren) {
		
		int tax = 0;
		
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
		
		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}

		annualTax = calculateTaxableIncome(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, annualDeductible, isMarried, numberOfChildren);
		annualTax = annualTax > 0 ?	Math.round(TAX_RATE * taxableIncome) : annualTax;

		if (annualTax < 0) {
			return 0;
		}else {
			return annualTax;
		}
			 
	}
	
}
