import * as Status from './Status';
import * as ActionTypes from './ActionTypes';

const initState = {
    list:[
        ,{orderid:"订单号",orderuid:"用户编号",price:"支付价格"}
    ], //初始化的列表内容为空
    status: Status.Success // ouutput的初始状态为载入成功状态
};

//初始化status为载入状态
export default (state = initState, action) => {
    switch (action.type) {
        case ActionTypes.fresh: {
            //开始转换
            return {status: Status.Loading};
        }
        case ActionTypes.success: {
            //转换并读取成功
            return { ...state, status: Status.Success, list:action.result};
        }
        default: return state;
    }
}