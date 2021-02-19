package com.ssongwan.rpc.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloObject implements Serializable {

    private static final long serialVersionUID = -568056793788015176L;

    private Integer id;
    private String message;
}
