package com.dandinglong.experiment.mapper;

import com.dandinglong.experiment.dto.MaGujie;
import com.dandinglong.experiment.dto.MaStudent;
import com.dandinglong.experiment.util.MyMapper;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;

public interface MaGujieMapper extends MyMapper<MaGujie>{


    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
    int insert(MaGujie record);
}
