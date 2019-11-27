package cxt.cn.domain;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {

  private long id;
  private String name;
  private String email;
  private String phone;
  private String username;
  private String password;



}
