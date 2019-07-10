package com.uctopus.proxy.impl;

import com.uctopus.exception.UctopusApiException;
import com.uctopus.model.ProxyItem;
import com.uctopus.model.SimpleProxyItem;
import com.uctopus.proxy.ProxyManager;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class CsvProxyManager implements ProxyManager {

    private String csvResource;

    public CsvProxyManager() {
        this("proxies.csv");
    }

    public CsvProxyManager(String csvResource) {
        this.csvResource = csvResource;
    }

    @Override
    public Set<? extends ProxyItem> findALlProxyItems() {
        try {
            Set<SimpleProxyItem> set = new HashSet<SimpleProxyItem>(15);
            InputStream stream = getClass()
                    .getClassLoader().getResourceAsStream(csvResource);
            Reader reader = new InputStreamReader(stream);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());
            for (CSVRecord csvRecord : csvParser) {
                String ip = csvRecord.get(0);
                Integer port = Integer.valueOf(csvRecord.get(1));
                set.add(new SimpleProxyItem(ip, port));
            }
            return set;
        } catch (FileNotFoundException e) {
            throw new UctopusApiException(e.getMessage(), e);
        } catch (IOException e) {
            throw new UctopusApiException(e.getMessage(), e);
        }
    }
}
