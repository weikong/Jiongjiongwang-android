package com.pet.travel.config;

/**
 * Created by kongwei on 2018/1/28.
 */

public class ServerConfig {

    /**
     * home IP
     * */
//    public static String HTTP_ROOT = "http://192.168.31.90:9090/";
    /**
     * 公司 IP
     */
    public static String HTTP_ROOT = "http://172.16.0.138:9090/";
    /**
     * 阿里云
     */
//    public static String HTTP_ROOT = "http://120.78.81.9/";

    /**
     * 图片下载
     */
    public static String HTTP_DOWNLOAD_FILE_2 = HTTP_ROOT + "download_file?filename=%s";

    /**
     * 查询跑友圈
     */
    public static String HTTP_CIRCLE_QUERY = HTTP_ROOT + "circle/query";

    /**
     * 查询服务
     * type=8:美容
     * type=27:寄养
     */
    public static String HTTP_SERVICE_QUERY = HTTP_ROOT + "pet_service/query_by_type";


}
