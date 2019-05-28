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
public class AcountBack extends Model<AcountBack> {

	private static final long serialVersionUID = 1L;

	@TableId(value = "ab_id", type = IdType.AUTO)
	private Integer abId;
	@TableField("ab_num")
	private Integer abNum;
	@TableField("ab_description")
	private String abDescription;
	@TableField("ab_time")
	private String abTime;
	@TableField("ab_back")
	private Integer abBack;
	@TableField("ab_backTime")
	private String abBacktime;

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.abId;
	}

}
