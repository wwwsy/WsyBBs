package WsyBBs.acount.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-21
 */
@Data
public class Acount extends Model<Acount> {

	private static final long serialVersionUID = 1L;

	@TableId(value = "acount_id", type = IdType.AUTO)
	private Integer acountId;
	@TableField("acount_num")
	private Integer acountNum;
	@TableField("acount_date")
	private String acountDate;
	@TableField("acount_description")
	private String acountDescription;
	/**
	 * 0-无效 1-未确认 2-已确认 3-计算过
	 */
	private Integer status;
	@TableField("acount_ack")
	private Integer acountAck;
	@TableField("acount_ackTime")
	private String acountAcktime;
	@TableField("acount_record")
	private Integer acountRecord;
	@TableField("acount_recordTime")
	private String acountRecordtime;

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.acountId;
	}

}
