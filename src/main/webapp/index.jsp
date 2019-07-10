<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<body>
<form action="transfer" method="post">
    转账账户<input type="text" name="accOutAccNo"><br>
    密    码<input type="text" name="accOutPassword"><br>
    金    额<input type="text" name="accOutBalance"><br>
    收款账号<input type="text" name="accInNo"><br>
    收款姓名<input type="text" name="accInName"><br>
    <input type="submit" value="转账">
</form>
</body>
</html>
