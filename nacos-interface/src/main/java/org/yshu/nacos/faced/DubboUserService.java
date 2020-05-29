package org.yshu.nacos.faced;

import org.yshu.nacos.faced.dto.UserDTO;

import java.util.List;

public interface DubboUserService {

    void addUser(String userName, int male);

    UserDTO queryById(Long id);

    void deleteById(Long id);

    List<UserDTO> findAll();
}
