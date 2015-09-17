package com.yxl.demo.restful.web.resource;

import com.sun.jersey.spi.container.ContainerRequest;
import com.yxl.demo.restful.dataobject.DemoDO;
import com.yxl.demo.restful.util.CommonUtil;
import com.yxl.demo.restful.web.provider.DemoProvider;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * demo资源
 *
 * author: xiaolong.yuanxl
 * date: 2015-09-17 上午10:52
 */
@Path("/demo")
public class Demo extends BaseResource {

    private static final Logger LOG = LoggerFactory.getLogger(Demo.class);

    @Resource
    private DemoProvider demoProvider;

    /**
     * 根路径资源
     */
    @GET
    @Produces("application/json;charset=UTF-8")
    public Response list(@QueryParam("userId") String userId) {
        if (StringUtils.isBlank(userId)) {
            LOG.warn("forbid access without userId!");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        List<DemoDO> ObjList = demoProvider.mock();
        return Response.ok(ObjList).build();
    }

    /**
     * 根路径资源
     */
    @GET
    @Path("/all")
    @Produces("application/json;charset=UTF-8")
    public Response listAll(@QueryParam("userId") String userId) {
        if (StringUtils.isBlank(userId)) {
            LOG.warn("forbid access without userId!");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        List<DemoDO> ObjList = demoProvider.mock();
        return Response.ok(ObjList).build();
    }


    /**
     * 一级资源到二级资源也存在跨域,因此需要写二级资源
     */
    @OPTIONS
    @Path("/all")
    public Response options(@Context final Request requestContext){
        return Response.ok().build();
    }


    /**
     * 子路径资源
     */
    @GET
    @Path("/{demoId}")
    public Response selectById(@PathParam("demoId") Long demoId) {
        if (demoId == null || demoId.longValue() <= 0) {
            LOG.warn("forbid access without demo id!");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        DemoDO obj = demoProvider.mockOne(demoId);
        return Response.ok(obj).build();
    }

    @PUT
    @Consumes("application/x-www-form-urlencoded;charset=UTF-8")
    @Produces("application/json;charset=UTF-8")
    public Response update(@Context final Request requestContext) {
        ContainerRequest request = (ContainerRequest) requestContext;
        String body = CommonUtil.asString(request.getEntityInputStream());
        try {
            JSONObject jsonObject = JSONObject.fromObject(body);
            Long demoId = jsonObject.getLong("demoId");

            if (demoId == null) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }

            demoProvider.update();
        } catch (Exception e) {
            LOG.error("process HTTP PUT in Demo.java happend error: ", e);
        }
        return Response.ok().build();
    }

    @POST
    @Consumes("application/x-www-form-urlencoded;charset=UTF-8")
    @Produces("application/json;charset=UTF-8")
    public Response insert(@Context final Request requestContext) {
        // 1. get request body
        ContainerRequest request = (ContainerRequest) requestContext;
        String body = CommonUtil.asString(request.getEntityInputStream());
        // 2. trans body to Json for each field
        try {
            JSONObject jsonObject = JSONObject.fromObject(body);
            String userId = jsonObject.getString("userId");

            if (StringUtils.isBlank(userId)) {
                LOG.warn("forbid access without userId!");
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            // 3. create apply
            demoProvider.create();
        } catch (Exception e) {
            LOG.error("process HTTP POST in Demo.java happend error: ", e);
        }
        return Response.ok().build();
    }

    @DELETE
    @Consumes("application/x-www-form-urlencoded;charset=UTF-8")
    @Produces("application/json;charset=UTF-8")
    public Response delete(@Context final Request requestContext) {
        // 1. get request body
        ContainerRequest request = (ContainerRequest) requestContext;
        String body = CommonUtil.asString(request.getEntityInputStream());
        try {
            JSONObject jsonObject = JSONObject.fromObject(body);
            Long demoId = jsonObject.getLong("demoId");
            LOG.info("access Demo.java DELETE method demoId: " + demoId);
            demoProvider.delete();
        } catch (Exception e) {
            LOG.error("delete apply happened error", e);
        }
        return Response.ok().build();
    }

}
