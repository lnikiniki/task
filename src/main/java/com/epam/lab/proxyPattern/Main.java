package com.epam.lab.proxyPattern;

import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
       startProxyPattern();
    }

    private static void startProxyPattern(){
        Internet internet = new ProxyInternet();
        try{
            internet.connectTo("site.com");
            internet.connectTo("bannedSite.com");
        }catch (Exception e){
            LOG.info(e.getMessage());
        }
    }
}


