package com.xuwenxing.bbtv.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter@Getter@AllArgsConstructor
@NoArgsConstructor
public class AjaxResult {
    private boolean success = true;
    private String message;

}
