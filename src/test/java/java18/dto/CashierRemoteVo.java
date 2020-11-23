package java18.dto;

import java.time.LocalDateTime;

/**
 * CashierRemoteVo
 *
 * @author shisong
 * @date 2020/11/20
 */
public class CashierRemoteVo {
    /**
     * 租车押金:01,违章押金:02,补付租车押金:03,坦客-租车费用:04,坦客-押金费用:05,充值:06,欠款:07,补付租车押金,管理后台v5.11:08,长租线上费用支付:09,PMS:10,默认:99
     */
    private String payKind;
    /**
     * 支付金额
     */
    private Integer payAmt;


    public String getPayKind() {
        return payKind;
    }

    public void setPayKind(String payKind) {
        this.payKind = payKind;
    }

    public Integer getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(Integer payAmt) {
        this.payAmt = payAmt;
    }

    public CashierRemoteVo(String payKind, Integer payAmt) {
        this.payKind = payKind;
        this.payAmt = payAmt;
    }
}
