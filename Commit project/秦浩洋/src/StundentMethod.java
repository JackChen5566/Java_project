package Java_class_peoject_03;

import java.security.PublicKey;

import Java_class_peoject_02.BankAccount;

class bachelorAccount extends StudentAccount {

	private double WeightedRate;

	public bachelorAccount(String SName, String SID, int SAge, double SScore, double WeightedRate, String SSuject) {
		super(SName, SID, SAge, SScore, SSuject, WeightedRate, SSuject);
		// TODO Auto-generated constructor stub
		this.WeightedRate = WeightedRate;
	}

	public double getWeightedRate() {
		return WeightedRate;
	}

	public void applyWeightedRate() throws Exception {
		double temp;
		temp = getSScore() * (WeightedRate / 100);
		KeyInScore(temp);
	}

	@Override
	public String SScoeLevel() {
		// TODO Auto-generated method stub
		if (SScore >= 90) {
			return " S ";
		} else if (SScore >= 80) {
			return " A ";
		} else if (SScore >= 70) {
			return " B ";
		} else if (SScore >= 60) {
			return " C ";
		} else if (SScore >= 50) {
			return " D ";
		} else if (SScore >= 40) {
			return " E ";
		} else if (SScore < 40) {
			return " F ";
		}
		return SScoeLevel;
	}

	@Override
	public String toString() {
		return super.toString()  + " 學士生加權 " + " ,加權值： " + WeightedRate + "%";
	}
}

class masterAccount extends StudentAccount {

	private double WeightedRate;

	public masterAccount(String SName, String SID, int SAge, double SScore, double WeightedRate, String SSuject) {
		super(SName, SID, SAge, SScore, SSuject, WeightedRate, SSuject);
		// TODO Auto-generated constructor stub
		this.WeightedRate = WeightedRate;
	}

	public double getWeightedRate() {
		return WeightedRate;
	}

	public void applyWeightedRate() throws Exception {
		double temp;
		temp = getSScore() * (WeightedRate / 100);
		KeyInScore(temp);
	}

	@Override
	public String SScoeLevel() {
		// TODO Auto-generated method stub
		if (SScore >= 90) {
			return " S ";
		} else if (SScore >= 80) {
			return " A ";
		} else if (SScore >= 70) {
			return " B ";
		} else if (SScore >= 60) {
			return " C ";
		} else if (SScore >= 50) {
			return " D ";
		} else if (SScore >= 40) {
			return " E ";
		} else if (SScore < 40) {
			return " F ";
		}
		return SScoeLevel;
	}

	@Override
	public String toString() {
		return super.toString() + "碩士生加權 " + " ,加權值： " + WeightedRate + "%";
	}

}