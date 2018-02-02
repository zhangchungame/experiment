package com.dandinglong.experiment.mapper;

import com.dandinglong.experiment.dto.MaStudent;
import com.dandinglong.experiment.util.MyMapper;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;

//public interface CrmActiveMapper extends MyMapper<CrmActive> {
//    @InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
//    @Options(useGeneratedKeys = true, keyProperty = "recId",keyColumn="rec_id")
//    int insert(CrmActive record);
//}

public interface MaStudentMapper extends Mapper<MaStudent> {
//    @InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
////    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn="id")
////    @Override
//    int insert(MaStudent record);

    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
    int insert(MaStudent record);

}
