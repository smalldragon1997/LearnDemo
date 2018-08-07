import React from 'react';
import PayPay from './PayPay';
import PayInfo from './PayInfo';
import {Row,Col } from 'antd';
import {Route, NavLink, Switch,Redirect} from 'react-router-dom';

const Nav =() => (
    <div>
        <NavLink to={"/"}>信息填写</NavLink>
        <NavLink to={"/pay/info"}>信息查看</NavLink>
    </div>
);

export default ({match})=>(
        <div>
        <Row type="flex" justify="space-around">
            <Nav/>
        </Row>
        <Row type="flex" justify="space-around">
            <Col span={10}>
                <Switch>
                    <Route path={match.path} exact component={PayPay}/>
                    <Route path={match.path+"/info"} component={PayInfo}/>
                </Switch>
            </Col>
        </Row>

    </div>
)