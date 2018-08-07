export const Icons = [
    "source | undo redo | bold italic underline strikethrough fontborder | ",
    "paragraph fontfamily fontsize | superscript subscript | ",
    "forecolor backcolor | removeformat | insertorderedlist insertunorderedlist | selectall | ",
    "cleardoc  | indent outdent | justifyleft justifycenter justifyright | touppercase tolowercase | ",
    "horizontal date time  | image formula spechars | inserttable"
];
// 注意上传接口的返回值，应该是 {'data': {'image_src': xxx} , 'status':'success'}
export const DefaultUploader = {
    url:'/SSMP/uploadImg',
    type:"local",
    name:"file",
    request: "image_src"
};