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
public class AcountTemp extends Model<AcountTemp> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "at_id", type = IdType.AUTO)
    private Integer atId;
    @TableField("at_num")
    private Integer atNum;
    @TableField("at_time")
    private Date atTime;
    @TableField("at_record")
    private Integer atRecord;
    @TableField("at_description")
    private String atDescription;


    public Integer getAtId() {
        return atId;
    }

    public void setAtId(Integer atId) {
        this.atId = atId;
    }

    public Integer getAtNum() {
        return atNum;
    }

    public void setAtNum(Integer atNum) {
        this.atNum = atNum;
    }

    public Date getAtTime() {
        return atTime;
    }

    public void setAtTime(Date atTime) {
        this.atTime = atTime;
    }

    public Integer getAtRecord() {
        return atRecord;
    }

    public void setAtRecord(Integer atRecord) {
        this.atRecord = atRecord;
    }

    public String getAtDescription() {
        return atDescription;
    }

    public void setAtDescription(String atDescription) {
        this.atDescription = atDescription;
    }

    @Override
    protected Serializable pkVal() {
        return this.atId;
    }

    @Override
    public String toString() {
        return "AcountTemp{" +
        ", atId=" + atId +
        ", atNum=" + atNum +
        ", atTime=" + atTime +
        ", atRecord=" + atRecord +
        ", atDescription=" + atDescription +
        "}";
    }
}
