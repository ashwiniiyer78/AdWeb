package com.bestbuy.adeng.model;

import lombok.Data;

@Data
public class AdDetails {
    private String queryId;
    private String divName;
    private String slotSize;
    private String creativeId;
    private String overlayStatus;
    private String iframeType;
    private String timeToFetch;
}
