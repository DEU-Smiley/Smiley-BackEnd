package com.smiley.smileybackend._05_hospital.domain.keys;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospitalkeys implements Serializable {
    private boolean isPartner;
    private String hPid;
}
