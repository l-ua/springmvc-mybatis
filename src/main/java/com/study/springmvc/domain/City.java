package com.study.springmvc.domain;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City {

    private Integer id;

    private String name;


    private String countrycode;


    private String district;


    private Integer population;


}