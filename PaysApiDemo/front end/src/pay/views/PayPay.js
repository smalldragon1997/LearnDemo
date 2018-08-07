import React from 'react';
import {connect} from 'react-redux';
import * as Actions from '../Actions';

class PayPay extends React.Component {
    // 渲染组件
    render() {
        return (
            <div>
                <div><h1>输入支付信息</h1></div>
                <form action="https://pay.bbbapi.com/" method="post">
                    <input type="hidden" name="uid" value="a6fb395e410421b00431fdc7"/>
                    <input type="text" name="price" placeholder="price"/>
                    <select name="istype">
                        <option value="2">微信</option>
                        <option value="1">支付宝</option>
                    </select>
                    <input type="text" name="notify_url" placeholder="notify_url"/>
                    <input type="text" name="return_url" placeholder="return_url"/>
                    <input type="text" name="orderid" placeholder="orderid"/>
                    <input type="text" name="orderuid" placeholder="orderuid"/>
                    <input type="text" name="goodsname" placeholder="goodsname"/>
                    <input type="text" name="key" placeholder="key"/>
                    <input type="submit" value="提交支付"/>
                </form>
            </div>
        )
    }
}


export default PayPay;