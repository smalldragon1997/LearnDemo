import React from 'react';
import Input from './Input';
import Output from './Output';
import {Row,Col } from 'antd';
import {Route, NavLink, Switch,Redirect} from 'react-router-dom';

export default ()=>(
    <div>
        <NavLink to={"/pay"}>pay</NavLink>
        <Row type="flex" justify="space-around">
            <Col span={10}>
                <div><h1>React-UMEDITOR Markdown</h1></div>
                <Input/>
            </Col>
            <Col span={10}>
                <div><h1>html预览窗口</h1></div>
                <Output/>
            </Col>
        </Row>
    </div>
)