package util;

/**
 * 字符串操作工具类
 * @author 朱悦星
 */
public class StringUtils {

    /**
     * 空字符串
     */
    private static final String EMPTY_STRING = "";

    /**
     * 将Blank状态的字符串转为NULL
     * @param str 要判断状态的字符串
     * @return 返回 {@link String#trim()} 后的字符串
     * 如果等于 {@link #EMPTY_STRING} 则返回NULL
     */
    public static String trimToNull(String str){
        if(str == null){
            return null;
        }

        str = str.trim();
        if(EMPTY_STRING.equals(str)){
            return null;
        }
        return str;
    }
}
