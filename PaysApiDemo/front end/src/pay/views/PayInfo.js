import React from 'react';
import {connect} from 'react-redux';
import * as Actions from '../Actions';
import * as Status from '../Status';

class PayInfo extends React.Component {
    constructor(props) {
        super(props);
        this.props.onFresh();
    }


    // 渲染组件
    render() {
        switch (this.props.status) {
            case Status.Success:
                return (
                    <div>
                        <div><h1>已经支付的订单信息：</h1></div>
                        <table border={"1"}>
                            <tbody>
                            <tr>
                                <th>订单号</th>
                                <th>用户ID</th>
                                <th>支付金额</th>
                            </tr>
                            {

                                this.props.list.map(function (item) {
                                    return (

                                        <tr>
                                            <td key={`${Date.now()}`}>{item.orderid}</td>
                                            <td>{item.orderuid}</td>
                                            <td>{item.price}</td>
                                        </tr>)
                                })

                            }
                            </tbody>
                        </table>
                        <button onClick={this.props.onFresh}>刷新</button>
                    </div>
                );
            case Status.Loading:
                return (
                    <div>
                        加载中...
                        <button onClick={this.props.onFresh}>刷新</button>
                    </div>
                );
            default:
                throw new Error('unexcepted status ' + this.props.status);
        }
    }
}

// props绑定dispatch
const mapDispatchToProps = (dispatch) => {
    return {
        onFresh: () => {
            dispatch(Actions.fresh());
        }
    }
};

// props绑定state
const mapStateToProps = (state) => {
    state = state.pay;
    return {
        status: state.status,
        list: state.list
    }
};
export default connect(mapStateToProps, mapDispatchToProps)(PayInfo);