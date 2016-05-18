package ru.ekonomov.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected String[] getServletMappings()
    {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class<?>[] { RootConfig.class };
    }
    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class<?>[] { WebConfig.class };
    }

    @Override
    protected Filter[] getServletFilters()
    {
        return new Filter[]{new FormEncodingSetterFilter()};
    }
}
