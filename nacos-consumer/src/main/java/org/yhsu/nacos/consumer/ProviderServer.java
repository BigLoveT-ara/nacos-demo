package org.yhsu.nacos.consumer;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "nacos-provider")
public interface ProviderServer {

    @RequestMapping(value = "/echo/{msg}", method = RequestMethod.GET)
    String getEcho(@PathVariable("msg") String msg);

}
