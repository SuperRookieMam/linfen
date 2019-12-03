package com.dm.linfen.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dm.wx.WxConfigure;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages ="com.dm.linfen.root.repository")
@EntityScan
@Import(WxConfigure.class)
public class DataRootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataRootApplication.class, args);
    }

}
