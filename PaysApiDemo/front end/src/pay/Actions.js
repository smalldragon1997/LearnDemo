import * as ActionType from  './ActionTypes';

export const success = (result) => ({
    type : ActionType.success,
    result
});
export const fresh = () => ({
    type : ActionType.fresh,
});