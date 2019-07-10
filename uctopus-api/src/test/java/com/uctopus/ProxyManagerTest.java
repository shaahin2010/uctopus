package com.uctopus;

import com.uctopus.proxy.ProxyManager;
import com.uctopus.proxy.impl.CsvProxyManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

public class ProxyManagerTest {

    private ProxyManager pm;

    @Before
    public void setUp() throws Exception {
        this.pm = new CsvProxyManager();
    }

    @Test
    public void fetchAllProxies() {
        Assert.assertNotNull(pm);
        Assert.assertNotNull(pm.findALlProxyItems());
        Assert.assertTrue(pm.findALlProxyItems().size() == 9);
    }

    @Test
    public void proxyTest() throws IOException {
        URL weburl = new URL("https://www.google.com");
        HttpURLConnection directConnection
                = (HttpURLConnection) weburl.openConnection(Proxy.NO_PROXY);
        System.out.println(UrlConnectionUtils.contentAsString(directConnection));
        Assert.fail("proxy connect/disconnect not implemented yet");
    }

}
