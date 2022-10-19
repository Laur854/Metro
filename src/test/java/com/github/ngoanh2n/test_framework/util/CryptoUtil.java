package com.github.ngoanh2n.test_framework.util;

import com.github.ngoanh2n.test_framework.exceptions.FrameworkException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;

import java.io.UnsupportedEncodingException;

/**
 * Class contains methods related to encrypting and decrypting data, generating hash etc.
 */
public class CryptoUtil {

    private static final URLCodec CODEC = new URLCodec();

    /**
     * @see URLCodec#encode(String, String)
     */
    public static String urlEncode(String url) {
        try {
            return CODEC.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new FrameworkException("Failed to encode url: " + url);
        }
    }

    /**
     * @see URLCodec#decode(String, String)
     */
    public static String urlDecode(String url) {
        try {
            return CODEC.decode(url, "UTF-8");
        } catch (DecoderException | UnsupportedEncodingException e) {
            throw new FrameworkException("Failed to decode url: " + url);
        }
    }
}
