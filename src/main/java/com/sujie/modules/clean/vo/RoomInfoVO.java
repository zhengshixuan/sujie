package com.sujie.modules.clean.vo;

import com.sujie.modules.clean.entity.RoomInfoEntity;
import lombok.Data;

/**
 * @Author travel
 */
@Data
public class RoomInfoVO  extends RoomInfoEntity{
    private String roomTypeName;

    private String homestayName;

    private String homestayAddress;
}
