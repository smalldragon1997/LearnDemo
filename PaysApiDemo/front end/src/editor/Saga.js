import {call, put, takeEvery} from 'redux-saga/effects'
import * as Api from './Api';
import * as Actions from './Actions';
import * as ActionTypes from  './ActionTypes';

function* uploadContent(action) {
    try{
        yield put(Actions.inputSuccess(action.content));
    }catch (e){
        console.log(e);
    }
}

// 如果监听到Actions.inputUpdating操作 则使用uploadContent方法
export function* watchUploadContent() {
    yield takeEvery(ActionTypes.inputUpdating, uploadContent);
}
