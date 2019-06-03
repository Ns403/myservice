
function submitForm() {
    $('#upload_form').form("submit",{
        url: "upload",
        onSubmit: function(param){
            // param.bdatajson = bdatajson;
            // param.deltime$('#del_date').datebox('getValue');
            var isValid = $(this).form('validate');
            if (!isValid){
                $.messager.progress('close');	// hide progress bar while the form is invalid
            }
            return isValid;	// return false will stop the form submission
        },
        success: function(){
            $.messager.progress('close');	// hide progress bar while submit successfully
        }
    })
}

function clearForm() {
    $('#ff').form('reset');
}

/**
 * 上传文件同步文件名
 * @param newValue
 * @param oldValue
 */
function fileOperating(newValue, oldValue) {
    if ($('#file_name_id').textbox('getValue') === "") {
        $('#file_name_id').textbox('setValue', newValue)
    }
    var date = new Date();
    // console.log(date.getFullYear());
    var strDate = date.getFullYear()+"-";
    strDate += date.getMonth()+1+"-";
    strDate += date.getDate();

    $('#del_date').datebox('setValue',strDate );
}

/**
 * 设置日期格式，与解析格式
 * @param date
 * @returns {string}
 */
function myformatter(date) {
    var y = date.getFullYear();
    var m = date.getMonth();
    var d = date.getDate();
    return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
}

function myparser(s) {
    if (!s) return new Date();
    var ss = (s.split('-'));
    var y = parseInt(ss[0], 10);
    var m = parseInt(ss[1], 10);
    var d = parseInt(ss[2], 10);
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
        return new Date(y, m+1, d);
    } else {
        return new Date();
    }
}
