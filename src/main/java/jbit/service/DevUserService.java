package jbit.service;

import jbit.mapper.DevUserMapper;
import jbit.pojo.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DevUserService {

    @Resource
    private DevUserMapper devUserMapper;

    public DevUser queryByUser(String devcode, String devpassword){
        DevUser devUser = new DevUser();
        devUser.setDevcode(devcode);
        devUser.setDevpassword(devpassword);
        return devUserMapper.selectOne(devUser);
    }

}
