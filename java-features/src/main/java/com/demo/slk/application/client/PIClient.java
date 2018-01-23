package com.demo.slk.application.client;

import lombok.Data;

@Data
public class PIClient {
    private String clientId;
    private String consumerDataType;
    private String producerDataType;
    private String authType;
    private String domain;
    private String accessToken;
    private String accessSecretToken;
}
