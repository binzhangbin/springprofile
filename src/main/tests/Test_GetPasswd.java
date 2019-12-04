import cn.bin.zhang.util.MD5Code;

public class Test_GetPasswd {
    private static String charset = "UTF-8";
    public static void main(String[] args) {
        String passwdA="123456";
        System.out.println(new MD5Code().getMD5ofStr(passwdA));//E10ADC3949BA59ABBE56E057F20F883E
    }
}
