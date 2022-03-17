package example;

import org.springframework.cloud.sleuth.TraceContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter
public class SleuthAttrsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Stores Spring Cloud Sleuth attributes for logging by logback-access-spring-boot-starter
        TraceContext context = (TraceContext) request.getAttribute(TraceContext.class.getName());
        request.setAttribute(SleuthAttrsFilter.class.getName() + ".traceId", context.traceId());
        request.setAttribute(SleuthAttrsFilter.class.getName() + ".spanId", context.spanId());
        chain.doFilter(request, response);
    }

}
