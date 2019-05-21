package WsyBBs.user.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
 * @since 2019-05-05
 */
public class Group extends Model<Group> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "group_id", type = IdType.AUTO)
    private Integer groupId;
    @TableField("group_name")
    private String groupName;


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    protected Serializable pkVal() {
        return this.groupId;
    }

    @Override
    public String toString() {
        return "Group{" +
        ", groupId=" + groupId +
        ", groupName=" + groupName +
        "}";
    }
}
