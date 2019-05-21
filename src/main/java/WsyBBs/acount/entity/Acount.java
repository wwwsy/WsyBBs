package WsyBBs.acount.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-21
 */
public class Acount extends Model<Acount> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "acount_id", type = IdType.AUTO)
    private Integer acountId;
    @TableField("acount_num")
    private Integer acountNum;
    @TableField("acount_date")
    private Date acountDate;
    @TableField("acount_description")
    private String acountDescription;
    /**
     * 0-无效 1-未确认 2-已确认 3-计算过
     */
    private Integer status;
    @TableField("acount_ack")
    private Integer acountAck;
    @TableField("acount_ackTime")
    private Date acountAcktime;
    @TableField("acount_record")
    private Integer acountRecord;
    @TableField("acount_recordTime")
    private Date acountRecordtime;


    public Integer getAcountId() {
        return acountId;
    }

    public void setAcountId(Integer acountId) {
        this.acountId = acountId;
    }

    public Integer getAcountNum() {
        return acountNum;
    }

    public void setAcountNum(Integer acountNum) {
        this.acountNum = acountNum;
    }

    public Date getAcountDate() {
        return acountDate;
    }

    public void setAcountDate(Date acountDate) {
        this.acountDate = acountDate;
    }

    public String getAcountDescription() {
        return acountDescription;
    }

    public void setAcountDescription(String acountDescription) {
        this.acountDescription = acountDescription;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAcountAck() {
        return acountAck;
    }

    public void setAcountAck(Integer acountAck) {
        this.acountAck = acountAck;
    }

    public Date getAcountAcktime() {
        return acountAcktime;
    }

    public void setAcountAcktime(Date acountAcktime) {
        this.acountAcktime = acountAcktime;
    }

    public Integer getAcountRecord() {
        return acountRecord;
    }

    public void setAcountRecord(Integer acountRecord) {
        this.acountRecord = acountRecord;
    }

    public Date getAcountRecordtime() {
        return acountRecordtime;
    }

    public void setAcountRecordtime(Date acountRecordtime) {
        this.acountRecordtime = acountRecordtime;
    }

    @Override
    protected Serializable pkVal() {
        return this.acountId;
    }

    @Override
    public String toString() {
        return "Acount{" +
        ", acountId=" + acountId +
        ", acountNum=" + acountNum +
        ", acountDate=" + acountDate +
        ", acountDescription=" + acountDescription +
        ", status=" + status +
        ", acountAck=" + acountAck +
        ", acountAcktime=" + acountAcktime +
        ", acountRecord=" + acountRecord +
        ", acountRecordtime=" + acountRecordtime +
        "}";
    }
}
