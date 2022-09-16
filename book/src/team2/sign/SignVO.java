package team2.sign;

public class SignVO {
	private String memId;
    private String memPass;
    private String memName;
    private String memTel;
    private String memAdd;
    private String memRegno1;
    private String memRegno2;
    private String memState;
    private String memGrade;
    
    
    
	public SignVO() {
	}

	public SignVO(String memId, String memPass) {
		this.memId = memId;
		this.memPass = memPass;
	}

	public SignVO(String memId, String memPass, String memName, String memTel, String memAdd, String memRegno1,
			String memRegno2, String memState, String memGrade) {
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memTel = memTel;
		this.memAdd = memAdd;
		this.memRegno1 = memRegno1;
		this.memRegno2 = memRegno2;
		this.memState = memState;
		this.memGrade = memGrade;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPass() {
		return memPass;
	}

	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public String getMemAdd() {
		return memAdd;
	}

	public void setMemAdd(String memAdd) {
		this.memAdd = memAdd;
	}

	public String getMemRegno1() {
		return memRegno1;
	}

	public void setMemRegno1(String memRegno1) {
		this.memRegno1 = memRegno1;
	}

	public String getMemRegno2() {
		return memRegno2;
	}

	public void setMemRegno2(String memRegno2) {
		this.memRegno2 = memRegno2;
	}

	public String getMemState() {
		return memState;
	}

	public void setMemState(String memState) {
		this.memState = memState;
	}

	public String getMemGrade() {
		return memGrade;
	}

	public void setMemGrade(String memGrade) {
		this.memGrade = memGrade;
	}

	@Override
	public String toString() {
		return String.format(
				"signVO [memId=%s, memPass=%s, memName=%s, memTel=%s, memAdd=%s, memRegno1=%s, memRegno2=%s, memState=%s, memGrade=%s]",
				memId, memPass, memName, memTel, memAdd, memRegno1, memRegno2, memState, memGrade);
	}
}
