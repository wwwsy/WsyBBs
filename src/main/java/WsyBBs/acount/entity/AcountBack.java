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
public class AcountBack extends Model<AcountBack> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ab_id", type = IdType.AUTO)
    private Integer abId;
    @TableField("ab_num")
    private Integer abNum;
    @TableField("ab_description")
    private String abDescription;
    @TableField("ab_time")
    private Date abTime;
    @TableField("ab_back")
    private Integer abBack;
    @TableField("ab_backTime")
    private Date abBacktime;


    public Integer getAbId() {
        return abId;
    }

    public void setAbId(Integer abId) {
        this.abId = abId;
    }

    public Integer getAbNum() {
        return abNum;
    }

    public void setAbNum(Integer abNum) {
        this.abNum = abNum;
    }

    public String getAbDescription() {
        return abDescription;
    }

    public void setAbDescription(String abDescription) {
        this.abDescription = abDescription;
    }

    public Date getAbTime() {
        return abTime;
    }

    public void setAbTime(Date abTime) {
        this.abTime = abTime;
    }

    public Integer getAbBack() {
        return abBack;
    }

    public void setAbBack(Integer abBack) {
        this.abBack = abBack;
    }

    public Date getAbBacktime() {
        return abBacktime;
    }

    public void setAbBacktime(Date abBacktime) {
        this.abBacktime = abBacktime;
    }

    @Override
    protected Serializable pkVal() {
        return this.abId;
    }

    @Override
    public String toString() {
        return "AcountBack{" +
        ", abId=" + abId +
        ", abNum=" + abNum +
        ", abDescription=" + abDescription +
        ", abTime=" + abTime +
        ", abBack=" + abBack +
        ", abBacktime=" + abBacktime +
        "}";
    }
}
