package com.lcydream.project.restonspringmvc.http.media;

import org.springframework.http.MediaType;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * CustomMediaType
 * 自定义描述消息类型
 * {@link org.springframework.http.MediaType}
 * @author Luo Chun Yun
 * @date 2018/11/22 14:07
 */
public class CustomMediaType extends MediaType implements Serializable {

    private static final long serialVersionUID = 2069937152339679641L;

    /**
     *  Public constant media type for {@code application/properties+person}.
     */
    public static final MediaType APPLICATION_ATOM_PERSON_PROPERTIES;

    /**
     * A String equivalent of {@link CustomMediaType#APPLICATION_ATOM_PERSON_PROPERTIES}.
     */
    public static final String APPLICATION_ATOM_PERSON_PROPERTIES_VALUE = "application/properties+person";

    static {
        APPLICATION_ATOM_PERSON_PROPERTIES = valueOf(APPLICATION_ATOM_PERSON_PROPERTIES_VALUE);
    }

    public CustomMediaType(String type) {
        super(type);
    }

    public CustomMediaType(String type, String subtype) {
        super(type, subtype);
    }

    public CustomMediaType(String type, String subtype, Charset charset) {
        super(type, subtype, charset);
    }

    public CustomMediaType(String type, String subtype, double qualityValue) {
        super(type, subtype, qualityValue);
    }

    public CustomMediaType(MediaType other, Charset charset) {
        super(other, charset);
    }

    public CustomMediaType(MediaType other, Map<String, String> parameters) {
        super(other, parameters);
    }

    public CustomMediaType(String type, String subtype, Map<String, String> parameters) {
        super(type, subtype, parameters);
    }
}
