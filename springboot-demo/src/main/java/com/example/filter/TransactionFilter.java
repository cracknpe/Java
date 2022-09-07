package com.example.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@Slf4j
public class TransactionFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        log.info("Starting a transaction for req : {}" + req.getRequestURI());
        log.info("request url:" + req.getRequestURI());
        log.info("context path:" + req.getRequestURL());

        String result = forwardRequest(req.getRequestURL().toString());
        res.getWriter().println(result);
    }

    private String forwardRequest(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url.replaceAll("8080","7070"));
        CloseableHttpResponse response = null;
        String content = "";
        try{
            response = httpclient.execute(httpGet);
            content = EntityUtils.toString(response.getEntity(),"UTF-8");
            log.info(content);
        }finally {
            if (response != null)
                response.close();
            httpclient.close();
        }
        return content;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
