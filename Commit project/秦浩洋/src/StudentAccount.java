package Java_class_peoject_03;

abstract class StudentAccount {
	private String SName;
	private String SID;
	private int SAge;
	private String SSuject;
	protected double SScore;
	protected String SScoeLevel;

	public StudentAccount(String SName, String SID, int SAge, double SScore, String SSuject, double weightedRate,
			String SScoeLevel) {
		this.SName = SName;
		this.SID = SID;
		this.SAge = SAge;
		this.SSuject = SSuject;
		this.SScore = SScore;
		this.SScoeLevel = SScoeLevel;
	}

	public String getSSuject() {
		return SSuject;
	}

	public void setSSuject(String sSuject) {
		SSuject = sSuject;
	}

	public void KeyInScore(double SScore) throws Exception {
		if (SScore >= 0) {
			this.SScore = SScore;
		} else {
			throw new Exception("錯誤分數！不可為負數。");
		}
	}

	public void KeyInSAge(int SAge) throws Exception {
		if (SAge >= 0) {
			this.SAge = SAge;
		} else {
			throw new Exception("錯誤分數！不可為負數。");
		}
	}

	public String getSName() {
		return SName;
	}

	public void setSName(String sName) {
		SName = sName;
	}

	public String getSID() {
		return SID;
	}

	public void setSID(String sID) {
		SID = sID;
	}

	public int getSAge() {
		return SAge;
	}

	public void setSAge(int sAge) {
		SAge = sAge;
	}

	public double getSScore() {
		return SScore;
	}

	public void setSScore(double sScore) {
		SScore = sScore;
	}

	public String toString() {
		return "學生姓名：" + SName + " ,學號：" + SID + " ,年齡：" + SAge + " ,學科：" + SSuject + " ,分數：" + SScore + " ,評分："
				+ SScoeLevel();
	}

	public abstract String SScoeLevel();

}
