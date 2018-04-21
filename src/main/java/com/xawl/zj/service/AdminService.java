package com.xawl.zj.service;

import com.xawl.zj.dao.TbAdminMapper;
import com.xawl.zj.pojo.TbAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private TbAdminMapper tbAdminMapper;

    public TbAdmin findByAccount(String account) {
        return tbAdminMapper.selectByPrimaryKey(account);
    }
}
