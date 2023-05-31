package dev.oaymn.digitalbankingbackend.common.exception.runtime;

import lombok.Getter;

@Getter
public class ElementNotFoundException extends BusinessException {

    public ElementNotFoundException(String key, Object[] args) {
        super(key, args);
    }

}
