package wzp.study.mybatis.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wangzhiping on 2018/9/8.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {

    String code;
    String message;
    T data;
}
