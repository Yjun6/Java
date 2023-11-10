package com.example.demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-10
 * Time:16:21
 */

@Component
@ConfigurationProperties(prefix = "dbtypes")
@Data
public class DBtypes {
    private List<String> name;

    private Map<String,String> key;
}
