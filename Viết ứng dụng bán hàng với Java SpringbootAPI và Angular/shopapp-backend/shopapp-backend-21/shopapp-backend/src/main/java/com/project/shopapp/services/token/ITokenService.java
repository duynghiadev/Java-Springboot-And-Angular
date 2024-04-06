package com.project.shopapp.services.token;

import com.project.shopapp.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public interface ITokenService {
    void addToken(User user,String token, boolean isMobileDevice);
}
