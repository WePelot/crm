package com.pelot.controller.base;

import com.pelot.constant.CookieConstant;
import com.pelot.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *基础的控制类
 * @author hongcj
 * @version V1.0
 * @since 2017/9/24 14:13.
 */
@Controller
@Slf4j
public class BaseController {

    public HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request;
    }

    public Cookie getToken() {
        return CookieUtil.get(getRequest(), CookieConstant.TOKEN);
    }

    /**
     * 获取用户端的IP
     */
    public String getIP() {
        HttpServletRequest request = getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null) {
            ip = "";
        }
        if ("127.0.0.1".equals(ip) || "localhost".equalsIgnoreCase(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
            InetAddress addr;
            try {
                addr = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                return null;
            }
            ip = addr.getHostAddress();
        }

        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15 && ip.indexOf(",") > 0) {
            // "***.***.***.***".length()
            // = 15
            ip = ip.substring(0, ip.indexOf(","));
        }
        return ip;
    }

    /**
     * 获取销售的用户ID
     *
     * @return
     */
    public String getUserId() {
        //获取cookie
        Cookie cookie = getToken();
        if (cookie != null) {
            //获取userId,token为随机字符串+用户ID+用户身份,以_分割
            try {
                String value = cookie.getValue();
                String[] split = value.split("_");
                return split[1];
            } catch (Exception e) {
                log.error("获取销售的用户ID是失败,cookie={},e={}", cookie, e);
                return null;
            }

        }
        return null;
    }


    /**
     * 获取销售身份
     */
    public Integer getIdentity() {
        //获取cookie
        Cookie cookie = CookieUtil.get(getRequest(), CookieConstant.TOKEN);
        if (cookie != null) {
            //获取userId,token为随机字符串+用户ID+用户身份,以_分割
            try {
                String value = cookie.getValue();
                String[] split = value.split("_");
                return Integer.parseInt(split[2]);
            } catch (Exception e) {
                log.error("获取销售的身份失败,cookie={},e={}", cookie, e);
                return null;
            }
        }
        return null;
    }

    /**
     * 获取销售身份
     */
    public String getBelong() {
        //获取cookie
        Cookie cookie = CookieUtil.get(getRequest(), CookieConstant.TOKEN);
        if (cookie != null) {
            //获取userId,token为随机字符串+用户ID+用户身份+所属上级,以_分割
            try {
                String value = cookie.getValue();
                String[] split = value.split("_");
                return split[3];
            } catch (Exception e) {
                log.error("获取销售所属上级,cookie={},e={}", cookie, e);
                return null;
            }
        }
        return null;
    }
}
