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
public class Auth extends Model<Auth> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "auth_id", type = IdType.AUTO)
    private Integer authId;
    @TableField("auth_right")
    private String authRight;


    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getAuthRight() {
        return authRight;
    }

    public void setAuthRight(String authRight) {
        this.authRight = authRight;
    }

    @Override
    protected Serializable pkVal() {
        return this.authId;
    }

    @Override
    public String toString() {
        return "Auth{" +
        ", authId=" + authId +
        ", authRight=" + authRight +
        "}";
    }
}
