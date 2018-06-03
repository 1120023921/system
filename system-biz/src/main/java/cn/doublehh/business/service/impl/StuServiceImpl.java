package cn.doublehh.business.service.impl;

import cn.doublehh.business.dao.StuMapper;
import cn.doublehh.business.model.Stu;
import cn.doublehh.business.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 胡昊
 * Description:
 * Date: 18-6-1
 * Time: 下午3:15
 * Create: DoubleH
 */
@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    public int addStu(Stu stu) {
        return stuMapper.insert(stu);
    }

    @Override
    public int updateStu(Stu stu) {
        return stuMapper.updateByPrimaryKey(stu);
    }

    @Transactional
    @Override
    public int modStu(Stu stu) {
        addStu(stu);
        return 1;
    }

    @Override
    public int modStu2(Stu stu) {
        addStu(stu);
        stu.setName("ttt");
        updateStu(stu);
        return 0;
    }

    @Override
    public Stu getStu(Stu id) {
        return stuMapper.selectByPrimaryKey(id);
    }


}
