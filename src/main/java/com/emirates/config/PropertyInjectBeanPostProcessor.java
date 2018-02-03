package com.emirates.config;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.springframework.beans.BeansException;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.emirates.util.PropertiesUtils;

@Component
public class PropertyInjectBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    @Autowired
    private PropertiesUtils propertyPlaceholderConfigurer;

    private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        findPropertyAutowiringMetadata(bean);
        return true;
    }

    private void findPropertyAutowiringMetadata(final Object bean) {
        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
//                PropertyAutowired annotation = field.getAnnotation(PropertyAutowired.class);
//                if (annotation != null) {
//                    if (Modifier.isStatic(field.getModifiers())) {
//                        throw new IllegalStateException("PropertyAutowired annotation is not supported on static fields");
//                    }
//
//                    Object strValue = propertyPlaceholderConfigurer.getProps().get(annotation.name());
//
//                    if (strValue != null) {
//                        Object value = typeConverter.convertIfNecessary(strValue, field.getType());
//                        ReflectionUtils.makeAccessible(field);
//                        field.set(bean, value);
//                    }
//                }
            }
        });
        
    }
    
}
