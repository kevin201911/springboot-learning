package com.mscloudmesh.springbootcanal.annotation;



import com.mscloudmesh.springbootcanal.config.CanalClientConfiguration;
import com.mscloudmesh.springbootcanal.properties.CanalProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启 Canal 客户端
 *
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CanalProperties.class, CanalClientConfiguration.class})
public @interface EnableCanalClient {
}