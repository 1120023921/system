package cn.doublehh.business.task;

import cn.doublehh.business.model.Stu;
import cn.doublehh.business.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 胡昊
 * Description:
 * Date: 18-6-1
 * Time: 下午3:16
 * Create: DoubleH
 */
@Controller
@RequestMapping("/stu")
public class StuController {

    @Autowired
    private StuService stuService;

    @Transactional
    @RequestMapping("/addStu")
    @ResponseBody
    public int addStu(Stu stu){
        Stu stu1 = stuService.getStu(stu);
        System.out.println(stu1);
        stu.setId(2);
        stuService.addStu(stu);
        return 1;
    }

    @RequestMapping("/addStu2")
    @ResponseBody
    public int addStu2(Stu stu){
        stuService.modStu2(stu);
        return 1;
    }
}
