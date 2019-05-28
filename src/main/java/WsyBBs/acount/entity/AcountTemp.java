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
public class AcountTemp extends Model<AcountTemp> {

	private static final long serialVersionUID = 1L;

	@TableId(value = "at_id", type = IdType.AUTO)
	private Integer atId;
	@TableField("at_num")
	private Integer atNum;
	@TableField("at_time")
	private String atTime;
	@TableField("at_record")
	private Integer atRecord;
	@TableField("at_description")
	private String atDescription;
	@TableField("at_recordTime")
	private String atRecordTime;

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.atId;
	}

}
