package com.yxl.demo.restful.web.provider;

import com.yxl.demo.restful.dataobject.DemoDO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 服务提供者
 *
 * author: xiaolong.yuanxl
 * date: 2015-09-17 上午10:54
 */
public class DemoProvider {

    public List<DemoDO> mock(){
        List<DemoDO> list = new ArrayList<DemoDO>();
        list.add(getOne());
        list.add(getOne());
        return list;
    }

    public DemoDO mockOne(Long id){
        DemoDO demoDO = getOne();
        demoDO.setId(id);
        return demoDO;
    }

    public void update(){
        //mock
    }

    public void create(){
        //mock
    }

    public void delete(){
        //mock
    }


    private DemoDO getOne(){
        Random random = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DemoDO demoDO = new DemoDO();
        demoDO.setId(Math.abs(random.nextLong()) % 1000);
        demoDO.setGmtCreated(sdf.format(new Date()));
        demoDO.setGmtCreator("mock");
        demoDO.setGmtModified(sdf.format(new Date()));
        demoDO.setGmtModifier("mock");
        return demoDO;
    }


}
