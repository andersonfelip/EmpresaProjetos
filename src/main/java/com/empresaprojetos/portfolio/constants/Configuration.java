package com.empresaprojetos.portfolio.constants;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Configuration {
    @Value("${paging.page.number}")
    private Integer pageNumber;
    @Value("${paging.page.size}")
    private Integer pageSize;


}
