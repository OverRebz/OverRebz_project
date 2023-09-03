package com.example.swaredemo1.Bean.drilldownData;


import lombok.Data;

import java.util.List;

@Data
public class drilldownData {
    String dataGroupId;
    List<Object[]> data;

}
