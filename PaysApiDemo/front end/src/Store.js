import {createStore, applyMiddleware,combineReducers} from 'redux';
import createSagaMiddleware from 'redux-saga'
import {reducer as editorReducer} from './editor/';
import {reducer as payReducer} from './pay/';
import rootSaga from './rootSaga';
const reducer = combineReducers({
    editor:editorReducer,
    pay:payReducer
});
const sagaMiddleware = createSagaMiddleware();
const middlewares = [sagaMiddleware];
const store = createStore(reducer,applyMiddleware(...middlewares));
sagaMiddleware.run(rootSaga);

export default store;