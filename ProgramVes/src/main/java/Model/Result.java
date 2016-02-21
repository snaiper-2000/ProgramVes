package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "result_id")
	private Long resultID;
	private String flag1;
    private String flag2;
    private String flag3;
    private String flag5;
    private String flag6;
    private String flag7;
    private String flag8;
    private String flag9;
    private String flag10;
    private String flag11;
    private String flag12;
    private String flag13;
    private String flag14;
    private String flag15;
    private String flag16;
    private String flag17;
    private String flag18;
    private String flag19;
    private String flag20;
    private String flag21;
    private String flag22;
    private String flag23;
    private String flag24;
    private String flag25;
    private String flag26;
    private String flag27;
    private String flag28;
    private String flag29;
    private String flag30;
    private String flag31;
    private String flag32;
    @ManyToOne
    @JoinColumn(name = "id")//из таблицы user
    private User user;
    
    /*@Column(name = "date_result")
    private String dateResult;*/
    

    public Result(){
    	
    }

	public String getFlag1() {
		return flag1;
	}

	public void setFlag1(String flag1) {
		this.flag1 = flag1;
	}

	public String getFlag2() {
		return flag2;
	}

	public void setFlag2(String flag2) {
		this.flag2 = flag2;
	}

	public String getFlag3() {
		return flag3;
	}

	public void setFlag3(String flag3) {
		this.flag3 = flag3;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFlag5() {
		return flag5;
	}

	public void setFlag5(String flag5) {
		this.flag5 = flag5;
	}

	public String getFlag6() {
		return flag6;
	}

	public void setFlag6(String flag6) {
		this.flag6 = flag6;
	}

	public String getFlag7() {
		return flag7;
	}

	public void setFlag7(String flag7) {
		this.flag7 = flag7;
	}

	public String getFlag8() {
		return flag8;
	}

	public void setFlag8(String flag8) {
		this.flag8 = flag8;
	}

	public String getFlag9() {
		return flag9;
	}

	public void setFlag9(String flag9) {
		this.flag9 = flag9;
	}

	public String getFlag10() {
		return flag10;
	}

	public void setFlag10(String flag10) {
		this.flag10 = flag10;
	}

	public String getFlag11() {
		return flag11;
	}

	public void setFlag11(String flag11) {
		this.flag11 = flag11;
	}

	public String getFlag12() {
		return flag12;
	}

	public void setFlag12(String flag12) {
		this.flag12 = flag12;
	}

	public String getFlag13() {
		return flag13;
	}

	public void setFlag13(String flag13) {
		this.flag13 = flag13;
	}

	public String getFlag14() {
		return flag14;
	}

	public void setFlag14(String flag14) {
		this.flag14 = flag14;
	}

	public String getFlag15() {
		return flag15;
	}

	public void setFlag15(String flag15) {
		this.flag15 = flag15;
	}

	public String getFlag16() {
		return flag16;
	}

	public void setFlag16(String flag16) {
		this.flag16 = flag16;
	}

	public String getFlag17() {
		return flag17;
	}

	public void setFlag17(String flag17) {
		this.flag17 = flag17;
	}

	public String getFlag18() {
		return flag18;
	}

	public void setFlag18(String flag18) {
		this.flag18 = flag18;
	}

	public String getFlag19() {
		return flag19;
	}

	public void setFlag19(String flag19) {
		this.flag19 = flag19;
	}

	public String getFlag20() {
		return flag20;
	}

	public void setFlag20(String flag20) {
		this.flag20 = flag20;
	}

	public String getFlag21() {
		return flag21;
	}

	public void setFlag21(String flag21) {
		this.flag21 = flag21;
	}

	public String getFlag22() {
		return flag22;
	}

	public void setFlag22(String flag22) {
		this.flag22 = flag22;
	}

	public String getFlag23() {
		return flag23;
	}

	public void setFlag23(String flag23) {
		this.flag23 = flag23;
	}

	public String getFlag24() {
		return flag24;
	}

	public void setFlag24(String flag24) {
		this.flag24 = flag24;
	}

	public String getFlag25() {
		return flag25;
	}

	public void setFlag25(String flag25) {
		this.flag25 = flag25;
	}

	public String getFlag26() {
		return flag26;
	}

	public void setFlag26(String flag26) {
		this.flag26 = flag26;
	}

	public String getFlag27() {
		return flag27;
	}

	public void setFlag27(String flag27) {
		this.flag27 = flag27;
	}

	public String getFlag28() {
		return flag28;
	}

	public void setFlag28(String flag28) {
		this.flag28 = flag28;
	}

	public String getFlag29() {
		return flag29;
	}

	public void setFlag29(String flag29) {
		this.flag29 = flag29;
	}

	public String getFlag30() {
		return flag30;
	}

	public void setFlag30(String flag30) {
		this.flag30 = flag30;
	}

	public String getFlag31() {
		return flag31;
	}

	public void setFlag31(String flag31) {
		this.flag31 = flag31;
	}

	public String getFlag32() {
		return flag32;
	}

	public void setFlag32(String flag32) {
		this.flag32 = flag32;
	}
    
    
}
