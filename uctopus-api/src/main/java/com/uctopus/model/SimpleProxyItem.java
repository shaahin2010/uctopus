package com.uctopus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class SimpleProxyItem implements ProxyItem {

    private String proxyIp;

    private Integer proxyPort;

}
