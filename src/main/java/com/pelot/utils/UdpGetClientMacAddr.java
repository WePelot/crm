/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.utils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * TODO
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-10-09 17:59
 */
public class UdpGetClientMacAddr {
    private String sRemoteAddr;
    private int iRemotePort = 137;
    private byte[] buffer = new byte[1024];
    private DatagramSocket ds = null;

    public UdpGetClientMacAddr(String strAddr) throws Exception {
        sRemoteAddr = strAddr;
        ds = new DatagramSocket();
    }

    protected final DatagramPacket send(final byte[] bytes) throws IOException {
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(sRemoteAddr), iRemotePort);
        ds.send(dp);
        return dp;
    }

    protected final DatagramPacket receive() throws Exception {
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        ds.receive(dp);
        return dp;
    }

    protected byte[] getQueryCmd() throws Exception {
        byte[] tns = new byte[50];
        tns[0] = 0x00;
        tns[1] = 0x00;
        tns[2] = 0x00;
        tns[3] = 0x10;
        tns[4] = 0x00;
        tns[5] = 0x01;
        tns[6] = 0x00;
        tns[7] = 0x00;
        tns[8] = 0x00;
        tns[9] = 0x00;
        tns[10] = 0x00;
        tns[11] = 0x00;
        tns[12] = 0x20;
        tns[13] = 0x43;
        tns[14] = 0x4B;

        for (int i = 15; i < 45; i++) {
            tns[i] = 0x41;
        }

        tns[45] = 0x00;
        tns[46] = 0x00;
        tns[47] = 0x21;
        tns[48] = 0x00;
        tns[49] = 0x01;
        return tns;
    }

    protected final String getMacAddr(byte[] brevdata) throws Exception {

        int i = brevdata[56] * 18 + 56;
        String sAddr = "";
        StringBuffer sb = new StringBuffer(17);

        for (int j = 1; j < 7; j++) {
            sAddr = Integer.toHexString(0xFF & brevdata[i + j]);
            if (sAddr.length() < 2) {
                sb.append(0);
            }
            sb.append(sAddr.toUpperCase());
            if (j < 6) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    public final void close() {
        try {
            ds.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public final String getRemoteMacAddr() throws Exception {
        byte[] bqcmd = getQueryCmd();
        send(bqcmd);
        DatagramPacket dp = receive();
        String smac = getMacAddr(dp.getData());
        close();

        return smac;
    }
}
