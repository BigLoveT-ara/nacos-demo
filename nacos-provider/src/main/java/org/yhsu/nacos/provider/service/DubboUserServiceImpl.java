package org.yhsu.nacos.provider.service;

import org.apache.dubbo.config.annotation.Service;
import org.yshu.nacos.faced.DubboUserService;
import org.yshu.nacos.faced.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class DubboUserServiceImpl implements DubboUserService {
    private static AtomicLong USER_ID_SEQ = new AtomicLong();

    private Map<Long, UserDTO> MEMORY_DB = new ConcurrentHashMap<Long, UserDTO>();


    @Override
    public void addUser(String userName, int male) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(USER_ID_SEQ.incrementAndGet());
        userDTO.setName(userName);
        userDTO.setMale(1);
        MEMORY_DB.put(userDTO.getId(), userDTO);
    }

    @Override
    public UserDTO queryById(Long id) {
        if (MEMORY_DB.containsKey(id)) {
            return MEMORY_DB.get(id);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        if (MEMORY_DB.containsKey(id)) {
            MEMORY_DB.remove(id);
        }
    }

    @Override
    public List<UserDTO> findAll() {
        if (MEMORY_DB.size() <= 0) {
            return null;
        }
        List<UserDTO> dtos = new ArrayList<>();
        MEMORY_DB.values().forEach(t -> {
            dtos.add(t);
        });
        return dtos;
    }
}
