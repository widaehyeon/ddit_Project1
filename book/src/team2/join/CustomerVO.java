package team2.join;

public class CustomerVO {
    private String memId;
    private String memPass;
    private String memName;
    private String memTel;
    private String memAdd;
    private String memRegno1;
    private String memRegno2;

    public CustomerVO() {
    }

    public CustomerVO(String memId, String memPass) {
		this.memId = memId;
		this.memPass = memPass;
	}

    public CustomerVO(String memId, String memPass, String memName, String memTel, String memAdd, String memRegno1,
			String memRegno2) {
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memTel = memTel;
		this.memAdd = memAdd;
		this.memRegno1 = memRegno1;
		this.memRegno2 = memRegno2;
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

	public void invalidate() {
        this.memId = null;
        this.memPass = null;
        this.memName = null;
        this.memTel = null;
        this.memAdd = null;
        this.memRegno1 = null;
        this.memRegno2 = null;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomerVO{");
        sb.append("id=").append(memId);
        sb.append(", password='").append(memPass).append('\'');
        sb.append(", name='").append(memName).append('\'');
        sb.append(", tel='").append(memTel).append('\'');
        sb.append(", address='").append(memAdd).append('\'');
        sb.append(", regno1='").append(memRegno1).append('\'');
        sb.append(", regno2='").append(memRegno2).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
