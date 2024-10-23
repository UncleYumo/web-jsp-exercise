var links = document.getElementsByClassName("link");
for (let i = 0; i < links.length; i++) {
    var gid = links[i].getAttribute("id");
    links[i].href = "javascript:void(0);onClick=addtocart(" + gid + ")";
}
function addtocart(gid) {
    var num = document.getElementsByName(gid)[0].value;
    window.location.href = "AddCartServlet?gid=" + gid + "&gcount=" + num;
}