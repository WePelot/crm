package com.pelot.utils;

/**
 * 获取mac地址
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-10-09 17:56
 */
public class MacUtil {

    public static String getMacAddr(String ip) throws Exception {
        //带:的mac值
        UdpGetClientMacAddr umac = new UdpGetClientMacAddr(ip);
        String smac = umac.getRemoteMacAddr();
        return smac.replaceAll(":", "-");
    }

    public static void main(String[] args) throws Exception {
//        String ip = "192.168.0.113";
        String ip = "192.168.109.1";
        String macAddr = getMacAddr(ip);
        System.out.println(macAddr);
    }
}

