package org.example.ebookstoreapp2;

import lombok.Getter;
import lombok.Value;
import org.springframework.stereotype.Component;
import org.springframework.cloud.context.config.annotation.RefreshScope;
@Getter
@Component
@RefreshScope
public class ValueRefreshConfigBean {
    private Object staticConstructor;
    @Value("$" )
    private String color;

}
