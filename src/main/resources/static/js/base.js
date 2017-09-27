//日期转Str
function toDDMMMYYYY(date) {
    var yyyy = date.getFullYear().toString();
    var mm = date.getMonth() < 9 ? "0" + (date.getMonth() + 1) : (date.getMonth() + 1).toString();
    var dd = date.getDate() < 10 ? "0" + date.getDate() : date.getDate().toString();
    return yyyy + "-" + mm + "-" + dd;
}