package com.cn.supplierperformancetransfer.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约转派表(SupplierPerformanceTransfer)
 *
 * @author makejava
 * @since 2023-03-13 14:39:55
 */
@Description(value = "履约转派表")
@RestController
@RequestMapping("/supplierPerformanceTransfer")
public class SupplierPerformanceTransferController {

    @GetMapping("/test")
    public Object add(){
        return "你好";
    }

}
