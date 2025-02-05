package com.yy.linxiweb.constant;

public class CommonConstant {

  public static final String SUCCESS = "调用成功!";
  public static final String FAIL = "出现未知异常，调用失败!";
  public static final int SUCCESS_CODE = 0;//成功code
  public static final int FAIL_CODE = 1;//失败code


  /**
   * http请求
   */
  public static final String HTTP = "http://";

  /**
   * https请求
   */
  public static final String HTTPS = "https://";

  /**
   * www主域
   */
  public static final String WWW = "www.";


  /** 校验是否唯一的返回标识 */
  public final static boolean UNIQUE = true;

  public final static boolean NOT_UNIQUE = false;

  /**
   * 所有权限标识
   */
  public static final String ALL_PERMISSION = "*:*:*";

  /**
   * 所有url权限标识
   */
  public static final String ALL_PERMISSION_URI = "**";

  /**
   * 管理员角色权限标识
   */
  public static final String SUPER_ADMIN = "admin";


}
