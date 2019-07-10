package com.uctopus.proxy;

import com.uctopus.model.ProxyItem;

import java.util.Set;

public interface ProxyManager {

    Set<? extends ProxyItem> findALlProxyItems();

}
