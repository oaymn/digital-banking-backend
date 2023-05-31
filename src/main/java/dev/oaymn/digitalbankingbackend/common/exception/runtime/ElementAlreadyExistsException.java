package dev.oaymn.digitalbankingbackend.common.exception.runtime;

import lombok.Getter;

@Getter
public class ElementAlreadyExistsException extends BusinessException {

    public ElementAlreadyExistsException(String key, Object[] args) {
        super(key, args);
    }

}
