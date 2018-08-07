import {call, put, takeEvery} from 'redux-saga/effects'
import * as Api from './Api';
import * as Actions from './Actions';
import * as ActionTypes from  './ActionTypes';

function* fetchList(action) {
    try{
        const data = yield call(Api.fetchList);
        yield put(Actions.success(data));
    }catch (e){
        console.log(e);
    }
}

// 如果监听到ActionTypes.fresh操作 fetchList
export function* watchfetchList() {
    yield takeEvery(ActionTypes.fresh, fetchList);
}
