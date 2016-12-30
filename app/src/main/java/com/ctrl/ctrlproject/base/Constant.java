package com.ctrl.ctrlproject.base;

/**
 * 全局静态变量类
 * 用于存放全局的静态变量, 如 服务地址, 支付宝微信等支付手段信息配置
 *  Created by jaosn on 2016-12-2.
 */
public class Constant {

    /**服务地址 根路径 的配置 - Eric - */
    public static final String RAW_URL = "http://115.28.243.3:8002/pm/api?";//三期测试地址

    /**请求dao时传递参数 - Eric - **/
    public static String APPKEY = "appKey";//用用程序的key
    public static String APPKEY_VALUE = "002";//用用程序的key
    public static String SECRET = "secret";//密匙
    public static String SECRET_VALUE = "abc";//密匙
    public static String VERSION = "v";//版本
    public static String VERSION_VALUE = "1.0";//版本
    public static String FORMAT = "format";//输出格式 JSON
    public static String FORMAT_VALUE = "JSON";//输出格式 JSON
    public static String TYPE = "type";//1:android  2:IOS  3:web
    public static String TYPE_VALUE = "1";//1:android  2:IOS  3:web
    public static String METHOD = "method";//方法名

    /**支付宝相关 支付信息的配置 - Eric - */
    /*支付宝回调接口*/
    public static final String ALIPLY_URL = "http://121.42.159.145:8088/pm/alipayOrderNotify.do";
    /*合作商户ID。用签约支付宝账号登录ms.alipay.com后，在账户信息页面获取。 例: 2088812260656255*/
    public static final String PARTNER = "2088611541296867";
    /*商户收款的支付宝账号 例: wushidadao77@163.com*/
    public static final String SELLER = "cxhzijin01@163.com";//
    /*商户私钥 例: MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJ+Q9tJIfK5PvZtC6eGgucND3cOEBbc6wUJVrsgEPKiYJmMFJFe0fya1hvPragz4scRw+ozi45e4eeWnpMUJmXg4pYyZcpozom1nsGlp293DE29nqJvXTv0qEzNqZcQgSCkoZzVBTnaREw6o2XBXKyVt11B4DrYWTBqFDWyhzlkHAgMBAAECgYEAiHreklgLxLBRtdYS47isitamfM+Ub/diS5Gr8Eqnc3DIDJPeVOH+i6Ziaoll6PhiXGph81UxY5kXMhYk+Z9PUsnOq6piLR6jajs7/PQbeUOrK/27lzKx97f2/zVacFadkx33P/ReXNe6sCY7xvVr8AiDL2Qyh0TiNhmfzx39CDECQQDThTngCjCVEO1AjCX9keA3E3isAaZeDGWXfkdO4JIsOnCyRh/V1QiUvCwbpgdvdxf+N9RsQxC2faR/p9/7UDffAkEAwR7kOzuq/dGTTb65xTSY314O3qe3oaK+G9euWzQPavj+DybxhClqc1HNcYoHteM47Mry1vOmeRY+iug4UESj2QJATGyDd7ZWzVU7U6oPg+m0CFJJtGQ4Nxzli/H9U7uCNOa8lz0M/ZamLg87JJY9c4GlMp37a05j+Hu29sSyAbx/IwJAfGKMN8aHrLGmgcWdW3I0IHIxe6FkufvbHI2/ZEjUwV6cLGA14JzYTmxauY1gx/sQ+BsDbAVErOrx34AQfUqoiQJBANNb9XhPjFNYsjMlqlV2ccYURzQNQkqSZZF2WuudoglxtgiK0w+RbdZcB8cRi/EkuNT6CODb3chlJCNpTpn/CXQ=*/
    public static final String RSA_PRIVATE = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAMhfPjU63z1bdfZuyf0ZD47iQKvOR8ZpxOYEJ96yyKL7TMa8hfRcnMVWMDVl9icYKDAN7ykAQYvJCeWkvuYsRj3CBhJFBsShkOdzGZG+Zf/gzPbQ27BXdYjnmmklObZl9UiYM8HeQG/M9m576QWJhVa3gLCG4u9nhG7Oar7SropfAgMBAAECgYBTtU50yHKI3JPMbv5diUGxrJ3d6KCdqIREn8nURJaDWD7767h+nM41tssPE9ig/nuTj86xL1Uyw7spwAiseiShXQm4XDUTEyeo3S4M96gO/0510mEVx5lT9MV0lIqAM12PbyTxNWn3SOg9ds/Fu0TQqLip6SgQDqiEnfAn8VZ4oQJBAOf6aGxFrIQaDAn6gs0PPj29wi3vbVHCr3YtdO4WgCTuVWgN8bhw4QlGNuTohztL8NNbEIAmqn/igCdgEVHW6G8CQQDdHvoxpJLHVRpBSkYVcwG17uihQAUK4xKcBXsjpqHBP8Xvix6aJ3F9ccqhkMMrbUh6zeLOrlg7/oswmFgfKBURAkBHeeds3Pbv6RqmhHKC/lxeJ7bJ8ojLdWIc1pq9tV8cgfb8zbcZ7mXYNrM5StBIG/kDFn76DW/hYYe9GiOcBMyvAkAflldDVDErjHqtrQCJ+93YsYJF1rFhtsJny1il5R3iT0vlRkhe2RebRfAeWGGpCHl8IYEu6TTtjRUxIfIksUMhAkBQhhxe8NyNGZblel6ubCCnok6DQNBvJ+tzo80yh67S3kxuOO1rZFul1XTlFF08ME03nZ66aELUyWtW3kHxr4UU";

    /**微信相关 支付信息的配置 - Eric - */
    /*微信分配的公众账号ID 例: wx6848dc314d5a2b80*/
    public static final String APP_ID = "wxae1e8e0c9c574912";
    /*微信支付分配的商户号 例: 1232506602*/
    public static final String MCH_ID = "1298087001";
    /*API密钥，在商户平台设置 例: q1w2e3r4t5y6u7i8o9p0asdfghjklzxc*/
    public static final String API_KEY="e7d814bbbf364f8ab06431d8efda5928";
    //异步通知地址
    public static final String NOTICE_URL="http://121.42.159.145:8088/pm/wxOrderNotify.do";
    /*微信支付返回Code  固定值*/
    public static final int PAY_STATUS_SUCCESS = 0;//微信支付成功
    public static final int PAY_STATUS_FAILED = -1;//微信支付失败
    public static final int PAY_STATUS_CANCLE = -2;//微信支付 被取消

    /**下载地址*/
    public static final String SD_DOWNLOAD_PATH = "apt/download";

    /**列表数据每页显示的条数 - Eric - 20150929*/
    public static final int ROW_COUNT_PER_PAGE = 10;




}

