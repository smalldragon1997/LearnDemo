import React from 'react';
import {view as Editor} from './editor/';
import {view as Pay} from './pay/';
import {HashRouter,BrowserRouter, Route, NavLink, Switch,Redirect} from 'react-router-dom';

function App() {
    return (
        <HashRouter>
            <Switch>
                <Route path="/" exact component={Editor}/>
                <Route path="/pay" component={Pay}/>
            </Switch>
        </HashRouter>
    );
}

export default App;
