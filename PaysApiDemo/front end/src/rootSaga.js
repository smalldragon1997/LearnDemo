import { fork,all } from "redux-saga/effects";
import * as editorSaga from "./editor/Saga";
import * as paySaga from "./pay/Saga";

function* rootSaga() {
    /*The saga is waiting for a action called LOAD_DASHBOARD to be activated */
    yield [
        fork(editorSaga.watchUploadContent),
        fork(paySaga.watchfetchList),
    ];
}
export default rootSaga;