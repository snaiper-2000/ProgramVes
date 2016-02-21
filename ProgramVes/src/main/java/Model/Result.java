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
    private String flag4;
    @ManyToOne
    @JoinColumn(name = "id")//из таблицы user
    private User user;
    /*private String prop5;
    private String prop6;
    private String prop7;
    private String prop8;
    private String prop9;
    private String prop10;
    private String prop11;
    private String prop12;
    private String prop13;
    private String prop14;
    private String prop15;
    private String prop16;
    private String prop17;
    private String prop18;
    private String prop19;
    private String prop20;
    private String prop21;
    private String prop22;
    private String prop23;
    private String prop24;
    private String prop25;
    private String prop26;
    private String prop27;
    private String prop28;
    private String prop29;
    private String prop30;
    private String prop31;
    private String prop32;*/

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

	public String getFlag4() {
		return flag4;
	}

	public void setFlag4(String flag4) {
		this.flag4 = flag4;
	}
    
    
}
