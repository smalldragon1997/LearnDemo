import axios from 'axios';

export const fetchList = () => {
    return new Promise(function (resolve, reject) {
        axios.post('/SSMP/fetchPayList'
        ).then(function (res) {
            // 正确返回信息 将返回信息传回
            if(res.status===200){
                console.log(res.data);
                resolve(res.data.data);
            }
            reject();
        }).catch(function (error) {
            // 打印错误信息
            console.log(error);
            reject();
        });
    });
};