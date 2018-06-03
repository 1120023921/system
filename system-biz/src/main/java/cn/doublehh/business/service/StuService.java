package cn.doublehh.business.service;

import cn.doublehh.business.model.Stu;

/**
 * @author 胡昊
 * Description:
 * Date: 18-6-1
 * Time: 下午3:14
 * Create: DoubleH
 */
public interface StuService {

    int addStu(Stu stu);

    int updateStu(Stu stu);

    int modStu(Stu stu);

    int modStu2(Stu stu);

    Stu getStu(Stu id);
}
