package com.liyan.service;


import com.liyan.file.PageInfo;

public interface LogService {

    PageInfo findpaeg(int pageSize, int pageNumber) throws Exception;

}
