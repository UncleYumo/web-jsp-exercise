package com.itheima.utils;

/**
 * @author uncle_yumo
 * @CreateDate 2024/6/15
 * @School 无锡学院
 * @StudentID 22344131
 * @Description
 */
public class Color_Print_Utils {
    private static Color_Print_Utils instance = null;
    public String Font_Color_Black = "\33[30;1m"; // 黑色字体
    public String Font_Color_Red = "\33[31;1m"; // 红色字体
    public String Font_Color_Green = "\33[32;1m"; // 绿色字体
    public String Font_Color_Yellow = "\33[33;1m"; // 黄色字体
    public String Font_Color_Blue = "\33[34;1m"; // 蓝色字体
    public String Font_Color_Purple = "\33[35;1m"; // 紫色字体
    public String Font_Color_Cyan = "\33[36;1m"; // 青色字体
    public String Font_Color_White = "\33[37;1m"; // 白色字体
    private final String Font_Color_Reset = "\33[0m"; // 字体颜色恢复
    public String Background_Color_Black = "\33[40m"; // 黑色背景
    public String Background_Color_Red = "\33[41m"; // 红色背景
    public String Background_Color_Green = "\33[42m"; // 绿色背景
    public String Background_Color_Yellow = "\33[43m"; // 黄色背景
    public String Background_Color_Blue = "\33[44m"; // 蓝色背景
    public String Background_Color_Purple = "\33[45m"; // 紫色背景
    public String Background_Color_Cyan = "\33[46m"; // 青色背景
    public String Background_Color_White = "\33[47m"; // 白色背景
    private final String Background_Color_Reset = "\33[0m"; // 背景颜色恢复

    public static Color_Print_Utils getInstance() {
        if (instance == null) {
            instance = new Color_Print_Utils();
        }
        return instance;
    }

    /**
     * 打印黑色字体
     * @param str 要打印的字符串
     */
    public void printlnBlack(String str) {
        System.out.println(Font_Color_Black + str + Font_Color_Reset);
    }
    /**
     * 打印红色字体
     * @param str 要打印的字符串
     */
    public void printlnRed(String str) {
        System.out.println(Font_Color_Red + str + Font_Color_Reset);
    }
    /**
     * 打印绿色字体
     * @param str 要打印的字符串
     */
    public void printlnGreen(String str) {
        System.out.println(Font_Color_Green + str + Font_Color_Reset);
    }
    /**
     * 打印黄色字体
     * @param str 要打印的字符串
     */
    public void printlnYellow(String str) {
        System.out.println(Font_Color_Yellow + str + Font_Color_Reset);
    }
    /**
     * 打印蓝色字体
     * @param str 要打印的字符串
     */
    public void printlnBlue(String str) {
        System.out.println(Font_Color_Blue + str + Font_Color_Reset);
    }
    /**
     * 打印紫色字体
     * @param str 要打印的字符串
     */
    public void printlnPurple(String str) {
        System.out.println(Font_Color_Purple + str + Font_Color_Reset);
    }
    public void printlnPurple(int str) {
        System.out.println(Font_Color_Purple + str + Font_Color_Reset);
    }
    /**
     * 打印青色字体
     * @param str 要打印的字符串
     */
    public void printlnCyan(String str) {
        System.out.println(Font_Color_Cyan + str + Font_Color_Reset);
    }
    /**
     * 打印白色字体
     * @param str 要打印的字符串
     */
    public void printlnWhite(String str) {
        System.out.println(Font_Color_White + str + Font_Color_Reset);
    }
    /**
     * 打印指定的字体颜色和背景颜色的字符串
     * @param fontColor 字体颜色
     * @param backgroundColor 背景颜色
     * @param str 要打印的字符串
     */
    public void printlnFontAndBackgroundWithColor(String fontColor, String backgroundColor, String str) {
        System.out.println(fontColor + backgroundColor + str + Font_Color_Reset);
    }

    /**
     * 打印青色背景、黑色字体的字符串
     * @param str 要打印的字符串
     */
    public void printlnCyanBlack(String str) {
        System.out.println(Background_Color_Cyan + Font_Color_Black + str + Font_Color_Reset + Background_Color_Reset);
    }

    public void programStart() {
        printlnWhite("-------------------------- program start --------------------------\n");
    }
    public void programEnd() {
        printlnWhite("\n--------------------------- program end ---------------------------");
    }
}
