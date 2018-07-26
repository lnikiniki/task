package com.epam.lab.proxyPattern;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {
    private static List<String> banned;

    static {
        banned = new ArrayList<>();
        banned.add("bannedSite.com");
        banned.add("anotherBannedSite.com");
    }

    @Override
    public void connectTo(String url) throws Exception {
        if(banned.contains(url))
            throw new Exception("Access denied to " +url);
        Internet internet = new RealInternet();
        internet.connectTo(url);
    }
}
