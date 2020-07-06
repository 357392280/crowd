<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<%--    base标签的使用--%>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <title>$Title$</title>
</head>
<body>
<a href="/test/aaa/bbb/ccc.html"> 测试连接</a>
<a href="/admin/to/login/page.html">测试连接2</a>
<a href="admin/do/login.html">测试连接3</a>
</body>
</html>