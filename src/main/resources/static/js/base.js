//日期转Str
function toDDMMMYYYY(date) {
    var yyyy = date.getFullYear().toString();
    var mm = date.getMonth() < 9 ? "0" + (date.getMonth() + 1) : (date.getMonth() + 1).toString();
    var dd = date.getDate() < 10 ? "0" + date.getDate() : date.getDate().toString();
    return yyyy + "-" + mm + "-" + dd;
}

//去除前後空格
String.prototype.mytrim = function () {
    // 用正则表达式将前后空格
    // 用空字符串替代。
    return this.replace(/(^\s*)|(\s*$)/g, "");
};