package com.feiduyang.web.service.impl.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.feiduyang.api.sys.IDictTypeService;
import com.feiduyang.common.entity.sys.DictType;
import com.feiduyang.common.support.CrudServiceImpl;
import com.feiduyang.common.vo.ResponseInfo;
import com.feiduyang.web.dao.sys.DictTypeMapper;
import org.springframework.stereotype.Service;

/**
 * @description: 基础字典类型服务实现类
 * @copyright:
 * @createTime: 2017-09-12 17:18:46
 * @author: dzy
 * @version: 1.0
 */
@Service
public class DictTypeServiceImpl extends CrudServiceImpl<DictTypeMapper, DictType, Long> implements IDictTypeService {

    @Override
    protected ResponseInfo createBefore(DictType m) {
        ResponseInfo result = new ResponseInfo();
        EntityWrapper ew = new EntityWrapper<DictType>();
        ew.eq("identity", m.getIdentity());
        if (selectCount(ew) > 0) {
            result.setMessage("标识重复，请重新输入");
            return result;
        }
        EntityWrapper ew1 = new EntityWrapper<DictType>();
        ew1.eq("name", m.getName());
        if (selectCount(ew1) > 0) {
            result.setMessage("分类名重复，请重新输入");
            return result;
        }
        return null;
    }
}
