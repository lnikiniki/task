package com.epam.lab.proxyPattern;

import org.apache.log4j.Logger;

public class RealInternet implements Internet {
    private final static Logger LOG = Logger.getLogger(RealInternet.class);

    @Override
    public void connectTo(String url) throws Exception {
        LOG.info("Connecting to " + url);
    }
}


