package com.regression.modules;

import com.regression.vo.IShipmentDataVo;

public interface IPrepare<V extends IShipmentDataVo> {

    V prepare();

}
