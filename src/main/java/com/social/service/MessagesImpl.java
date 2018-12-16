package com.social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

@Service
public class MessagesImpl implements Messages {

    @Autowired
    private MessageSource messageSource;

    private MessageSourceAccessor accessor;

    public MessagesImpl(MessageSource messageSource) {
        this.accessor = new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());
    }


    @Override
    public String getMessage(String id) {
        return accessor.getMessage(id);
    }
}
