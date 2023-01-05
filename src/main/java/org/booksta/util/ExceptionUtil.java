package org.booksta.util;

import org.booksta.config.ExceptionMessageConfig;
import org.booksta.domain.common.BookstaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;

@Component
public class ExceptionUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionUtil.class);

    @Autowired
    private ExceptionMessageConfig loader;
    private static ExceptionMessageConfig sLoader;

    @PostConstruct
    public void registerInstance() {
        this.sLoader  = loader;
    }

    public ExceptionUtil() {
    }

    public static BookstaException creatBookstaBizException(String errorCode){
        return new BookstaException(errorCode, generateMessage(errorCode));
    }
    
    public static <T> BookstaException creatBookstaBizException(String errorCode, T param) {
    	return creatBookstaBizException(errorCode, new String[] { String.valueOf(param) });
    }

    public static BookstaException creatBookstaBizException(String errorCode, Object[] params) {
        return new BookstaException(errorCode, generateMessage(errorCode, params));
    }

    public static String generateMessage(String errorCode) {
        return generateMessage(errorCode, (Object[])null);
    }

    public static String generateMessage(String errorCode, Object[] params) {
        String errorMessage = getErrorMessage(errorCode);
        if (errorMessage == null) {
            return null;
        } else {
            if (params != null) {
                errorMessage = applyFormat(errorMessage, params);
            }
            return errorMessage;
        }
    }

    private static String applyFormat(String errorMessage, Object[] params) {
        MessageFormat mf = new MessageFormat(errorMessage);
        return mf.format(params);
    }
    
    private static String getErrorMessage(String errorCode) {
        String exMessage = (String)sLoader.loadMessages().get(errorCode);
        return exMessage != null ? exMessage : null;
    }
}
