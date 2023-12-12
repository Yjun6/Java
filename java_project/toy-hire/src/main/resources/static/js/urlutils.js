//根据key获取url中的value
function getParamValue(key) {
    //1.得到当前url的参数部分
    var params = location.search;
    //2.去除 ?
    if (params.indexOf("?") >= 0) {
        params = params.substring(1);
        //3.根据 & 分割参数
        var paramArray = params.split("&");
        //4.对比key，返回value
        if (paramArray.length >= 1) {
            for (var i = 0; i < paramArray.length; i++) {
                //key = value
                var item = paramArray[i].split("=");
                if (item[0] == key) {
                    return item[1];
                }
            }
        }
    }
    return null;
} 