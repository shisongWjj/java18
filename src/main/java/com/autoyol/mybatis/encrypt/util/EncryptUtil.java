package com.autoyol.mybatis.encrypt.util;

import com.autoyol.mybatis.encrypt.crypt.SimpleCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 加密工具类
 *
 */
public final class EncryptUtil {

    private static Logger log = LoggerFactory.getLogger(EncryptUtil.class);

    private static final String ENC_PREFIX = "ENC$";
    private static SimpleCrypt simpleCrypt = SimpleCrypt.INSTANCE;

    private EncryptUtil() {
        throw new UnsupportedOperationException();
    }

    public static boolean isEncrypted(String content) {
        return StringUtil.isNotEmpty(content) && content.startsWith(ENC_PREFIX);
    }

    /**
     * 加密。
     * @param content 明文
     * @return 密文
     */
    public static String encrypt(String content) {
        if (StringUtil.isEmpty(content) || isEncrypted(content)) {
            return content;
        }
        return ENC_PREFIX + simpleCrypt.encrypt(content);
    }

    /**
     * 解密。
     * @param content 密文
     * @return 明文
     */
    public static String decrypt(String content) {
        try {
            if (isEncrypted(content)) {
                return simpleCrypt.decrypt(StringUtil.stripStart(content, ENC_PREFIX));
            }
        } catch (Exception e) {
            log.warn("can't decrypt, turn to raw content : {}", content);
        }
        return content;
    }
}