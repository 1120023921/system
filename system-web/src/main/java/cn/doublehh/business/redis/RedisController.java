package cn.doublehh.business.redis;

import cn.doublehh.redis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 胡昊
 * Description:
 * Date: 18-6-3
 * Time: 下午4:42
 * Create: DoubleH
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private JedisClient jedisClient;

    @RequestMapping("/set")
    @ResponseBody
    public String set(String key,String val){
        return jedisClient.set(key, val);
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(String key){
        return jedisClient.get(key);
    }
}
