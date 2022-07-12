package bimapap.spring.core.service;

import bimapap.spring.core.data.User;
import bimapap.spring.core.event.LoginSuccessEvent;
import bimapap.spring.core.listener.LoginSuccessListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private LoginSuccessListener loginSuccessListener;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public boolean login(String username, String password){
        if (isLoginSuccess(username,password)){
            applicationEventPublisher.publishEvent(new LoginSuccessEvent(new User(username)));
//            loginSuccessListener.onApplicationEvent(new LoginSuccessEvent(new User(username)));
            return true;
        }else{
            return false;
        }

    }

    private boolean isLoginSuccess(String username, String password) {
        return "bima".equals(username) && "bima".equals(password);
    }
}
