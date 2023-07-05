package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.stereotype.Component;
//热更新配置
@Data
@Component
//每个属性前加上前缀
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    private String dateformat;
    private String envSharedValue;
}
