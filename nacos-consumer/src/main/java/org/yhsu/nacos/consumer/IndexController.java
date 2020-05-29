package org.yhsu.nacos.consumer;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yshu.nacos.faced.DubboUserService;
import org.yshu.nacos.faced.dto.UserDTO;

import java.util.List;

@RestController
@RequestMapping("/callecho")
public class IndexController {

    @Autowired
    private ProviderServer providerServer;

    @Reference(protocol = "dubbo")
    private DubboUserService dubboUserService;

    @GetMapping("/{msg}")
    public String callProvierEcho(@PathVariable("msg") String msg) {
        return providerServer.getEcho(msg);
    }

    @GetMapping("/addUser/{name}/{male}")
    public String addUser(@PathVariable("name") String name, @PathVariable("male") int male) {
        dubboUserService.addUser(name, male);
        return "SUCCESS";
    }

    @GetMapping("/findAll")
    public List<UserDTO> findAll() {
        return dubboUserService.findAll();
    }
}
