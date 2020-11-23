package java18.dto;

/**
 * NewOrderFlowVo
 *
 * @author shisong
 * @date 2020/10/29
 */
public class NewOrderFlowVo {

    /**
     * 主订单号
     */
    private String orderNo;
    /**
     * 费用名称
     */
    private String itemName;

    /**
     * 费用
     */
    private Integer amt;

    /**
     * 支付方式
     */
    private String payTypeContent;

    /**
     * 支付时间
     */
    private String payTimeContent;

    public NewOrderFlowVo(String orderNo, String itemName, Integer amt, String payTypeContent, String payTimeContent) {
        this.orderNo = orderNo;
        this.itemName = itemName;
        this.amt = amt;
        this.payTypeContent = payTypeContent;
        this.payTimeContent = payTimeContent;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getAmt() {
        return amt;
    }

    public void setAmt(Integer amt) {
        this.amt = amt;
    }

    public String getPayTypeContent() {
        return payTypeContent;
    }

    public void setPayTypeContent(String payTypeContent) {
        this.payTypeContent = payTypeContent;
    }

    public String getPayTimeContent() {
        return payTimeContent;
    }

    public void setPayTimeContent(String payTimeContent) {
        this.payTimeContent = payTimeContent;
    }

    @Override
    public String toString() {
        return "NewOrderFlowVo{" +
                "orderNo='" + orderNo + '\'' +
                ", itemName='" + itemName + '\'' +
                ", amt=" + amt +
                ", payTypeContent='" + payTypeContent + '\'' +
                ", payTimeContent='" + payTimeContent + '\'' +
                '}';
    }
}
