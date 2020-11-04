package com.coldchain.framework.config.pay;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 阿里支付
 */
@Data
@ConfigurationProperties(prefix = "alipay")
@Component
public class AliPayAccountConfig {
    /**
     * appId
     */
    private String appId;
    /**
     * 商户私钥
     */
    private String privateKey;
    /**
     * 支付宝公钥
     */
    private String aliPayPublicKey;
    /**
     * 异步通知url
     */
    private String notifyUrl;

    /**
     * 同步返回的url
     */
    private String returnUrl;
}
