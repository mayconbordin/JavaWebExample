package com.app.controller;

import com.app.util.browser.BrowserSniffer;
import com.app.util.browser.UserAgentTools;
import com.app.util.controller.Controller;

/**
 *
 * @author maycon
 */

public class UserInfoController extends Controller {

    private String browserName;
    private String osName;
    private String ip;

    public String index() {
        String userAgent = request.getHeader("User-Agent");

        browserName = UserAgentTools.getBrowser(userAgent)[1];
        osName = UserAgentTools.getOS(userAgent)[0];
        setIp(request.getRemoteAddr());
        
        return SUCCESS;
    }

    /**
     * @return the browserName
     */
    public String getBrowserName() {
        return browserName;
    }

    /**
     * @param browserName the browserName to set
     */
    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    /**
     * @return the osName
     */
    public String getOsName() {
        return osName;
    }

    /**
     * @param osName the osName to set
     */
    public void setOsName(String osName) {
        this.osName = osName;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

}