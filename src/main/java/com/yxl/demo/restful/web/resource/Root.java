package com.yxl.demo.restful.web.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * 根路径资源,用于展现欢迎页
 * author: xiaolong.yuanxl
 * date: 2015-05-13 下午1:35
 */
@Path("/")
public class Root extends BaseResource{

    private static final Logger LOG = LoggerFactory.getLogger(Root.class);

    @GET
    @Produces("application/json;charset=UTF-8")
    public Response welcome () {

        LOG.info("I am enter root resource ");

        return Response.ok().build();
    }

}
