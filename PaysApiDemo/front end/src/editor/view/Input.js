import 'react-quill/dist/quill.snow.css';
import React from 'react';
import {connect} from 'react-redux';
import * as Actions from '../Actions';
import Editor from 'react-umeditor';
import  * as EditorProps from '../EditorProps';

class Input extends React.Component {
    constructor(props){
        super(props);
        this.state = { // 编辑器初始状态为空
            content:""
        };
        this.handleFormChange = this.handleFormChange.bind(this);
        this.handleSubmitForm = this.handleSubmitForm.bind(this);
    }
    // 编辑器内容改变事件
    handleFormChange(content){
        this.props.onTextChange(this.refs.editor.getContent());
    }
    // 上传保存到服务器
    handleSubmitForm(){

    }
    // 渲染组件
    render() {
        // 编辑器Icons
        let icons = EditorProps.Icons;

        // 上传图片使用自定义配置
        let plugins = {
            image:{
                uploader:EditorProps.DefaultUploader
            }
        };

        return (
            <div>
            <Editor ref="editor"
                    icons={icons}
                    plugins={plugins}
                    value={this.state.content}
                    onChange={this.handleFormChange}/>
            <input type="submit" value="提交" onClick={this.handleSubmitForm} />
        </div>
        )
    }
}

// props绑定dispatch
const mapDispatchToProps = (dispatch) => {
    return {
        onTextChange: (content) => {
            dispatch(Actions.inputUpdating(content));
        }
    }
};


export default connect(null, mapDispatchToProps)(Input);