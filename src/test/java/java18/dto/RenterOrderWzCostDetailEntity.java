package java18.dto;

/**
 * RenterOrderWzCostDetailEntity
 *
 * @author shisong
 * @date 2019/12/28
 */
public class RenterOrderWzCostDetailEntity {
	/**
	*费用描述
	*/
	private String costDesc;
	/**
	*总价
	*/
	private Integer amount;
	/**
	*备注
	*/
	private String remark;

	public String getCostDesc() {
		return costDesc;
	}

	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
