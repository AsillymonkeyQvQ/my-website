window.onload = function() {

    var contextPath = getContextPath();

    var articles = document.getElementsByClassName("article");
    for(var i = 0; i < articles.length; i++) {
        var article = articles[i];
        article.onclick = function() {
            var articleId = this.getAttribute("data-article-id");
            window.location.href = contextPath + "/article/" + articleId;
            return false;
        }
    }

    function getContextPath() {
        var ctx = document.getElementById("ctx");
        return ctx.textContent;
    }

}